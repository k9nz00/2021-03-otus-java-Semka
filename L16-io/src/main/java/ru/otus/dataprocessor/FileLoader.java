package ru.otus.dataprocessor;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ru.otus.model.Measurement;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileLoader implements Loader {

    private final String fileName;

    public FileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Measurement> load() {
        List<Measurement> measurements;
        try {
            URL resource = getClass().getClassLoader().getResource(fileName);
            String data = Files.readString(Path.of(resource.toURI()));
            Type type = new TypeToken<List<Measurement>>(){}.getType();
            measurements = new Gson().fromJson(data, type);
        }
        catch (IOException | URISyntaxException e) {
            throw new FileProcessException(e);
        }
        return measurements;
    }
}
