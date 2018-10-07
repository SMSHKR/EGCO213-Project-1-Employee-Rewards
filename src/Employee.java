import java.util.ArrayList;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    // Variable
    private ArrayList<Integer> salesAmount = new ArrayList<>();
    private ArrayList<Integer> overtimeMonth = new ArrayList<>();
    private String name;
    private double salesReward = 0;
    private int overtimeReward = 0;
    private static int nameLgh = 0;
    // Constructor
    public Employee(String inName, ArrayList<Integer> iAL, ArrayList<Product> pAL) {
        name = inName;
        salesAmount.addAll(iAL);
        calculateRewards(pAL);
        if (nameLgh < name.length()) nameLgh = name.length();
    }
    // Dummy Construtor
    public Employee(String inName) { name = inName; }
    // Method
    private void calculateRewards(ArrayList<Product> pAL) {
        for (int i = 0; i < salesAmount.size(); i++) {
            pAL.get(i).calculateTotalSales(salesAmount.get(i));
            int salesPrice = salesAmount.get(i) * pAL.get(i).getPrice();
                 if (salesPrice < 10000) salesReward += salesPrice * 0.010;
            else if (salesPrice < 30000) salesReward += salesPrice * 0.015;
            else if (salesPrice < 50000) salesReward += salesPrice * 0.020;
            else                         salesReward += salesPrice * 0.025;
        }
    }
    public void addOvertime(int month) {
        if (month > 12 || month < 1) return;
        if (overtimeMonth.contains(month)) return;
        overtimeMonth.add(month);
        overtimeReward = overtimeMonth.size() * 3000;
    }
    // Debug Method
    void testPrint() {
    /*
     *  System.out.print(name + ", ");
     *  for (int salesN : salesAmount) System.out.print(salesN + ", ");
     *  System.out.println("\nOvertime Size : " + overtimeMonth.size());
     *  for (int ot : overtimeMonth) System.out.print(ot + ", ");
     *  System.out.println();
     */
        System.out.printf("%-" + nameLgh + "s  rewards (sales + overtime) = ", name);
        System.out.printf("%,7.0f (%,7.0f + %,6d) baht\n", salesReward + overtimeReward, salesReward, overtimeReward);
    }
    // Intellij IDEA Auto-generate
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int compareTo(Employee other) { return name.compareToIgnoreCase(other.name); }

}
