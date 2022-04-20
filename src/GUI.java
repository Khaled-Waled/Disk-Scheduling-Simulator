import javax.swing.*;
import java.util.ArrayList;

public class GUI extends JFrame
{
    static int type;
    static int width;
    static int start;
    static boolean right;
    public SchedulingAlgorithm schedulingAlgorithm;

    GUI(int type, int start, boolean right, int width)
    {
        //Get input from previous window
        GUI.type = type;
        GUI.width = width;
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


        /*Display Result*/
        this.setVisible(true);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);



        /*
        //Debugging in the command line
        for (int a: result)
            System.out.println(a);
        System.out.println("\nTotal Distance = "+SchedulingAlgorithm.totalDistance);
        */
    }

}
