import java.util.ArrayList;

public class SSTF {

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

    public static int[] SSTF(int[] req, int start) {
        int i = 1;
        ArrayList<Integer> requests = new ArrayList<>(req.length);

        for (int a : req)
            requests.add(a);

        int[] result = new int[requests.size() + 1];
        result[0] = start;
        while (!requests.isEmpty()) {
            int best = diff(requests, result[i - 1]);
            result[i] = requests.get(best);
            requests.remove(best);
            i++;
        }
        return result;
    }

}
