package de.adventofcode.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.nio.file.Files;
import java.nio.file.Paths;

@UtilityClass
public class FileUtils {

    @SneakyThrows
    public String readFileFromString(final String fileName) {
        return Files.readString(Paths.get(FileUtils.class.getClassLoader().getResource(fileName).toURI()));
    }
}
