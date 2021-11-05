package util;

import java.io.*;
import java.util.*;

public class Reader {

    public static Map<String, List<String>> readFilesSet(String CSVFilesPath) throws WrongFilesFormatException {
        Map<String, List<String>> games = new HashMap<>();

        File[] files = new File(CSVFilesPath).listFiles();
        for (File file : files) {
            Queue<String> resultOfReading = new LinkedList<>();
            if (!file.getName().endsWith("csv")) throw new WrongFilesFormatException();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                while (reader.ready()) {
                    resultOfReading.add(reader.readLine());
                }
                games.put(resultOfReading.remove(), new ArrayList<>(resultOfReading));
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            } catch (IllegalArgumentException ignored) {
            }
        }
        return games;
    }

}

class WrongFilesFormatException extends Exception {

}
