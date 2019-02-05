package com.codecool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PricesAndPromoReaderTest {

    @Test
    void checkIfFirstElementOfProductPricesFileIsReadProperly() {
        PricesAndPromoReader pricesAndPromoReader = new PricesAndPromoReader("productPrices.txt");
        pricesAndPromoReader.readPrices();
        String expectedResult = "1001";
        assertEquals(expectedResult, pricesAndPromoReader.getProductPrices()[0][0]);
    }
}
