package databaseService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DatabaseService {

    final String PATH="database.txt";



    public static List<String> read() throws IOException {

            return Files.readAllLines(Paths.get("database.txt"));
    }

    public void write(String[] data)
    {
        try {
            StringBuilder builder=new StringBuilder();

            String info=builder.append(data[0]).append(" ").append(data[1]).append(",").append(data[2]).append(",").append(data[3]).append(",").append(data[4]).append("\n").toString();
            builder.append(System.getProperty("line.separator"));
            //Append do txt files
            Files.write(Paths.get(PATH), info.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.out.println("Couldn't save the file");
        }
    }
}
