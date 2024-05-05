package Functionality;

import CourseWork1.Lecturer;
import CourseWork1.Teacher;
import CourseWork1.Tutor;
import CustomJPackages.CustomButton;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayTutor extends JFrame {
    CustomButton backButton;
    public DisplayTutor(ArrayList<Teacher> teachers) {
        super("Display Tutor");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel tutorDisplayPanel = new JPanel();
        tutorDisplayPanel.setLayout((new BoxLayout(tutorDisplayPanel, BoxLayout.Y_AXIS)));
        backButton = new CustomButton("Back");
        backButton.addActionListener(Action ->{
            back();
        });

        String[] columnNamesArray = {"Teacher Id", "Teacher Name", "Address", "Employment Status","Working Hours","Working Type","Salary", "Specialization", "Academic Qualification", "Performance Index"};
        ArrayList<Tutor> tutors = new ArrayList<>();
        for (Teacher teacher : teachers) {      // for (String "datatype" variable :collection)
            if (teacher instanceof Tutor) {
                tutors.add((Tutor) teacher);
            }
        }
        String[][] informationArray = new String[tutors.size()][10];
        for (int i = 0; i < tutors.size(); i++) {
            Tutor tutor = tutors.get(i);
            informationArray[i][0] = String.valueOf(tutor.getTeacherId());
            informationArray[i][1] = tutor.getTeacherName();
            informationArray[i][2] = tutor.getAddress();
            informationArray[i][3] = tutor.getEmploymentStatus();
            informationArray[i][4] = String.valueOf(tutor.getWorkingHours());
            informationArray[i][5] = tutor.getWorkingType();
            informationArray[i][6] = String.valueOf(tutor.getSalary());
            informationArray[i][7] = tutor.getSpecialization();
            informationArray[i][8] = tutor.getAcademicQualifications();
            informationArray[i][9] = String.valueOf(tutor.getPerformanceIndex());
        }
        JTable table = new JTable(informationArray, columnNamesArray);
        JScrollPane scrollPane = new JScrollPane(table);
        tutorDisplayPanel.add(scrollPane);
        tutorDisplayPanel.add(backButton,BoxLayout.class);

        add(tutorDisplayPanel);
    }
    public void back(){
        setVisible(false);
    }
}
