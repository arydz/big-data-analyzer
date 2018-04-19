package com.arydz.learning.analyzer.utils;

import com.arydz.learning.analyzer.mapper.RowToPojoMapper;
import com.arydz.learning.analyzer.model.Readable;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public final class CSVFileReader {

    private static final String DEFAULT_SEPARATOR = ",";
    private static final Charset ENCODING = StandardCharsets.UTF_8;

    /**
     * Don't let anyone instantiate this class.
     */
    private CSVFileReader() {

    }

    public static <T extends Readable> List<T> mapFile(Path pathWithFileName, RowToPojoMapper<T> mapper) {
        try (FileInputStream fileInputStream = new FileInputStream(pathWithFileName.toFile())) {
            Scanner scanner = new Scanner(fileInputStream, ENCODING.name());
            return mapRows(scanner, mapper);
        } catch (IOException e) {
            log.error("Problem with opening file. {}", e.getMessage());
        }
        throw new IllegalArgumentException("Problems with opening file occurs. Check path to file.");
    }

    private static <T extends Readable> List<T> mapRows(Scanner scanner, RowToPojoMapper<T> mapper) {
        List<T> result = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String[] splitLine = CSVFileReader.readSplitLine(scanner);
            result.add(mapper.map(splitLine));
        }
        return result;
    }

    private static String[] readSplitLine(Scanner scanner) {
        String line = scanner.nextLine();
        return line.split(DEFAULT_SEPARATOR);
    }

    public static String[] readSplitLine(Scanner scanner, String separator) {
        String line = scanner.nextLine();
        return line.split(separator);
    }

    public static void read(Path pathWithFileName) {
        try (FileInputStream fileInputStream = new FileInputStream(pathWithFileName.toFile());
             Scanner scanner = new Scanner(fileInputStream, ENCODING.name())) {
            tryToReadFile(scanner);
        } catch (IOException e) {
            log.error("Problem with opening file. {}", e.getMessage());
        }
    }

    private static void tryToReadFile(Scanner scanner) throws IOException {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            log.info(line);
        }
        throwScannerSuppressesExceptions(scanner);
    }

    private static void throwScannerSuppressesExceptions(Scanner scanner) throws IOException {
        if (scanner.ioException() != null) {
            throw scanner.ioException();
        }
    }
}
