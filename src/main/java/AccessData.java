import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccessData {
    // файл с данными доступа к БД
    private  final File accessDateFile = new File("AccessData.txt");;

    // метод, считывающий данные доступа к БД из файла AccessData.txt
    public List<String> getAccessDateFromFile() {
        List<String> accessDataFromFile = new ArrayList<>();
        String str = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(accessDateFile));
            while((str = reader.readLine()) != null){
                if(!str.isEmpty()){
                    accessDataFromFile.add(str);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accessDataFromFile;
    }
}
