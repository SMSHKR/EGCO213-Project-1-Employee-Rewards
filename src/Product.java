import java.util.Objects;

public class Product implements Comparable<Product> {
    // Variable
    private String name;
    private int price;
    private int totalSalesUnit = 0;
    private int totalSalesBaht = 0;
    // Constructor
    public Product(String inName, int inPrice) {
        name = inName;
        price = inPrice;
    }
    // Method
    public int getPrice() { return price; }
    public void calculateTotalSales(int unit) {
        totalSalesUnit += unit;
        totalSalesBaht = totalSalesUnit * price;
    }
    // Debug Method
    // public void testPrint() { System.out.println( name + ", " + price ); }
    public void testPrint() { System.out.println( name + " = " + totalSalesUnit + ", " + totalSalesBaht ); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int compareTo(Product other) { return Integer.compare(other.totalSalesBaht, totalSalesBaht); }

}