package Functionality;

import CourseWork1.Lecturer;
import CourseWork1.Teacher;
import CourseWork1.Tutor;
import CustomJPackages.CustomButton;
import CustomJPackages.CustomComboBox;
import CustomJPackages.CustomLabel;
import CustomJPackages.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddTutor extends JFrame {
    CustomLabel titleLabel, teacherIdLabel, teacherNameLabel, addressLabel, workingTypeLabel, employmentStatusLabel, workingHoursLabel, salaryLabel, specializationLabel, academicQualificationLabel, performanceIndexLabel;
    CustomTextField teacherIdTextField, teacherNameTextField, addressTextField, workingHoursTextField, salaryTextField, specializationTextField;
    CustomComboBox workingTypeComboBox, employmentStatusComboBox, academicQualificationComboBox, performanceIndexComboBox;
    CustomButton addTutorButton, clearButton, backButton, displayTutorButton, goBackButton;

    public AddTutor(ArrayList<Teacher> teachers) {
        super("Add Tutor");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel tutorPanel = new JPanel();
        tutorPanel.setBackground(Color.LIGHT_GRAY);
        tutorPanel.setLayout(new GridBagLayout());

        titleLabel = new CustomLabel("Add Tutor");
        titleLabel.setFont(new Font("Poppins", Font.BOLD,20));

        teacherIdLabel = new CustomLabel("Teacher Id");
        teacherNameLabel = new CustomLabel("Teacher Name");
        addressLabel = new CustomLabel("Address");
        workingTypeLabel = new CustomLabel("Working Type");
        employmentStatusLabel = new CustomLabel("Employment Status");
        workingHoursLabel = new CustomLabel("Working Hours");
        salaryLabel = new CustomLabel("Salary");
        specializationLabel = new CustomLabel("Specialization");
        academicQualificationLabel = new CustomLabel("Academic Qualification");
        performanceIndexLabel = new CustomLabel("Performance Index");

        teacherIdTextField = new CustomTextField("");
        teacherNameTextField = new CustomTextField("");
        addressTextField = new CustomTextField("");
        workingHoursTextField = new CustomTextField("");
        salaryTextField = new CustomTextField("");
        specializationTextField = new CustomTextField("");

        workingTypeComboBox = new CustomComboBox(new String[]{"Select Working Type", "Full Time", "Part Time", "Module Wise"});
        employmentStatusComboBox = new CustomComboBox(new String[]{"Select Employment Status", "In-Field", "Remote"});
        academicQualificationComboBox = new CustomComboBox(new String[]{"Select Academic Qualification", "Bachelor", "Master", "Phd"});
        performanceIndexComboBox = new CustomComboBox(new String[]{"Select Performance Index", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});


        addTutorButton = new CustomButton("Add Tutor");
        clearButton = new CustomButton("Clear");
        backButton = new CustomButton("Back");
        displayTutorButton = new CustomButton("Display Tutor");
        goBackButton = new CustomButton("Back");

        //Action Listener
        addTutorButton.addActionListener(Action -> {
            String teacherIdText = teacherIdTextField.getText();
            String teacherNameText = teacherNameTextField.getText();
            String addressText = addressTextField.getText();
            String workingHoursText = workingHoursTextField.getText();
            String salaryText = salaryTextField.getText();
            String specializationText = specializationTextField.getText();


            if (teacherIdText.isEmpty()){           // || teacherNameText.isEmpty() || addressText.isEmpty() || workingTypeComboBox.getSelectedIndex()== 0 || employmentStatusComboBox.getSelectedIndex()== 0 || workingHoursText.isEmpty() || salaryText.isEmpty() || specializationText.isEmpty() || academicQualificationComboBox.getSelectedIndex() == 0 || performanceIndexComboBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Please fill the field for teacher id");
            }else if(teacherNameText.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill the field for teacher name");
            }else if(addressText.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill the field for address");
            }else if(workingTypeComboBox.getSelectedIndex()== 0){
                JOptionPane.showMessageDialog(null, "Please fill the field for working type");
            }else if(employmentStatusComboBox.getSelectedIndex()== 0) {
                JOptionPane.showMessageDialog(null, "Please fill the field for employment status");
            }else if(workingHoursText.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill the field for working type");
            }else if(salaryText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill the field for salary");
            }else if(specializationText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill the field for specialization");
            }else if(academicQualificationComboBox.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Please fill the field for academic qualification");
            }else if(performanceIndexComboBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Please fill the field for performance index");
            }else{
                try{
                    int teacherId = Integer.parseInt(teacherIdText);
                    String workingType = (String) workingTypeComboBox.getSelectedItem();
                    String employmentStatus = (String) employmentStatusComboBox.getSelectedItem();
                    int workingHours = Integer.parseInt(workingHoursText);
                    double salary = Double.parseDouble(salaryText);
                    String academicQualification = (String) academicQualificationComboBox.getSelectedItem();
                    int performanceIndex = Integer.parseInt((String) (performanceIndexComboBox.getSelectedItem()));

                    if(teacherId <= 0){         // || workingHours <= 0 || salary <= 0 || performanceIndex <= 0){
                        JOptionPane.showMessageDialog(null,"Error!\nTeacher Id cannot be negative");
                    }else if (workingHours <= 0){
                        JOptionPane.showMessageDialog(null,"Error!\nWorking Hours cannot be negative");
                    }else if (performanceIndex <= 0){
                        JOptionPane.showMessageDialog(null,"Error!\nPerformance index cannot be negative");
                    }
                    else{
                        for(Teacher teacher: teachers){
                            if(teacher.getTeacherId() == teacherId){
                                JOptionPane.showMessageDialog(null,"invalid Teacher Id! Teacher Id Assigned Already");
                                return;
                            }
                        }
                        Tutor tutor = new Tutor(teacherId, (String) teacherNameText, addressText, workingType, employmentStatus, workingHours, salary, (String) specializationText, academicQualification, performanceIndex);               //??????????????
                        teachers.add(tutor);
                        JOptionPane.showMessageDialog(null,"Successfully added Tutor");
                        clear();
                    }
            }catch (Exception error){   // exception handling
                JOptionPane.showMessageDialog(null,"Invalid input!\nPlease recheck your data");
            }

        }
        });

        clearButton.addActionListener(Action ->{
            clear();
        });

        displayTutorButton.addActionListener(Action ->{
            new DisplayTutor(teachers);
        });

        goBackButton.addActionListener(Action ->{
            back();
        });

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0,10,15,10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(titleLabel,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        tutorPanel.add(teacherIdLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(teacherIdTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        tutorPanel.add(teacherNameLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(teacherNameTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        tutorPanel.add(addressLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(addressTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        tutorPanel.add(workingHoursLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(workingHoursTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        tutorPanel.add(salaryLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(salaryTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        tutorPanel.add(specializationLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(specializationTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        tutorPanel.add(workingTypeLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(workingTypeComboBox,constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(employmentStatusLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 8;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(employmentStatusComboBox,constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(academicQualificationLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 9;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(academicQualificationComboBox,constraints);

        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.gridwidth = 0;
        constraints.anchor = GridBagConstraints.EAST;
        tutorPanel.add(performanceIndexLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 10;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(performanceIndexComboBox,constraints);

        constraints.gridx = 0;
        constraints.gridy = 11;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0,100,5,100);
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(addTutorButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 12;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(displayTutorButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 13;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(clearButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 14;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        tutorPanel.add(goBackButton,constraints);

        add(tutorPanel, BorderLayout.CENTER);
    }
    public void clear(){
        teacherIdTextField.setText("");
        teacherNameTextField.setText("");
        addressTextField.setText("");
        workingTypeComboBox.setSelectedIndex(0);
        employmentStatusComboBox.setSelectedIndex(0);
        workingHoursTextField.setText("");
        salaryTextField.setText("");
        specializationTextField.setText("");
        academicQualificationComboBox.setSelectedIndex(0);
        performanceIndexComboBox.setSelectedIndex(0);
    }

    public void back(){
        setVisible(false);
    }
}
