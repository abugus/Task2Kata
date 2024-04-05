package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();

            userService.createUsersTable();
            System.out.println("Таблица создана");

            userService.saveUser("Name1", "LastName1", (byte) 20);
            System.out.println("User с именем — Name1 добавлен в базу данных");

            userService.saveUser("Name2", "LastName2", (byte) 25);
            System.out.println("User с именем — Name2 добавлен в базу данных");

            userService.saveUser("Name3", "LastName3", (byte) 31);
            System.out.println("User с именем — Name3 добавлен в базу данных");

            userService.saveUser("Name4", "LastName4", (byte) 38);
            System.out.println("User с именем — Name4 добавлен в базу данных");

            System.out.println(userService.getAllUsers());

            userService.cleanUsersTable();
            System.out.println("Очистка таблицы User(ов) прошла успешно");

            userService.dropUsersTable();
            System.out.println("Удаление таблицы users прошло успешно");

            Util.closeConnection();
    }
}
