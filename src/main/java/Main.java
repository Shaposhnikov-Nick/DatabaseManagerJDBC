import java.sql.Connection;
import java.util.List;

public class Main {
    private static Connection connection;

    public static void main(String[] args) {
        // создаем подключение к БД
        connection = createConnection();

    }

    public static Connection createConnection(){
        AccessData accessData = new AccessData();
        List<String> accessDataList = accessData.getAccessDateFromFile();

        GetAccessData getAccessData = new GetAccessData();
        getAccessData.returnGetAccessData(accessDataList);

        ConnectToDatabase connect = new ConnectToDatabase(accessData, getAccessData);

        return connect.getConnection();
    }
}

