package com.codecool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BarcodeScannerTest {

    @Test
    void checkIfFirstBarcodeReadProperly() {
        BarcodeScanner barcodeScanner = new BarcodeScanner();
        String[] barcodes = barcodeScanner.readBarcodes("barcodeList.txt");
        String expectedResult = "1001";
        assertEquals(expectedResult, barcodes[0]);
    }
}
