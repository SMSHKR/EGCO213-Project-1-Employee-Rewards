import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Company extends Application {

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

        Collections.sort(productAL);
        Collections.sort(employeeAL);

        // for (Employee employeeArray : employeeAL) employeeArray.testPrint();
        // for (Product productArray : productAL) productArray.testPrint();

        for (Employee employeeArray : employeeAL) employeeArray.testPrint();
        for (Product productArray : productAL) productArray.Print();

        table gui = new table();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(600,200);
        gui.setTitle("Hello");


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
    public static class table extends JFrame
    {
        JTable table;
        public table()
        {
            setLayout(new FlowLayout());
            String[] columnName = {"Name"};
            Object[][] data = {
                    {"GG","WTF"}
            };
            table = new JTable(data,columnName);
            table.setPreferredScrollableViewportSize(new Dimension(500,50));
            table.setFillsViewportHeight(true);

            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane);
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*Stage first = new Stage();

        Button but = new Button();
        but.setText("TEST");

        first.setTitle("Employee Reward");

        StackPane layout = new StackPane();
        layout.getChildren().add(but);

        Scene scene = new Scene(layout,800,600);
        first.setScene(scene);
        first.show();*/
    }

}
