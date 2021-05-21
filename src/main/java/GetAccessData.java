import java.util.List;

public class GetAccessData {
    // сервер базы данных
    private   String HOST;
    // имя базы данных
    private   String DATABASENAME;
    // имя пользователя
    private  String USERNAME;
    // пароль пользователя
    private  String PASSWORD;


    // метод, записывающий значения полям доступа к БД
    public  void returnGetAccessData(List<String> accessDataList){
        HOST = accessDataList.get(0);
        DATABASENAME = accessDataList.get(1);
        USERNAME = accessDataList.get(2);
        PASSWORD = accessDataList.get(3);

    }

    // строка с соединением с БД
    public  String getUrl() {
        return  "jdbc:postgresql://" + HOST + "/" + DATABASENAME +
                "?user=" + USERNAME + "&password=" + PASSWORD;
    }

    public String getDATABASENAME() {
        return DATABASENAME;
    }
}
