import AccessClasses.AccessData;
import AccessClasses.GetAccessData;
import CRUDClasses.AddDataToTable;
import CRUDClasses.DeleteDataByID;
import CRUDClasses.ShowTable;
import CRUDClasses.UpdateDataByID;
import ConnectClasses.ConnectToDatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Connection connection;

    public static void main(String[] args) {
        // создаем подключение к БД
        connection = createConnection();

        // основной модуль
        showMenu();

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void showMenu() {
        boolean isRun = true;
        Scanner scanner = new Scanner(System.in);

        while (isRun) {
            int choice = 0;
            System.out.println("\nВыберите действие:\n1.Просмотреть всю таблицу\n" +
                    "2.Добавить данные в таблицу\n3.Обновить данные по ID\n" +
                    "4.Удалить данные по ID\n5.Выход из приложения");

            if (scanner.hasNextInt())
                choice = scanner.nextInt();
            else
                System.out.println("Такое действие отсутствует!");

            switch (choice) {
                case (1):
                    showAllTableInMain();
                    break;
                case (2):
                    insertDataToTable();
                    break;
                case (3):
                    updateDataById();
                    break;
                case (4):
                    deleteDataById();
                    break;
                case (5):
                    isRun = false;
                    break;
                default:
                    System.out.println("Такое действие отсутствует!");
                    break;
            }
        }
    }

    // соединение с БД
    public static Connection createConnection() {
        AccessData accessData = new AccessData();
        List<String> accessDataList = accessData.getAccessDateFromFile();

        GetAccessData getAccessData = new GetAccessData();
        getAccessData.returnGetAccessData(accessDataList);

        ConnectToDatabase connect = new ConnectToDatabase(accessData, getAccessData);

        return connect.getConnection();
    }

    // показать всю таблицу
    public static void showAllTableInMain() {
        ShowTable showTable = new ShowTable(connection);
        showTable.showAllTable();
    }

    //добавить данные в таблицу
    public static void insertDataToTable() {
        AddDataToTable addDataToTable = new AddDataToTable(connection);
        addDataToTable.InsertToTable();
    }

    // обновить данные по ID
    public static void updateDataById() {
        UpdateDataByID updateDataByID = new UpdateDataByID(connection);
        updateDataByID.updateDataInRow();
    }

    // удалить данные из таблицы по ID
    public static void deleteDataById() {
        DeleteDataByID deleteDataByID = new DeleteDataByID(connection);
        deleteDataByID.deleteRow();
    }
}

