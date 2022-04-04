package thg.spring.tools;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileTools {

    public void createIfDoesNotExist(final String path) throws IOException {
        final File file = new File(path);
        file.createNewFile();
    }

    public String read(final String path) throws IOException {
        return Files.readString(Paths.get(path));
    }

    public void write(final String path, final String content) throws IOException {
        Files.write(Paths.get(path), content.getBytes());
    }
}
