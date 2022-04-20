import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class GUI extends JFrame {
    static int type;
    static int width;
    static int start;
    static boolean right;
    public SchedulingAlgorithm schedulingAlgorithm;

    GUI(int type, int start, boolean right, int width) {
        //Get input from previous window
        GUI.type = type;
        GUI.width = width;
        GUI.start = start;
        GUI.right = right;
        switch (type) {
            case 0: {

                schedulingAlgorithm = new FCFS(InputGui.requests, 40);
                break;
            }
            case 1: {

                schedulingAlgorithm = new SSTF(InputGui.requests, 40);
                break;
            }
            case 5: {

                schedulingAlgorithm = new CLook(InputGui.requests, 40, right);
                break;
            }
            default: {
                System.out.println("NOT Implemented");
                System.out.println("Fall back to algorithm 5");
                schedulingAlgorithm = new CLook(InputGui.requests, 40, right);
                break;
            }
        }

        //Execute and get result
        schedulingAlgorithm.execute();
        ArrayList<Integer> result = SchedulingAlgorithm.result;


        /*Display Result*/
        this.setVisible(true);
        this.setSize(610, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //display total distance
        Font lFont = new Font(Font.DIALOG, Font.BOLD, 18);
        JLabel l_distance = new JLabel("Total distance = " + SchedulingAlgorithm.totalDistance + " Cylinders.");
        this.add(l_distance);
        l_distance.setBounds(10, 20, 590, 20);
        l_distance.setFont(lFont);


        //Debugging in the command line
        for (int a : result)
            System.out.println(a);
        System.out.println("\nTotal Distance = " + SchedulingAlgorithm.totalDistance);

    }

    public void paint(Graphics g) {
        //Initialization
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        float y = 100;

        //Draw Grid
        ArrayList<Line2D> gridLines = new ArrayList<>();
        for (int i = 0; i < SchedulingAlgorithm.result.size(); i++) {
            Line2D line = new Line2D.Float(10, y, 590, y);
            gridLines.add(line);
            y += 500.0 / SchedulingAlgorithm.result.size();
        }
        gridLines.add(new Line2D.Float(10, 100, 10, y - ((float) 500.0 / SchedulingAlgorithm.result.size())));
        gridLines.add(new Line2D.Float(590, 100, 590, y - ((float) 500.0 / SchedulingAlgorithm.result.size())));

        graphics2D.setColor(Color.BLACK);
        for (Line2D line : gridLines)
            graphics2D.draw(line);
        //End Draw Grid

        //Draw Path
        ArrayList<Line2D> lines = new ArrayList<>();
        int last = start;
        y = 100;
        for (int point : SchedulingAlgorithm.result) {
            int x1 = 10 + (last * 500) / width;
            int x2 = 10 + (point * 500) / width;

            JLabel temp = new JLabel(String.valueOf(point));
            this.add(temp);
            temp.setBounds(x1, (int) (y - 500.0 / SchedulingAlgorithm.result.size()), 50, 20);
            //System.out.println("X1 = "+x1+" X2 = "+x2);
            g.setColor(Color.RED);
            g.fillOval(x1 - 5, (int) y - 5, 10, 10);
            Line2D line;
            if (point == SchedulingAlgorithm.result.get(SchedulingAlgorithm.result.size() - 1))
                line = new Line2D.Float(x1, y, x2, y);
            else
                line = new Line2D.Float(x1, y, x2, y += 500.0 / SchedulingAlgorithm.result.size());
            g.setColor(Color.BLACK);
            graphics2D.draw(line);
            last = point;

        }


        //Line2D line = new Line2D.Float(200, 150, 150, 220);
    }

}
