import java.util.ArrayList;
import java.util.Collections;

public class CSCAN extends SchedulingAlgorithm{

    public CSCAN(ArrayList<Integer> requests, int start){
        super(requests, start);
    }

    public void execute(){
        execute(SchedulingAlgorithm.requests, SchedulingAlgorithm.start);
    }

    private void execute(ArrayList<Integer> requests, int start){
        //if curr head pos is not in requests add it
        boolean headExist = requests.contains(start);
        if(!headExist){
            requests.add(start);
        }

        //adding last cylinder
        boolean endOfDiskExist = requests.contains(SchedulingAlgorithm.diskWidth-1);
        if(!endOfDiskExist){
            requests.add(SchedulingAlgorithm.diskWidth-1);
        }

        //adding 0 first cylinder
        boolean zeroExist = requests.contains(0);
        if(!zeroExist){
            requests.add(0);
        }

        //sort the requests
        Collections.sort(requests);

        //get start index
        int startLoc = requests.indexOf(start);

        //store the final result into temp array and then update result with the temp
        ArrayList<Integer> tmp = new ArrayList<>();

        //go right till the end of disk
        for(int i=startLoc;i<requests.size();i++){
            tmp.add(requests.get(i));
        }

        //after finishing right from start index go right starting from first cylinder till we reach startLoc-1
        for(int i=0;i<startLoc;i++){
            tmp.add(requests.get(i));
        }

        /*
            //debug
            for(int i=0;i<tmp.size();i++){
                System.out.println("curr serving at "+tmp.get(i));
            }
        */

        //update result
        SchedulingAlgorithm.result = tmp;

        //calc the total distance
        SchedulingAlgorithm.calculateTotalDistance();
    }
}
