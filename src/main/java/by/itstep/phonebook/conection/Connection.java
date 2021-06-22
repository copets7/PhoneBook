package by.itstep.phonebook.conection;

import by.itstep.phonebook.entity.Group;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import sun.rmi.transport.StreamRemoteCall;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Connection<T> {

    private static final char SEPARATOR = CSVWriter.DEFAULT_SEPARATOR;
    private static Connection instance;
    //private Class clazz;

    private Connection() {
    }

    public static Connection getInstance() {
        if (instance == null) instance = new Connection();
        return instance;
    }

    //TODO
//    private <T extends ObjectsForBindings> List<T> parseData(String path, Class clazz) {
//        List<T> objects;
//        try (Reader reader = Files.newBufferedReader(Paths.get(path))) {
//            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
//                    .withType(clazz)
//                    .build();
//            objects = csvToBean.parse();
//        } catch (IOException e) {
//            throw new IllegalStateException(e);
//        }
//        return objects;
//    }

    public void writeCsvFromBean(String path, List<T> records) {
        try (Writer writer = new FileWriter(path)) {
            StatefulBeanToCsv<T> sbc = new StatefulBeanToCsvBuilder<T>(writer)
                    .withSeparator(SEPARATOR)
                    .build();
            sbc.write(records);
        } catch (CsvRequiredFieldEmptyException |
                IOException |
                CsvDataTypeMismatchException e) {
            throw new ConnectionException(e);
        }
    }

//    public static List<String> readFullFile(File file) {
//        try (BufferedReader br =
//                     new BufferedReader(new FileReader(file))) {
//            return br.lines().collect(Collectors.toList());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * @param path path to file
     * @return return max value from field id
     */
    public Integer getId(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream.skip(1).mapToInt(value ->
                    Integer.parseInt(value.substring(0, value.indexOf(SEPARATOR)))).
                    max().orElse(-1);
        } catch (IOException e) {
            throw new ConnectionException(e);
        }
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
