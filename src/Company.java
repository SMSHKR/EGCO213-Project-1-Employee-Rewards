import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {
/*
    private static void test() {
        try (Scanner file = new Scanner(new File("test/products.txt"))) {
            while (file.hasNext())
                System.out.println(file.nextLine());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
*/
    private static void inputProduct(ArrayList<Product> AL) {

        Scanner kbScan = new Scanner(System.in);
        String productFile = "test/products.txt";

        boolean opened = false;
        while (!opened)
            try (Scanner infile = new Scanner(new File(productFile))) {
                opened = true;

                while (infile.hasNext()) {
                    String line = infile.nextLine();
                    String[] par = line.split(",");

                    String name = par[0].trim();
                    int price = Integer.parseInt(par[1].trim());

                    AL.add(new Product(name, price));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.print("Enter product file = ");
                productFile = kbScan.next();
            }

    }

    public static void main(String[] args) {
        // test();

        ArrayList<Product> productAL = new ArrayList<>();
        inputProduct(productAL);
        for (Product productArray : productAL) productArray.testPrint();

        // TODO inputEmployee()

        // TODO inputOvertime()

    }

}
