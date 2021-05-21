package CRUDClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddDataToTable {
    Connection connection;

    public AddDataToTable(Connection connection) {
        this.connection = connection;
    }

    // метод для добавления новой строки
    public void InsertToTable() {
        try {
            System.out.println("Введите данные (ID, name, dayOfBirth):");
            // SQL-запрос на внесение данных в таблицу
            String sql = "Insert into test2(id,name,dayofbirth) values (?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            // устанавливаем в нужную позицию (на места знаков ?) значения нужного типа
            statement.setInt(1, new Scanner(System.in).nextInt());
            statement.setString(2, new Scanner(System.in).nextLine());
            statement.setString(3, new Scanner(System.in).nextLine());

            // выполняем запрос (возвращает количество измененных или добавленных строк)
            int rows = statement.executeUpdate();
            // проверяем, добавилась ли строка
            if (rows >= 1)
                System.out.println("Добавлено строк: " + rows);
            else
                System.out.println("Строка не была добавлена");

            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
