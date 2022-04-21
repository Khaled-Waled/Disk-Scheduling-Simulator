import java.util.ArrayList;
import java.util.Collections;

public class NewlyOptimizedAlgorithm extends  SchedulingAlgorithm{

    //This algorithm is similar to look but the
    // initial position for the head pointer is always 0

    public NewlyOptimizedAlgorithm(ArrayList<Integer> requests) {
        super(requests, 0);
    }

    public void execute() {

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
        // the initial head position is always 0
        start = 0 ;

        //service requests to the the right

        tmp.add(0);
        for(int i=0; i<requests.size(); i++){
            tmp.add(requests.get(i));
        }

        result = tmp;
        //the total distance travelled is the position of the last request
        totalDistance = requests.get(requests.size() - 1);

    }

    public static void main(String[] args) {
        NewlyOptimizedAlgorithm nao = new NewlyOptimizedAlgorithm(new ArrayList<Integer>());
        nao.execute();
    }


}
