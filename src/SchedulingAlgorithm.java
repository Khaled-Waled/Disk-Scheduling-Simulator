import java.util.ArrayList;

//TODO Make all algorithms inherit from this class
public abstract class SchedulingAlgorithm
{
    public static int totalDistance = 0;
    public static int start =0;
    public static ArrayList<Integer> processes;
    public static ArrayList<Integer> result;
    public SchedulingAlgorithm()
    {
        SchedulingAlgorithm.totalDistance =0;
        SchedulingAlgorithm.start =0;
        SchedulingAlgorithm.processes = new ArrayList<>();
    }
    public SchedulingAlgorithm(ArrayList<Integer> processes, int start)
    {
        SchedulingAlgorithm.totalDistance = 0;
        SchedulingAlgorithm.start =start;
        SchedulingAlgorithm.processes = processes;
    }
    public abstract void execute();

}
