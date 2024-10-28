import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Product[] products = {
                new Product(3128874119L, "Banana", LocalDate.of(2023, 1, 24), 124, 0.55),
                new Product(2927458265L, "Apple", LocalDate.of(2022, 12, 9), 18, 1.09),
                new Product(9189927460L, "Carrot", LocalDate.of(2023, 3, 31), 89, 2.99)
        };

        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        List<Product> sortedProducts = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());

        // Print JSON format
        System.out.println("JSON-formatted list of all Products:");
        String jsonOutput = sortedProducts.stream()
                .map(p -> String.format("{\"productId\": %d, \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %.2f}",
                        p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice()))
                .collect(Collectors.joining(",\n", "[\n", "\n]"));
        System.out.println(jsonOutput);

        // Print XML format
        System.out.println("\nXML-formatted list of all Products:");
        String xmlOutput = sortedProducts.stream()
                .map(p -> String.format("  <product>\n    <productId>%d</productId>\n    <name>%s</name>\n    <dateSupplied>%s</dateSupplied>\n    <quantityInStock>%d</quantityInStock>\n    <unitPrice>%.2f</unitPrice>\n  </product>",
                        p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice()))
                .collect(Collectors.joining("\n", "<products>\n", "\n</products>"));
        System.out.println(xmlOutput);

        // Print CSV format
        System.out.println("\nCSV-formatted list of all Products:");
        String csvOutput = sortedProducts.stream()
                .map(p -> String.format("%d, %s, %s, %d, %.2f",
                        p.getProductId(), p.getName(), p.getDateSupplied(), p.getQuantityInStock(), p.getUnitPrice()))
                .collect(Collectors.joining("\n", "ProductId, Name, DateSupplied, QuantityInStock, UnitPrice\n", ""));
        System.out.println(csvOutput);
    }
}
