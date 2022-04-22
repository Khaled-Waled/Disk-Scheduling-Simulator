import java.util.ArrayList;
import java.util.Collections;

public class CLook extends SchedulingAlgorithm
{
    public boolean right;
    public CLook (ArrayList<Integer> processes, int start,boolean right)
    {
        super(processes,start);
        this.right = right;
    }
    public void execute()
    {
        execute(right);
    }

    public void execute(boolean right)
    {
        //reset distance counter;
        totalDistance = 0;
        //Create copy of the array for safe operation
        ArrayList<Integer> requests = new ArrayList<>(SchedulingAlgorithm.requests);

        /*
        //test
        ArrayList<Integer> requests = new ArrayList<>();
        requests.add(15);
        requests.add(1);
        requests.add(5);
        requests.add(50);
        requests.add(30);
        requests.add(45);
        requests.add(23);
        requests.add(10);
        */

        //Declare Head pointer position
        int pointer=0;

        //prepare request[ ]
        if(right)
        {
            Collections.sort(requests);
            //position the pointer
            for(;pointer<requests.size(); pointer++)
            {
                if(start <= requests.get(pointer))
                    break;
            }
        }
        else
        {
            requests.sort(Collections.reverseOrder());
            //position the pointer
            for(;pointer<requests.size(); pointer++)
            {
                if(start >= requests.get(pointer))
                    break;
            }
        }

        //serve requests
        ArrayList<Integer> temp = new ArrayList<>();
        int lastRequest= start;
        while (requests.size()>0)
        {
            //if it reached the end reset pointer
            if(pointer >= requests.size())
                pointer = 0;

            //add to total distance
            totalDistance += Math.abs(lastRequest - requests.get(pointer));

            //update last request served to current
            lastRequest = requests.get(pointer);

            //add current request to result and remove it from queue
            temp.add(requests.get(pointer));
            requests.remove(pointer);


        }
        //Update result array
        result = temp;
    }
}