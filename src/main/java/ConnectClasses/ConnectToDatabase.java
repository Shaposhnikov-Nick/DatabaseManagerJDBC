package ConnectClasses;

import AccessClasses.AccessData;
import AccessClasses.GetAccessData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectToDatabase {
    AccessData accessData;
    Connection connection;
    GetAccessData getAccessDate;

    public ConnectToDatabase(AccessData accessData, GetAccessData getAccessData) {
        this.accessData = accessData;
        this.getAccessDate = getAccessData;
    }

    // соединение с БД
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(getAccessDate.getUrl());
            if (connection == null)
                System.out.println("Не удалось соединиться с БД " + getAccessDate.getDATABASENAME());
            else
                System.out.println("Успешное соединение с БД " + getAccessDate.getDATABASENAME());
        } catch (SQLException throwables) {
            System.out.println("Не удалось соединиться с БД " + getAccessDate.getDATABASENAME());
            throwables.printStackTrace();
        }
        return connection;
    }
}
