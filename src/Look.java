import java.util.ArrayList;
import java.util.Collections;

public class Look extends SchedulingAlgorithm {


    public Look(ArrayList<Integer> requests, int initialHeadPos) {
        super(requests, initialHeadPos);
    }

    public void execute() {

        //intially , we go left, then go right
        ArrayList<Integer> requests = new ArrayList<Integer>(SchedulingAlgorithm.requests);

        /*
        //test
        ArrayList<Integer> requests = new ArrayList<>();
        requests.add(38);
        requests.add(180);
        requests.add(130);
        requests.add(10);
        requests.add(50);
        requests.add(15);
        requests.add(190);
        requests.add(90);
        requests.add(150);
        */



        Collections.sort(requests);
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        //find the first request to the left of the initialHeadPos
        int pointer = 0;
        while (pointer + 1 < requests.size() && requests.get(pointer + 1) <= start) {
            pointer++;
        }


        //service requests to the left untill there are none
        tmp.add(start);
        while (pointer > 0) {
            tmp.add(requests.get(pointer));
            requests.remove(pointer);
            pointer--;
        }
        pointer = 0;
        while (!requests.isEmpty()) {
            tmp.add(requests.get(pointer));
            requests.remove(pointer);
        }

        result = tmp;
        calculateTotalDistance();

    }


    //main just for testing purposes
    public static void main(String[] args) {
        //we call look with an empty array because during testing,
        // we created the array  in the execute
        Look look = new Look(new ArrayList<Integer>(), 120);
        look.execute();
    }
}


