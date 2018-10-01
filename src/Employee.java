import java.util.ArrayList;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    // Variable
    private ArrayList<Integer> sales = new ArrayList<>();
    private ArrayList<Integer> overtimeMonth = new ArrayList<>();
    private String name;
    private int salesReward;
    private int overtimeReward;
    private int totalReward;
    // Constructor
    public Employee(String inName, ArrayList<Integer> iAL) {
        name = inName;
        sales.addAll(iAL);
    }
    // Method
    private void calculateRewards() { }
    public void addOvertime(int month) {
        if (month > 12 || month < 1) return;
        if (overtimeMonth.contains(month)) return;
        overtimeMonth.add(month);
    }
    // Debug Method
    public void testPrint() {
        System.out.print(name + ", ");
        for (int salesN : sales) System.out.print(salesN + ", ");
        System.out.println("\nOvertime Size : " + overtimeMonth.size());
        for (int ot : overtimeMonth) System.out.print(ot + ", ");
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() == name.getClass()) return name.equalsIgnoreCase((String) o);
        if (getClass() == o.getClass()) {
            Employee employee = (Employee) o;
            return Objects.equals(name, employee.name);
        }
        return false;
    }

    @Override
    public int compareTo(Employee other) { return name.compareToIgnoreCase(other.name); }

}
