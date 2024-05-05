package Functionality;

import CourseWork1.Lecturer;
import CourseWork1.Teacher;
import CustomJPackages.CustomButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display extends JFrame {
    CustomButton backButton;
    public Display(ArrayList<Teacher> teachers){
        super("Display");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200,500);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout((new BoxLayout(displayPanel, BoxLayout.Y_AXIS)));
        backButton = new CustomButton("Back");
        backButton.setPreferredSize(new Dimension(500,50));
        backButton.addActionListener(Action -> {
            back();
        });



        String[] columnsNamesArray = {"Teacher Id", "Teacher Name", "Address", "Working Type", "Employment Status", "Teacher Type"};
//        ArrayList<Teacher> teacher = new ArrayList<>();
//        for (Teacher teacher1: teachers){
//            teachers.add((Teacher) teacher1);
//        }

        String[][] informationArray = new String[teachers.size()][6];
        for (int i=0; i<teachers.size();i++){
            Teacher teacher = teachers.get(i);
            informationArray[i][0] = String.valueOf(teacher.getTeacherId());
            informationArray[i][1] = teacher.getTeacherName();
            informationArray[i][2] = teacher.getAddress();
            informationArray[i][3] = teacher.getWorkingType();
            informationArray[i][4] = teacher.getEmploymentStatus();
            informationArray[i][5] = teacher instanceof Lecturer? "Lecturer" : "Tutor";

        }
        JTable table = new JTable(informationArray,columnsNamesArray);
        JScrollPane scrollPane = new JScrollPane(table);
        displayPanel.add(scrollPane);
        displayPanel.add(backButton,BoxLayout.class);

        add(displayPanel);
    }
    public void back(){
        setVisible(false);
    }
}
