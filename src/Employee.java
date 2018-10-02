import java.util.ArrayList;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    // Variable
    private ArrayList<Integer> sales = new ArrayList<>();
    private ArrayList<Integer> overtimeMonth = new ArrayList<>();
    private String name;
    private double salesReward;
    private int overtimeReward;
    private double totalReward;

    // Constructor
    public Employee(String inName, ArrayList<Integer> iAL) {
        name = inName;
        sales.addAll(iAL);
    }

    public Employee(String inName) { name = inName; }

    // Method
    private void calculateRewards(int price)
    {
        // FIXME
        if(price<10000)
        {
            salesReward = ((1.01)*price);
        }
        else if(price>=10000 ||price<30000)
        {
            salesReward = ((1.15)*price);
        }
        else if(price>=30000 || price <50000)
        {
            salesReward = ((1.20)*price);
        }
        else if(price>=50000)
        {
            salesReward = ((1.25)*price);
        }
        overtimeReward = overtimeMonth.size()*3000;
    }

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
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int compareTo(Employee other) { return name.compareToIgnoreCase(other.name); }

}
