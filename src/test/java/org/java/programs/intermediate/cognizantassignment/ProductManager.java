package org.java.programs.intermediate.cognizantassignment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductManager {

    public List<Product> readProductsFromFile(String filename) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return lines.map(line -> {
                        String[] parts = line.split(",");
                        if (parts.length == 4) {
                            try {
                                int productId = Integer.parseInt(parts[0].trim());
                                String productName = parts[1].trim();
                                int quantity = Integer.parseInt(parts[2].trim());
                                String status = parts[3].trim();
                                return new Product(productId, productName, quantity, status);
                            } catch (NumberFormatException e) {
                                System.err.println("Error parsing line: " + line);
                                return null;
                            }
                        }
                        System.err.println("Invalid line format: " + line);
                        return null;
                    })
                    .filter(product -> product != null)
                    .collect(Collectors.toList());
        }
    }

    public List<Product> filterAndSortProducts(List<Product> products) {
        return products.stream()
                .filter(product -> !"DISCONTINUED".equalsIgnoreCase(product.getStatus()))
                .sorted((p1, p2) -> Integer.compare(p2.getQuantity(), p1.getQuantity()))
                .collect(Collectors.toList());
    }

    public void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No active products found.");
            return;
        }

        System.out.println("\n=== FILTERED AND SORTED INVENTORY ===");
        System.out.println("Products sorted by quantity (descending):");
        System.out.println("========================================");

        products.forEach(product ->
                System.out.println(product.toDisplayString()));

        System.out.println("========================================");
        System.out.println("Total active products: " + products.size());
    }

    public void writeProductsToFile(List<Product> products, String filename) throws IOException {
        List<String> lines = products.stream()
                .map(Product::toString)
                .collect(Collectors.toList());

        Files.write(Paths.get(filename), lines);
    }
}
