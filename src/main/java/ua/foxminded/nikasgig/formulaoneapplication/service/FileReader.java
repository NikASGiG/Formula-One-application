package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import ua.foxminded.nikasgig.formulaoneapplication.app.Main;

public class FileReader {

    public List<String> read(String path) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        return reader.lines().collect(Collectors.toList());
    }
}
