import java.util.Objects;

public class Product implements Comparable<Product> {
    // Variable
    private String name;
    private int price;
    private int totalSalesUnit;
    private int totalSalesBaht;
    // Constructor
    public Product(String inName, int inPrice) {
        name = inName;
        price = inPrice;
    }
    // Method

    // Debug Method
    public void testPrint() { System.out.println( name + ", " + price ); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int compareTo(Product other) { return name.compareToIgnoreCase(other.name);
    }
}