import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long productId;
    private String name;
    private LocalDate dateSupplied;
    private int quantityInStock;
    private double unitPrice;


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", dateSupplied=" + dateSupplied +
                ", quantityInStock=" + quantityInStock +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
