package org.java.programs.intermediate.cognizantassignment;

import java.io.IOException;
import java.util.List;

public class InventoryApp {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        try {
            // Read products from file
            System.out.println("Reading products from products.txt...");
            List<Product> allProducts = productManager.readProductsFromFile("src/test/java/org/java/programs/intermediate/cognizantassignment/products.txt");

            // Filter and sort products
            System.out.println("Filtering out discontinued products...");
            List<Product> filteredProducts = productManager.filterAndSortProducts(allProducts);

            // Display products
            productManager.displayProducts(filteredProducts);

            // Write to output file
            System.out.println("Writing filtered inventory to filtered_inventory.txt...");
            productManager.writeProductsToFile(filteredProducts, "src/test/java/org/java/programs/intermediate/cognizantassignment/filtered_inventory.txt");

            System.out.println("Operation completed successfully!");

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}