package com.codecool;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PricesAndPromoReaderTest {

    @Test
    void checkIfFirstElementOfProductPricesFileIsReadProperly() {
        PricesAndPromoReader pricesAndPromoReader = new PricesAndPromoReader();
        String expectedResult = "1001";
        assertEquals(expectedResult, pricesAndPromoReader.readPrices("productPrices.txt")[0][0]);
    }
}
