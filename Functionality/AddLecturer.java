package Functionality;

import CourseWork1.Lecturer;
import CourseWork1.Teacher;
import CustomJPackages.CustomButton;
import CustomJPackages.CustomComboBox;
import CustomJPackages.CustomLabel;
import CustomJPackages.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddLecturer extends JFrame {
    CustomLabel titleLabel,teacherIdLabel, teacherNameLabel, addressLabel, workingTypeLabel, employmentStatusLabel, departmentLabel, yearsOfExperienceLabel;
    CustomTextField teacherIdTextField, teacherNameTextField, addressTextField, departmentTextField, yearsOfExperienceTextField;
    CustomComboBox workingTypeComboBox, employmentStatusComboBox;
    CustomButton addLecturerButton, clearButton, backButton, displayLecturerButton, goBackButton;
    public AddLecturer(ArrayList<Teacher> teachers) {
        super("Add Tutor");
        setSize(600, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel lecturerPanel = new JPanel();
        lecturerPanel.setBackground(Color.LIGHT_GRAY);
        lecturerPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();


        // Label
        titleLabel = new CustomLabel("Add Lecturer");
        titleLabel.setFont(new Font("Poppins", Font.BOLD,20));

        teacherIdLabel = new CustomLabel("Teacher Id");
        teacherNameLabel = new CustomLabel("Teacher Name");
        addressLabel = new CustomLabel("Address");
        workingTypeLabel = new CustomLabel("Working Type");
        employmentStatusLabel = new CustomLabel("Employment Status");
        departmentLabel = new CustomLabel("Department");
        yearsOfExperienceLabel = new CustomLabel(" Years Of Experience");

        // TextField
        teacherIdTextField = new CustomTextField("");
        teacherNameTextField = new CustomTextField("");
        addressTextField = new CustomTextField("");
        departmentTextField = new CustomTextField("");
        yearsOfExperienceTextField = new CustomTextField("");

        // ComboBoxs
        workingTypeComboBox = new CustomComboBox(new String[]{"Select Working Type", "Full Time", "Part Time", "Module Wise"});
        employmentStatusComboBox = new CustomComboBox(new String[]{"Select Employment Status", "In-Field", "Remote"});

        // Buttons
        addLecturerButton = new CustomButton("Add Lecturer");
        clearButton = new CustomButton("Clear");
        backButton = new CustomButton("Back");
        displayLecturerButton = new CustomButton("Display Lecturer");
        goBackButton = new CustomButton("Back");

        // Action Listener
        addLecturerButton.addActionListener(Action -> {
            String teacherIdText = teacherIdTextField.getText();
            String teacherNameText = teacherNameTextField.getText();
            String addressText = addressTextField.getText();
            String departmentText = departmentTextField.getText();
            String yearsOfExperienceText = yearsOfExperienceTextField.getText();


        if (teacherIdText.isEmpty()){ //|| teacherNameText.isEmpty() || addressText.isEmpty() || workingTypeComboBox.getSelectedIndex()== 0 || employmentStatusComboBox.getSelectedIndex()== 0  || departmentText.isEmpty() || yearsOfExperienceText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill the field for teacher id");
        }else if(teacherNameText.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill the field for teacher name");
        }else if(addressText.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill the field for address");
        }else if(workingTypeComboBox.getSelectedIndex()== 0){
            JOptionPane.showMessageDialog(null, "Please fill the field for working type");
        }else if(employmentStatusComboBox.getSelectedIndex()== 0){
            JOptionPane.showMessageDialog(null, "Please fill the field for employment status");
        }else if(departmentText.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill the field for department");
        }else if(yearsOfExperienceText.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill the field for years of experience");
        }
        else{
            try{        // try block
                int teacherId = Integer.parseInt(teacherIdText);
                int yearsOfExperience = Integer.parseInt(yearsOfExperienceText);
                String workingType = (String) workingTypeComboBox.getSelectedItem();
                String employmentStatus = (String) employmentStatusComboBox.getSelectedItem();
                if(teacherId <= 0 ){
                    JOptionPane.showMessageDialog(null,"Error! Teacher Id cannot be negative");
                }else if(yearsOfExperience <= 0){
                    JOptionPane.showMessageDialog(null, "Error! Years cannot be negative");
                }else {
                    for(Teacher teacher: teachers){
                        if(teacher.getTeacherId() == teacherId){
                            JOptionPane.showMessageDialog(null,"invalid Teacher Id! Teacher Id Assigned Already");
                            return;
                        }
                    }
                    Lecturer lecturer = new Lecturer(teacherId, (String) teacherNameText, (String) addressText, workingType, employmentStatus, departmentText, yearsOfExperience);
                    teachers.add(lecturer);
                    JOptionPane.showMessageDialog(null, "Successfully added Lecturer");
                    clear();
                }

            }catch (Exception error){   // exception handling with catch statement
                JOptionPane.showMessageDialog(null,"Invalid input!\nPlease recheck your data");
            }
        }
        });

        clearButton.addActionListener(Action ->{
            clear();
        });

        displayLecturerButton.addActionListener(Action ->{
            new DisplayLecturer(teachers);
        });

        goBackButton.addActionListener(Action ->{
            back();

        });


        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(0,10,15,10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(titleLabel,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        lecturerPanel.add(teacherIdLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(teacherIdTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        lecturerPanel.add(teacherNameLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(teacherNameTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        lecturerPanel.add(addressLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(addressTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(departmentLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(departmentTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(yearsOfExperienceLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(yearsOfExperienceTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(workingTypeLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(workingTypeComboBox,constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(employmentStatusLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(employmentStatusComboBox,constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0,100,5,100);
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(addLecturerButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(displayLecturerButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(clearButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 11;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        lecturerPanel.add(goBackButton,constraints);

        add(lecturerPanel);
    }
    public void clear(){
        teacherIdTextField.setText("");
        teacherNameTextField.setText("");
        addressTextField.setText("");
        workingTypeComboBox.setSelectedIndex(0);
        employmentStatusComboBox.setSelectedIndex(0);
        departmentTextField.setText("");
        yearsOfExperienceTextField.setText("");
        }

    public void back(){
        setVisible(false);
    }
}