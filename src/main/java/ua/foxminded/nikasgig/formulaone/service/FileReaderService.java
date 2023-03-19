package ua.foxminded.nikasgig.formulaone.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderService {

    public List<String> read(String filePath) {
        try {
            return Files.readAllLines(Paths.get("src/main/resources/" + filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + filePath, e);
        }
    }
}
