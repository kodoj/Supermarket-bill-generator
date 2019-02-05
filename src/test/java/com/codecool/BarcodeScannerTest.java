package com.codecool;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BarcodeScannerTest {

    @Test
    void checkIfFirstBarcodeReadProperly() {
        BarcodeScanner barcodeScanner = new BarcodeScanner();
        List<String> barcodes = barcodeScanner.readBarcodes("barcodeList.txt");
        String expectedResult = "1001";
        assertEquals(expectedResult, barcodes.get(0));
    }

    @Test
    void checkIfLastBarcodeReadProperly() {
        BarcodeScanner barcodeScanner = new BarcodeScanner();
        List<String> barcodes = barcodeScanner.readBarcodes("barcodeList.txt");
        String expectedResult = "1243";
        assertEquals(expectedResult, barcodes.get(9));
    }
}
