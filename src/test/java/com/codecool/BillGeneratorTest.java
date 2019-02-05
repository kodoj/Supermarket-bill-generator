package com.codecool;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillGeneratorTest {

    private BillGenerator billGenerator;

    @Mock
    private BarcodeScanner barcodeScannerMock;
    @Mock
    private PricesAndPromoReader pricesAndPromoReaderMock;


    @BeforeEach
    void prepare() {
        MockitoAnnotations.initMocks(this);
        billGenerator = new BillGenerator(pricesAndPromoReaderMock, barcodeScannerMock);
    }


    @Test
    void generateBillFromOneBarcode() {
        String[][] defaultPrice = {{"1001", "beer", "1", "1.20"}};
        when(pricesAndPromoReaderMock.readPrices())
                .thenReturn(defaultPrice);
        List<String> expectedBarcode = new ArrayList<>();
        expectedBarcode.add("1001");
        when(barcodeScannerMock.readBarcodes("barcodeList.txt"))
                .thenReturn(expectedBarcode);

        double expectedBill = 1.20;
        assertEquals(expectedBill, billGenerator.generateBill());
    }


    @Test
    void generateBillFromThreeSameItemsAndTwoDifferentPrices() {
        String[][] defaultPrice = {{"1001", "beer", "1", "1.20"}, {"1001", "beer", "2", "2.00"}};
        when(pricesAndPromoReaderMock.readPrices())
                .thenReturn(defaultPrice);
        List<String> expectedBarcode = new ArrayList<>();
        expectedBarcode.add("1001");
        expectedBarcode.add("1001");
        expectedBarcode.add("1001");
        when(barcodeScannerMock.readBarcodes("barcodeList.txt"))
                .thenReturn(expectedBarcode);

        double expectedBill = 3.20;
        assertEquals(expectedBill, billGenerator.generateBill());
    }
}
