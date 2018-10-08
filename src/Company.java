import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Company {

    private static void inputProduct (ArrayList<Product> AL)
    { inputProduct(AL, "test/products.txt"); }
    private static void inputEmployee(ArrayList<Employee> eAL, ArrayList<Product> pAL)
    { inputEmployee(eAL, pAL, "test/employees.txt"); }
    private static void inputOvertime(ArrayList<Employee> eAL)
    { inputOvertime(eAL, "test/overtime.txt"); }

    public static void main(String[] args) {

        ArrayList<Product> productAL = new ArrayList<>();
        inputProduct(productAL);

        // for (Product productArray : productAL) productArray.testPrint();

        ArrayList<Employee> employeeAL = new ArrayList<>();
        inputEmployee(employeeAL, productAL);
        inputOvertime(employeeAL);

        // for (Employee employeeArray : employeeAL) employeeArray.testPrint();

        Collections.sort(productAL);
        Collections.sort(employeeAL);

        try (PrintWriter writer = new PrintWriter(new File("summary.txt"))) {

            writer.println("=== Reward Processing ===");
            for (Employee employeeArray : employeeAL) employeeArray.Print(writer);

            writer.println("\n=== Product Summary ===");
            for (Product productArray : productAL) productArray.Print(writer);

        }
        catch (Exception e) { e.printStackTrace(); }
        finally {

            System.out.println("=== Reward Processing ===");
            for (Employee employeeArray : employeeAL) employeeArray.Print();

            System.out.println("\n=== Product Summary ===");
            for (Product productArray : productAL) productArray.Print();

        }

    }

    private static void inputProduct(ArrayList<Product> AL, String productFile) {

        Scanner kbScan = new Scanner(System.in);

        boolean opened = false;
        while (!opened) {
            try (Scanner infile = new Scanner(new File(productFile))) {
                opened = true;

                while (infile.hasNext()) {
                    String line = infile.nextLine();
                    boolean error = true;
                    while (error) {
                        try {
                            String [] par = line.split(",");

                            String name = par[0].trim();
                            int price = Integer.parseInt(par[1].trim());
                            if (price < 0) throw new IllegalArgumentException();

                            AL.add(new Product(name, price));
                            error = false;

                        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                            System.err.println("Input Error : " + line);
                            System.out.print  ("Correction  : ");
                            line = kbScan.nextLine();
                            if (line.equals("")) error = false;
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                System.err.println(e);
                System.out.print("Enter product file = ");
                productFile = kbScan.next();
                kbScan.nextLine(); // Fix nextLine() bug
            }
        }

    }

    private static void inputEmployee(ArrayList<Employee> eAL, ArrayList<Product> pAL, String employeeFile) {

        Scanner kbScan = new Scanner(System.in);

        boolean opened = false;
        while (!opened) {
            try (Scanner infile = new Scanner(new File(employeeFile))) {
                opened = true;

                while (infile.hasNext()) {
                    String line = infile.nextLine();

                    boolean error = true;
                    while (error) {
                        try {
                            String [] par = line.split(",");

                            String name = par[0].trim();
                            ArrayList<Integer> priceAL = new ArrayList<>();
                            for (int i = 1; i <= pAL.size(); i++) {
                                int price = Integer.parseInt(par[i].trim());
                                if (price < 0) throw new IllegalArgumentException();
                                priceAL.add(price);
                            }

                            eAL.add(new Employee(name, priceAL, pAL));
                            error = false;

                        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                            System.err.println("Input Error : " + line);
                            System.out.print  ("Correction  : ");
                            line = kbScan.nextLine();
                            if (line.equals("")) error = false;
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                System.err.println(e);
                System.out.print("Enter employee file = ");
                employeeFile = kbScan.next();
                kbScan.nextLine(); // Fix nextLine() bug
            }
        }

    }

    private static void inputOvertime(ArrayList<Employee> eAL, String overtimeFile) {

        Scanner kbScan = new Scanner(System.in);

        boolean opened = false;
        while (!opened) {
            try (Scanner infile = new Scanner(new File(overtimeFile))) {
                opened = true;

                while (infile.hasNext()) {
                    String line = infile.nextLine();

                    boolean error = true;
                    while (error) {
                        try {
                            String [] par = line.split(",");
                            int month = Integer.parseInt(par[0]);
                            for (int i = 1; i < par.length; i++) {
                                Employee dummy = new Employee(par[i].trim());
                                int index = eAL.indexOf(dummy);
                                if (index >= 0)
                                    eAL.get(index).addOvertime(month);
                            }
                            error = false;

                        } catch (IllegalArgumentException e) {
                            System.err.println("Input Error : " + line);
                            System.out.print  ("Correction  : ");
                            line = kbScan.nextLine();
                            if (line.equals("")) error = false;
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                System.err.println(e);
                System.out.print("Enter overtime file = ");
                overtimeFile = kbScan.next();
                kbScan.nextLine(); // Fix nextLine() bug
            }
        }

    }
}
