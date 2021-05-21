package CRUDClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDataByID {
    Connection connection;

    public UpdateDataByID(Connection connection) {
        this.connection = connection;
    }

    // метод для изменения строки по ID
    public void updateDataInRow() {
        int id = 0;
        System.out.println("Введите ID строки");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt())
            id = scanner.nextInt();
        System.out.println("Введите данные (name, dayOfBirth):");
        String sql = "Update test2 set name = ?, dayofbirth = ? where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, new Scanner(System.in).nextLine());
            statement.setString(2, new Scanner(System.in).nextLine());
            statement.setInt(3, id);

            // выполняем запрос (возвращает количество измененных или добавленных строк)
            int rows = statement.executeUpdate();
            // проверяем, добавилась ли строка
            if (rows >= 1)
                System.out.println("Обновлено строк: " + rows);
            else
                System.out.println("Строка не была обновлена");

            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
