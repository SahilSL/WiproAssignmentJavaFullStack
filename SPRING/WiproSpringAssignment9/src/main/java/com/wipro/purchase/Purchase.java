package com.wipro.purchase;

public class Purchase {
    private int purchaseId;
    private String purchaseDate;
    private Product product;  // Autowired bean

    // ✅ Constructor for autowire: only Product
    public Purchase(Product product) {
        this.product = product;
        System.out.println("Purchase constructor (Product autowired) called.");
    }

    // ✅ Setters for primitives
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void displayPurchase() {
        System.out.println("Purchase ID: " + purchaseId);
        System.out.println("Purchase Date: " + purchaseDate);
        product.displayProduct();
    }
}
