import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
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
            case 0:
            {
                schedulingAlgorithm = new FCFS(InputGui.requests,start);
                this.setTitle("FCFS");
                break;
            }
            case 1:
            {
                schedulingAlgorithm = new SSTF(InputGui.requests,start);
                this.setTitle("SSTF");
                break;
            }
            case 2:
            {
                schedulingAlgorithm = new SCAN(InputGui.requests,start);
                this.setTitle("SCAN");
                break;
            }
            case 3:
            {
                schedulingAlgorithm = new CSCAN(InputGui.requests,start);
                this.setTitle("C-Scan");
                break;
            }
            case 4:
            {
                schedulingAlgorithm = new Look(InputGui.requests,start);
                this.setTitle("LOOK");
                break;
            }
            case 5:
            {
                schedulingAlgorithm = new CLook(InputGui.requests,start,right);
                this.setTitle("C-LOOK");
                break;
            }
            default:
            {
                schedulingAlgorithm = new NewlyOptimizedAlgorithm(InputGui.requests);
                GUI.start = 0;
                SchedulingAlgorithm.start=0;
                this.setTitle("Newly Optimized Algorithm");
                break;
            }
        }

        //Execute and get result
        SchedulingAlgorithm.start = start;
        SchedulingAlgorithm.diskWidth = width;
        schedulingAlgorithm.execute();
        ArrayList<Integer> result = SchedulingAlgorithm.result;


        /*Display Result*/
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(610, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //display total distance
        Font lFont = new Font(Font.DIALOG,  Font.BOLD, 18);
        JLabel l_distance = new JLabel("Total distance = "+ SchedulingAlgorithm.totalDistance + " Cylinders.");
        this.add(l_distance);
        l_distance.setBounds(10,20,590,20);
        l_distance.setFont(lFont);




        //Debugging in the command line
        for (int a: result)
            System.out.println(a);
        System.out.println("\nTotal Distance = "+SchedulingAlgorithm.totalDistance);


    }

    public void paint (Graphics g)
    {
        //Initialization
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        float y=100;

        //Draw Grid
        ArrayList<Line2D> gridLines = new ArrayList<>();
        for(int i=0; i<SchedulingAlgorithm.result.size()+1; i++)
        {
            Line2D line = new Line2D.Float(10, y, 590, y);
            gridLines.add(line);
            y+= 500.0/(SchedulingAlgorithm.result.size()+1);
        }
        gridLines.add(new Line2D.Float(10, 100, 10, y-((float) 500.0/(SchedulingAlgorithm.result.size()+1))));
        gridLines.add(new Line2D.Float(590, 100, 590, y-((float) 500.0/(SchedulingAlgorithm.result.size()+1))));

        graphics2D.setColor(Color.BLACK);
        for (Line2D line: gridLines)
            graphics2D.draw(line);
        //End Draw Grid

        //Draw Path
        ArrayList<Line2D> lines = new ArrayList<>();
        int last = start;
        y=100;
        for(int point: SchedulingAlgorithm.result)
        {
            int x1 = 10 + (last*500)/width;
            int x2 = 10 + (point*500)/width;

            JLabel temp = new JLabel(String.valueOf(last));
            this.add(temp);
            temp.setBounds(x1, (int) (y - 500.0/SchedulingAlgorithm.result.size()+1),50,20);
            //System.out.println("X1 = "+x1+" X2 = "+x2);
            g.setColor(Color.RED);
            g.fillOval(x1-5, (int) y-5, 10, 10);
            Line2D line = new Line2D.Float(x1,y,x2,y+=500.0/(SchedulingAlgorithm.result.size()+1));
            g.setColor(Color.BLACK);
            graphics2D.draw(line);
            last = point;
            if (point == SchedulingAlgorithm.result.get(SchedulingAlgorithm.result.size()-1))
            {
                g.setColor(Color.RED);
                g.fillOval(x2-5, (int) y-5, 10, 10);
                JLabel temp2 = new JLabel(String.valueOf(last));
                this.add(temp2);
                temp2.setBounds(x2, (int) (y - 500.0/SchedulingAlgorithm.result.size()+1),50,20);
            }
        }


        //Line2D line = new Line2D.Float(200, 150, 150, 220);
    }

}
