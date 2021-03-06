import java.io.PrintWriter;
import java.util.Objects;

public class Product implements Comparable<Product> {
    // Variable
    private String name;
    private int price;
    private int totalSalesUnit = 0;
    private int totalSalesBaht = 0;
    private static int nameLgh = 0;
    // Constructor
    public Product(String inName, int inPrice) {
        name = inName;
        price = inPrice;
        if (nameLgh < name.length()) nameLgh = name.length();
    }
    // Method
    public int getPrice() { return price; }
    public void calculateTotalSales(int unit) {
        totalSalesUnit += unit;
        totalSalesBaht = totalSalesUnit * price;
    }
    public void Print() {
        System.out.printf("%-" + nameLgh + "s ", name);
        System.out.printf("total sales = %4d units %,11d baht\n", totalSalesUnit, totalSalesBaht);
    }
    public void Print(PrintWriter writer) {
        writer.printf("%-" + nameLgh + "s ", name);
        writer.printf("total sales = %4d units %,11d baht\r\n", totalSalesUnit, totalSalesBaht);
    }
    // Debug Method
    void testPrint() { System.out.println( name + ", " + price ); }
    // Intellij IDEA Auto-generate
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