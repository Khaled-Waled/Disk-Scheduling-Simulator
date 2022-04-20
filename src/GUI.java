import javax.swing.*;
import java.util.ArrayList;

public class GUI
{
    static int type;
    static int start;
    static boolean right;
    public SchedulingAlgorithm schedulingAlgorithm;
    public JFrame frame;

    GUI(int type, int start, boolean right)
    {
        //Get input from previous window
        GUI.type = type;
        GUI.start = start;
        GUI.right = right;
        switch (type)
        {
            case 5:
            {

                schedulingAlgorithm = new CLook(InputGui.requests,40,right);
                break;
            }
            default:
            {
                System.out.println("NOT Implemented");
                System.out.println("Fall back to algorithm 5");
                schedulingAlgorithm = new CLook(InputGui.requests,40,right);
                break;
            }
        }

        //Execute and get result
        schedulingAlgorithm.execute();
        ArrayList<Integer> result = SchedulingAlgorithm.result;


        /*
        //Debugging in the command line
        for (int a: res)
            System.out.println(a);
        System.out.println("\nTotal Distance = "+SchedulingAlgorithm.totalDistance);
        */

    }

}
