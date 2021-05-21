package CRUDClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowTable {
    Connection connection;

    public ShowTable(Connection connection) {
        this.connection = connection;
    }

    // метод, показывающий таблицу
    public void showAllTable() {
        String sql = "Select * from test2";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.printf("ID %d, name %s, dayOfBirth %s\n", resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("dayOfBirth"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

