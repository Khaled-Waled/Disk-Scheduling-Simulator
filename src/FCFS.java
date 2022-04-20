import java.util.ArrayList;

public class FCFS extends SchedulingAlgorithm {

    public FCFS(ArrayList<Integer> requests, int start) {
        super(requests, start);
    }

    @Override
    public void execute() {
        int n = requests.size();
        result = new ArrayList<>();
        result.add(start);
        for (int i = 0; i < n; i++) {
            result.add(requests.get(i));
        }
        calculateTotalDistance();
    }
}
