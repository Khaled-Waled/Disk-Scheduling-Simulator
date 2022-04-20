import java.util.ArrayList;

//TODO Make all algorithms inherit from this class
public abstract class SchedulingAlgorithm {
    public static int totalDistance;
    public static int start;
    public static int diskWidth = 1000;
    public static ArrayList<Integer> requests;
    public static ArrayList<Integer> result;

    public SchedulingAlgorithm() {
        SchedulingAlgorithm.start = 0;
        SchedulingAlgorithm.requests = new ArrayList<>();
    }

    public SchedulingAlgorithm(ArrayList<Integer> requests, int start) {
        SchedulingAlgorithm.start = start;
        SchedulingAlgorithm.requests = requests;
    }

    public abstract void execute();

    public static void calculateTotalDistance() {
        totalDistance = 0;
        for (int i = 1; i < result.size(); i++) {
            totalDistance += Math.abs(result.get(i) - result.get(i - 1));
        }
    }
}
