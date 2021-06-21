package by.itstep.phonebook.conection;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Connection {



    //TODO

    public static List<String> readFullFile(File file) {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {
            return br.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Long getId(String path){
        try {
            String lastLine = Files.lines(Paths.get(path)).
                    reduce((a,b)-> b).orElse(null);
            if (lastLine == null) {
                //TODO throw Exception?
                return -1L;
            } else {
                lastLine = lastLine.substring(0, lastLine.indexOf(","));
                if ("id".equals(lastLine)) return 0L;
                return Long.valueOf(lastLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeToFileOneLine(String path, String logLine) {
        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter(path, true))) {
            bw.newLine();
            bw.write(logLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
