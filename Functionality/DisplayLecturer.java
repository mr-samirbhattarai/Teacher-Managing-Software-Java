package Functionality;

import CourseWork1.Lecturer;
import CourseWork1.Teacher;
import CustomJPackages.CustomButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DisplayLecturer extends JFrame {
    CustomButton backButton;

    public DisplayLecturer(ArrayList<Teacher> teachers) {
        super("Display Lecturer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel lecturerDisplayPanel = new JPanel();
        lecturerDisplayPanel.setLayout((new BoxLayout(lecturerDisplayPanel, BoxLayout.Y_AXIS)));
        backButton = new CustomButton("Back");
        backButton.addActionListener(Action ->{
            back();
        });

        String[] columnNamesArray = {"Teacher Id", "Teacher Name", "Address","Employment Status", "Department", "Years of Experience", "Working Type ", "Graded Score"};
        ArrayList<Lecturer> lecturers = new ArrayList<>();
        for (Teacher teacher : teachers) {      // for (String "datatype" variable :collection)
            if (teacher instanceof Lecturer) {
                lecturers.add((Lecturer) teacher);
            }
        }
        String[][] informationArray = new String[lecturers.size()][8];
        for (int i = 0; i < lecturers.size(); i++) {
            Lecturer lecturer = lecturers.get(i);
            informationArray[i][0] = String.valueOf(lecturer.getTeacherId());
            informationArray[i][1] = lecturer.getTeacherName();
            informationArray[i][2] = lecturer.getAddress();
            informationArray[i][3] = lecturer.getEmploymentStatus();
            informationArray[i][4] = lecturer.getDepartment();
            informationArray[i][5] = String.valueOf(lecturer.getYearsOfExperience());
            informationArray[i][6] = lecturer.getWorkingType();
            informationArray[i][7] = String.valueOf(lecturer.getGradedScore());
        }
        JTable table = new JTable(informationArray, columnNamesArray);
        JScrollPane scrollPane = new JScrollPane(table);
        lecturerDisplayPanel.add(scrollPane);
        lecturerDisplayPanel.add(backButton,BoxLayout.class);

        add(lecturerDisplayPanel);

    }
    public void back(){
        setVisible(false);
    }
}
