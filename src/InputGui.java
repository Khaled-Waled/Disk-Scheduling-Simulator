import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InputGui extends JFrame implements ActionListener {
    public int type = 0;
    public int num = 0;
    public static ArrayList<Integer> requests;

    private static InputGui gui;

    public static InputGui getInstance() {
        if (gui == null) {
            gui = new InputGui();
        }
        return gui;
    }

    private InputGui() {
        requests = new ArrayList<>();

        //Set up the frame
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //fonts
        Font lFont = new Font(Font.DIALOG, Font.BOLD, 18);
        Font fFont = new Font(Font.DIALOG_INPUT, Font.PLAIN, 18);
        Font bFont = new Font(Font.DIALOG, Font.BOLD, 24);

        //Adding labels
        this.add(l_request);
        l_request.setBounds(10, 10, 200, 50);
        l_request.setFont(lFont);
        this.add(l_numOfRequests);
        l_numOfRequests.setBounds(10, 50, 200, 50);
        l_numOfRequests.setFont(lFont);
        this.add(l_width);
        l_width.setBounds(10, 90, 200, 50);
        l_width.setFont(lFont);
        this.add(l_start);
        l_start.setBounds(10, 120, 200, 50);
        l_start.setFont(lFont);
        this.add(l_algorithm);
        l_algorithm.setBounds(10, 160, 500, 50);
        l_algorithm.setFont(lFont);
        //End of Adding labels

        //Adding Text Fields
        this.add(f_request);
        f_request.setBounds(200, 28, 200, 20);
        f_request.setFont(fFont);
        this.add(f_width);
        f_width.setBounds(200, 108, 200, 20);
        this.add(f_start);
        f_start.setBounds(200, 138, 200, 20);
        //End of Adding Text Fields

        //Adding Buttons
        this.add(b_add);
        b_add.setBounds(490, 28, 100, 50);
        b_add.setFont(bFont);
        b_add.addActionListener(this);
        this.add(b_run);
        b_run.setBounds(10, 400, 580, 50);
        b_run.setFont(bFont);
        b_run.addActionListener(this);
        //End of Adding Buttons

        //Adding Radio Buttons
        this.add(rb_fcfs);
        rb_fcfs.setBounds(10, 220, 100, 20);
        rb_fcfs.addActionListener(this);
        buttonGroup.add(rb_fcfs);
        this.add(rb_sstf);
        rb_sstf.setBounds(10, 250, 100, 20);
        rb_sstf.addActionListener(this);
        buttonGroup.add(rb_sstf);
        this.add(rb_scan);
        rb_scan.setBounds(10, 280, 100, 20);
        rb_scan.addActionListener(this);
        buttonGroup.add(rb_scan);
        this.add(rb_c_scan);
        rb_c_scan.setBounds(10, 310, 100, 20);
        rb_c_scan.addActionListener(this);
        buttonGroup.add(rb_c_scan);
        this.add(rb_look);
        rb_look.setBounds(110, 220, 100, 20);
        rb_look.addActionListener(this);
        buttonGroup.add(rb_look);
        this.add(rb_c_look);
        rb_c_look.setBounds(110, 250, 100, 20);
        rb_c_look.addActionListener(this);
        buttonGroup.add(rb_c_look);
        this.add(rb_opt);
        rb_opt.setBounds(110, 280, 200, 20);
        rb_opt.addActionListener(this);
        buttonGroup.add(rb_opt);
        //End ofAdding Radio Buttons

        //Adding Checkboxes
        this.add(c_right);
        c_right.setBounds(10, 370, 100, 20);
        c_right.setSelected(true);

    }

    /* Swing Variables*/
    JLabel l_request = new JLabel("Request Cylinder:");
    JLabel l_algorithm = new JLabel("Please, Choose the scheduling algorithm to apply:");
    JLabel l_numOfRequests = new JLabel("Current Requests: 0");
    JLabel l_width = new JLabel("Disk Width: ");
    JLabel l_start = new JLabel("Initial position is: ");

    JTextField f_request = new JTextField();
    JTextField f_width = new JTextField();
    JTextField f_start = new JTextField();

    JButton b_add = new JButton("Add");
    JButton b_run = new JButton("Run");

    ButtonGroup buttonGroup = new ButtonGroup();

    JRadioButton rb_fcfs = new JRadioButton("FCFS");
    JRadioButton rb_sstf = new JRadioButton("SSTF");
    JRadioButton rb_scan = new JRadioButton("Scan");
    JRadioButton rb_c_scan = new JRadioButton("C-Scan");
    JRadioButton rb_look = new JRadioButton("Look");
    JRadioButton rb_c_look = new JRadioButton("C-Look");
    JRadioButton rb_opt = new JRadioButton("New Optimised Algorithm");

    JCheckBox c_right = new JCheckBox("Going Right");
    /* End of Swing Variables*/

    @Override
    public void actionPerformed(ActionEvent e) {
        //Add request
        if (e.getSource() == b_add) {
            String reqText = f_request.getText();
            if (!reqText.equals("")) {
                num++;
                l_numOfRequests.setText("Current Requests: " + num);
                requests.add(Integer.valueOf(reqText));
                f_request.setText("");
            }
        }

        //Select type
        else if (e.getSource() == rb_fcfs) type = 0;
        else if (e.getSource() == rb_sstf) type = 1;
        else if (e.getSource() == rb_scan) type = 2;
        else if (e.getSource() == rb_c_scan) type = 3;
        else if (e.getSource() == rb_look) type = 4;
        else if (e.getSource() == rb_c_look) type = 5;
        else if (e.getSource() == rb_opt) type = 6;

            //Run button
        else if (e.getSource() == b_run && requests.size() > 0 && !f_start.getText().equals("") && !f_width.getText().equals("")) {
            int start = Integer.parseInt(f_start.getText());
            boolean right = c_right.isSelected();
            int width = Integer.parseInt(f_width.getText());
            this.dispose();
            new GUI(type, start, right, width);
        }

    }
}
