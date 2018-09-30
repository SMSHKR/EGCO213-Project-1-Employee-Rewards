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
                    boolean error = true;
                    while (error)
                        try {
                            String [] par = line.split(",");

                            String name = par[0].trim();
                            int price = Integer.parseInt(par[1].trim());

                            AL.add(new Product(name, price));
                            error = false;

                        } catch (IndexOutOfBoundsException | NumberFormatException e) {
                            System.err.println("Input Error : " + line);
                            System.out.print  ("Correction  : ");
                            line = kbScan.nextLine();
                        }
                }

            } catch (FileNotFoundException e) {
                System.err.println(e);
                System.out.print("Enter product file = ");
                productFile = kbScan.next();
                kbScan.nextLine(); // Fix nextLine() bug
            }

    }

    private static void inputEmployee(ArrayList<Employee> AL) {

        Scanner kbScan = new Scanner(System.in);
        String employeeFile = "test/employees.txt";

        boolean opened = false;
        while (!opened)
            try (Scanner infile = new Scanner(new File(employeeFile))) {
                opened = true;

                while (infile.hasNext()) {
                    String line = infile.nextLine();
                    String [] par = line.split(",");
                    // TODO Check Input and Correction
                    String name = par[0].trim();
                    ArrayList<Integer> price = new ArrayList<>();
                    for (int i = 1; i < par.length; i++)
                        price.add(Integer.parseInt(par[i].trim()));

                    AL.add(new Employee(name, price));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.print("Enter employee file = ");
                employeeFile = kbScan.next();
            }

    }

    public static void main(String[] args) {
        // test();

        ArrayList<Product> productAL = new ArrayList<>();
        inputProduct(productAL);
        for (Product productArray : productAL) productArray.testPrint();

        ArrayList<Employee> employeeAL = new ArrayList<>();
        inputEmployee(employeeAL);
        for (Employee employeeArray : employeeAL) employeeArray.testPrint();

        // TODO inputOvertime()

    }

}
