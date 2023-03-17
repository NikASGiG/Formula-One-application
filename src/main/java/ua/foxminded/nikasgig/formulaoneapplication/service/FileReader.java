package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public List<String> read(String filePath) throws IOException {
        return Files.readAllLines(Paths.get("src/main/resources/" + filePath));
    }
}
