package com.codecool;

import java.util.*;

public class BillGenerator {
    private BarcodeScanner barcodeScanner;
    private PricesAndPromoReader pricesAndPromoReader;


    public BillGenerator(PricesAndPromoReader pricesAndPromoReader, BarcodeScanner barcodeScanner) {
        this.pricesAndPromoReader = pricesAndPromoReader;
        this.barcodeScanner = barcodeScanner;
    }


    public double generateBill() {
        String[][] prices = pricesAndPromoReader.readPrices();
        List<String> barcodes = barcodeScanner.readBarcodes("barcodeList.txt");
        Map<String, String> tempDiscounts;
        String tempCode;
        double bill = 0;

        while (barcodes.size() > 0) {
            tempCode = barcodes.get(0);
            barcodes.remove(0);
            int tempCount = 1;

            int index = 0;
            while (barcodes.size() > index) {
                if(barcodes.get(index).equals(tempCode)) {
                    barcodes.remove(index);
                    tempCount++;
                } else {
                    index++;
                }
            }

            tempDiscounts = generateTempDiscounts(prices, tempCode);

            SortedSet<String> keys = new TreeSet<>(Collections.reverseOrder());
            keys.addAll(tempDiscounts.keySet());
            for (String key : keys) {
                while (tempCount >= Integer.valueOf(key)) {
                    bill += Double.valueOf(tempDiscounts.get(key));
                    tempCount -= Integer.valueOf(key);
                }
            }

        }
        return bill;
    }


    private Map<String, String> generateTempDiscounts(String[][] prices, String code) {
        Map<String, String> tempDiscounts = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            if(prices[i][0] != null && prices[i][0].equals(code)) {
                tempDiscounts.put(prices[i][2], prices[i][3]);
            }
        }
        return tempDiscounts;
    }


}
