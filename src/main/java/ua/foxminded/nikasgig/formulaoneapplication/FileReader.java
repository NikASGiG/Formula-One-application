package ua.foxminded.nikasgig.formulaoneapplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class FileReader {

    public String read(String path) throws IOException {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(path);
        valideInputStream(path, inputStream);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }

    private void valideInputStream(String path, InputStream inputStream) throws FileNotFoundException {
        if (inputStream == null) {
            throw new FileNotFoundException("File not found in classpath: " + path);
        }
    }
}
