package rental;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileData {

    private ObjectMapper objectMapper = new ObjectMapper();
    private File file;

    public FileData(File file) {
        this.file = file;
    }

    public HashMap<String, Book> uploadBooks() {
        if (!file.exists()) {
            return new HashMap<>();
        }
        try {
            return objectMapper.readValue(file, new TypeReference<>() {});
        } catch (IOException exception) {
            throw new RuntimeException("Error while uploading books");
        }
    }

    public void saveBooks(HashMap<String, Book> books) {
        try {
            objectMapper.writeValue(file, books);
        } catch (IOException exception) {
            throw new RuntimeException("Error while saving data", exception);
        }
    }
}
