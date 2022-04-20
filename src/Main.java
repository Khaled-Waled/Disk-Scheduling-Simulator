import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //Test: skipping first screen
        InputGui.requests = new ArrayList<>(Arrays.asList(40, 30, 10, 90, 80, 70, 60, 20));
        new GUI(5, 40, true, 100);


        //InputGui.getInstance();



        /*
        //Testing SSTF , FCFS
        printArray(new SSTF().SSTF(new int[]{ 176, 79, 34, 60, 92, 11, 41, 114 }, 50));
        //printArray(new FCFS().FCFS(new int[]{98, 183, 37, 122, 14, 124, 65, 67}, 53));
        */
        /*
        //Testing CLook
        ArrayList<Integer> processes = new ArrayList<>(Arrays.asList(40, 30, 10, 90, 80, 70, 60, 20));
        SchedulingAlgorithm sa = new CLook(processes,40,true);
        sa.execute();

        printArray(SchedulingAlgorithm.result);
        System.out.println("Total Distance = "+ SchedulingAlgorithm.totalDistance);
         */
    }

    //Overloads for printing any array type
    public static void printArray(ArrayList<Integer> res) {
        System.out.println("===========================");
        for (int i : res) {
            System.out.println(i);
        }
        System.out.println("===========================");
    }

    public static void printArray(int res[]) {
        int n = res.length;
        System.out.println("===========================");
        for (int i : res) {
            System.out.println(i);
        }
        System.out.println("===========================");
    }
}
