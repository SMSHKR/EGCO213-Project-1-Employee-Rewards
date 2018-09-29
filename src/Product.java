public class Product {
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

}
