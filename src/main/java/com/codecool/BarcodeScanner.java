package com.codecool;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BarcodeScanner {

    public List<String> readBarcodes(String fileName) {
        List<String> barcodes = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
            stream.forEach(barcodes::add);
        } catch (Exception e){
            if (e instanceof IOException || e instanceof URISyntaxException) {
                e.printStackTrace();
                System.out.println("No File Found");
            }
        }
        return barcodes;
    }
}
