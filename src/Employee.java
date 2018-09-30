import java.util.ArrayList;
import java.util.Objects;

public class Employee {
    // Variable
    private ArrayList<Integer> sales = new ArrayList<>();
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
    // Debug Method
    public void testPrint() {
        System.out.print(name + ", ");
        for (int salesN : sales) System.out.print(salesN + ", ");
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

}
