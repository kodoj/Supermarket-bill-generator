package com.codecool;

public class VendingMachine {

    public static void main(String[] args) {

        PricesAndPromoReader pricesAndPromoReader = new PricesAndPromoReader("productPrices.txt");
        BarcodeScanner barcodeScanner = new BarcodeScanner();
        BillGenerator billGenerator = new BillGenerator(pricesAndPromoReader, barcodeScanner);

        System.out.println(billGenerator.generateBill());
    }
}
