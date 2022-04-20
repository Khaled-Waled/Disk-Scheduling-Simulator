import java.util.ArrayList;

public class SSTF extends SchedulingAlgorithm {

    public SSTF(ArrayList<Integer> requests, int start) {
        super(requests, start);
    }

    public static int diff(ArrayList<Integer> req, int head) {
        ArrayList<Integer> requests = new ArrayList<>(req.size());

        for (int a : req)
            requests.add(a);

        int n = requests.size();
        for (int i = 0; i < n; i++) {
            requests.set(i, Math.abs(requests.get(i) - head));
        }
        return findMin(requests);
    }

    public static int findMin(ArrayList<Integer> requests) {
        int n = requests.size(), Min = 0;
        for (int i = 0; i < n; i++) {
            if (requests.get(i) < requests.get(Min)) {
                Min = i;
            }
        }
        return Min;
    }

    @Override
    public void execute() {
        int i = 1;
        result = new ArrayList<>();
        result.add(start);
        while (!requests.isEmpty()) {
            int best = diff(requests, result.get(i - 1));
            result.add(requests.get(best));
            requests.remove(best);
            i++;
        }
        calculateTotalDistance();
    }
}
