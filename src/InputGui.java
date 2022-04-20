import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InputGui extends JFrame implements ActionListener
{
    public int type = 0;
    public int num = 1;
    private ArrayList<Integer> requests;

    private static InputGui gui;
    public static InputGui getInstance()
    {
        if (gui == null)
        {
            gui = new InputGui();
        }
        return gui;
    }

    private InputGui()
    {
        requests= new ArrayList<>();

        //Set up the frame
        this.setVisible(true);
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //New font for labels
        Font lFont = new Font(Font.DIALOG,  Font.BOLD, 18);
        Font fFont = new Font(Font.DIALOG_INPUT,  Font.PLAIN, 18);
        Font bFont = new Font(Font.DIALOG,  Font.BOLD, 24);

        //Adding labels
        this.add(l_request);
        l_request.setBounds(10,10,200,50);
        l_request.setFont(lFont);
        this.add(l_numOfRequests);
        l_numOfRequests.setBounds(10,50,200,50);
        l_numOfRequests.setFont(lFont);
        this.add(l_algorithm);
        l_algorithm.setBounds(10, 160,500,50);
        l_algorithm.setFont(lFont);
        //End of Adding labels

        //Adding Text Fields
        this.add(f_request);
        f_request.setBounds(200,28,200,20);
        f_request.setFont(fFont);
        //End of Adding Text Fields

        //Adding Buttons
        this.add(b_add);
        b_add.setBounds(500,28,100,50);
        b_add.setFont(bFont);
        this.add(b_run);
        b_run.setBounds(10,400,580,50);
        b_run.setFont(bFont);
    }

    /* Swing Variables*/
    JLabel l_request       = new JLabel("Request Cylinder:");
    JLabel l_algorithm     = new JLabel("Please, Choose the scheduling algorithm to apply:");
    JLabel l_numOfRequests = new JLabel("Current Requests: 0");

    JTextField f_request       = new JTextField();

    JButton b_add = new JButton("Add");
    JButton b_run = new JButton("Run");

    ButtonGroup buttonGroup = new ButtonGroup();

    JRadioButton rb_fcfs    = new JRadioButton("FCFS");
    JRadioButton rb_sstf    = new JRadioButton("SSTF");
    JRadioButton rb_scan    = new JRadioButton("Scan");
    JRadioButton rb_c_scan  = new JRadioButton("C-Scan");
    JRadioButton rb_look    = new JRadioButton("Look");
    JRadioButton rb_c_look  = new JRadioButton("C-Look");
    JRadioButton rb_opt     = new JRadioButton("New Optimised Algorithm");
    /* End of Swing Variables*/

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
