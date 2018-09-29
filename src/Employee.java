import java.util.ArrayList;

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

}
