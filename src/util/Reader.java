package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader {

    public static Map<String, List<String>> readFilesSet(String CSVFilesPath) throws WrongFilesFormatException {
        Map<String, List<String>> games = new HashMap<>();

        File[] receivedFiles = new File(CSVFilesPath).listFiles();
        for (File file : receivedFiles) {
            Queue<String> resultOfReading = new LinkedList<>();
            if (!file.getName().endsWith("csv")) throw new WrongFilesFormatException();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                while (reader.ready()) {
                    resultOfReading.add(reader.readLine());
                }
                games.put(resultOfReading.remove(), new ArrayList<>(resultOfReading));
            } catch (IOException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return games;
    }

}

class WrongFilesFormatException extends Exception {

}
