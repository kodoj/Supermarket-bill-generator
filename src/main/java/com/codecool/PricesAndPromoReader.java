package com.codecool;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class PricesAndPromoReader {
    private String[][] productPrices;
    private int size = 0;
    private String fileName;


    public PricesAndPromoReader(String fileName) {
        this.fileName = fileName;
        productPrices = new String[10][4];
        size = 0;
    }


    public String[][] readPrices() {
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {

            stream.forEach(line -> {
                if(size >= productPrices.length - 1) {
                    resizeArray();
                } else {
                    String[] temp = line.split(", ");
                    for (int i = 0; i < temp.length; i++) {
                        productPrices[size][i] = temp[i];
                    }
                    size++;
                }
            });
        } catch (Exception e){
            if (e instanceof IOException || e instanceof URISyntaxException) {
                e.printStackTrace();
                System.out.println("No File Found");
            }
        }
        return productPrices;
    }


    private void resizeArray() {
        String[][] newArray = Arrays.copyOf(productPrices, size * 2);
        productPrices = newArray;
    }

    public String[][] getProductPrices() {
        return productPrices;
    }
}
