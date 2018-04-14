package com.arydz.learning.analyzer.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

@Slf4j
public final class CSVFileReader {

    private static final Charset ENCODING = StandardCharsets.UTF_8;
    /**
     * Don't let anyone instantiate this class.
     */
    private CSVFileReader() {
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
