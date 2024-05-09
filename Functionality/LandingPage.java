package Functionality;

import CourseWork1.Teacher;
import CustomJPackages.CustomButton;
import CustomJPackages.CustomLabel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Creating Frame
public class LandingPage  extends JFrame {
    ArrayList <Teacher> teacher = new ArrayList<Teacher>();
    CustomLabel addQuestionLabel;
    CustomButton addLecturerButton, addTutorButton, gradeAssignmentButton, setSalaryButton, removeTutorButton, displayButton;


    // constructor of class LandingPage
    public LandingPage(){
        super("Add Teacher");       // set the title(name) of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // set operation when exit button(X) is clicked
        setSize(500,550);       // set dimension of frame
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);       // set visibility of frame

        JPanel mainPanel = new JPanel();        // create new panel
        mainPanel.setBackground(Color.LIGHT_GRAY);      // set background of panel
        mainPanel.setForeground(Color.BLACK);       //set foreground color(text color) to Black
        mainPanel.setFont(new Font("Poppins", Font.PLAIN, 18));     // set font style

        // create labels
        addQuestionLabel = new CustomLabel("Welcome To TeacherGUI!");
        addQuestionLabel.setFont(new Font("Poppins",Font.BOLD,18));

        //create buttons

        displayButton = new CustomButton("Display Teacher");
        addLecturerButton = new CustomButton("Add Lecturer");
        addTutorButton = new CustomButton("Add Tutor");
        gradeAssignmentButton = new CustomButton("Grade Assignment");
        setSalaryButton = new CustomButton("Set Salary");
        removeTutorButton = new CustomButton("Remove Tutor");


        addLecturerButton.addActionListener(event ->{
            new AddLecturer(teacher);
        });

        addTutorButton.addActionListener(event ->{
            new AddTutor(teacher);
        });

        gradeAssignmentButton.addActionListener(event ->{
            new Functionality.GradeAssignment(teacher);
        });

        setSalaryButton.addActionListener(event ->{
            new SetSalary(teacher);
        });

        removeTutorButton.addActionListener(event ->{
            new RemoveTutor(teacher);
        });

        displayButton.addActionListener(event ->{
            new Display(teacher);
        });
        GridBagConstraints constraints = new GridBagConstraints();       // use GridBagConstraints (method) to set the position of components int the panel
        mainPanel.setLayout(new GridBagLayout());

        constraints.gridx= 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,10,50,10);
        mainPanel.add(addQuestionLabel,constraints);

        constraints.gridx= 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(0,10,5,10);
        mainPanel.add(displayButton,constraints);

        constraints.gridx= 1;
        constraints.gridy = 3;
        mainPanel.add(addLecturerButton,constraints);

        constraints.gridx= 1;
        constraints.gridy = 4;
        mainPanel.add(addTutorButton,constraints);

        constraints.gridx= 1;
        constraints.gridy = 5;
        mainPanel.add(gradeAssignmentButton,constraints);

        constraints.gridx= 1;
        constraints.gridy = 6;
        mainPanel.add(setSalaryButton,constraints);

        constraints.gridx= 1;
        constraints.gridy = 7;
        mainPanel.add(removeTutorButton,constraints);

        add(mainPanel);
    }
}
