package CRUDClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDataByID {
    Connection connection;

    public DeleteDataByID(Connection connection) {
        this.connection = connection;
    }

    // метод для удаления данных по ID строки
    public void deleteRow() {
        int id = 0;
        System.out.println("Введите ID строки, которую требуется удалить");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt())
            id = scanner.nextInt();
        String sql = "delete from test2 where id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            // выполняем запрос
            int rows = statement.executeUpdate();
            // проверяем, добавилась ли строка
            if (rows >= 1)
                System.out.println("Удалено строк: " + rows);
            else
                System.out.println("Строка не была удалена");

            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
