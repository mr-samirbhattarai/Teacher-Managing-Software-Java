package Functionality;

import CourseWork1.Lecturer;
import CourseWork1.Teacher;
import CustomJPackages.CustomButton;
import CustomJPackages.CustomLabel;
import CustomJPackages.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.jar.JarFile;

public class GradeAssignment extends JFrame {
    CustomLabel gradeAssignmentLabel, teacherIdLabel, gradedScoreLabel, departmentLabel, yearsOfExperienceLabel;
    CustomTextField teacherIdTextField, gradedScoreTextField, departmentTextField, yearsOfExperienceTextField;
    CustomButton gradeScoreButton, backButton, displayButton, clearButton;

    public GradeAssignment(ArrayList<Teacher> teachers){
        super("Grade Assignment");
        setSize(500,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // create panel
        JPanel gradeAssignmentPanel = new JPanel();
        gradeAssignmentPanel.setLayout(new GridBagLayout());
        gradeAssignmentPanel.setBackground(Color.LIGHT_GRAY);

        // create labels
        gradeAssignmentLabel = new CustomLabel("Grade Assignment");
        gradeAssignmentLabel.setFont(new Font("Poppins", Font.BOLD,20));


        teacherIdLabel = new CustomLabel("Teacher Id");
        gradedScoreLabel = new CustomLabel("Graded Score");
        departmentLabel = new CustomLabel("Department");
        yearsOfExperienceLabel = new CustomLabel("Years Of Experience");

        // create text fields
        teacherIdTextField = new CustomTextField("");
        gradedScoreTextField = new CustomTextField("");
        departmentTextField = new CustomTextField("");
        yearsOfExperienceTextField = new CustomTextField("");

        // create buttons
        gradeScoreButton = new CustomButton("Grade Score");
        backButton = new CustomButton("Back");
        displayButton = new CustomButton("Display");
        clearButton = new CustomButton("Clear");

        // actionListener
        gradeScoreButton.addActionListener(Action ->{
            String teacherIdText = teacherIdTextField.getText();
            String gradedScoreText = gradedScoreTextField.getText();
            String departmentText = departmentTextField.getText();
            String yearsOfExperienceText = yearsOfExperienceTextField.getText();

            if(teacherIdText.isEmpty()){        // || Integer.parseInt(teacherIdText)<=0 || gradedScoreText.isEmpty() || departmentText.isEmpty() ||  yearsOfExperienceText.isEmpty() ||  Integer.parseInt(yearsOfExperienceText)<=0) {
                JOptionPane.showMessageDialog(null, "Please fill the field for teacher Id");
            }else if(departmentText.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill the field for department");
            }else if(yearsOfExperienceText.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill the field for years of experience");
            }else if(gradedScoreText.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill the field for years of experience");
            }else{
                try {
                    int teacherId = Integer.parseInt(teacherIdText);
                    int gradedScore = Integer.parseInt(gradedScoreText);
                    int yearsOfExperience = Integer.parseInt(yearsOfExperienceText);

                    if(teacherId <= 0){         // || gradedScore<=0 || gradedScore > 100 || yearsOfExperience <= 0){
                        JOptionPane.showMessageDialog(null,"Error! Teachers Id can't be negative");
                    }else if(gradedScore <= 0){
                        JOptionPane.showMessageDialog(null,"Error! Graded Score can't be negative");
                    }else if(gradedScore > 100){
                        JOptionPane.showMessageDialog(null,"Error! Graded Score can't be more than 100");
                    }else if(yearsOfExperience <= 0){
                        JOptionPane.showMessageDialog(null,"Error! Years of Experience can't be negative");
                    }
                    else {
                        Lecturer lecturer = null;
                        for (Teacher teacher : teachers) {
                            if (teacher.getTeacherId() == teacherId && teacher instanceof Lecturer) {
                                lecturer = (Lecturer) teacher;
                                break;
                            }
                        }
                        if (lecturer != null) {
                            if (lecturer.getDepartment().equals(departmentText)) {
                                if (yearsOfExperience >= 5) {
                                    // Update graded score
                                    lecturer.gradeAssignment(gradedScore,departmentText,yearsOfExperience);
                                    JOptionPane.showMessageDialog(null, "Successfully Graded!");
                                    clear();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Teacher doesn't have enough experience to grade.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Teacher not found in the specified department.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Teacher Not Found!");
                        }
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Enter Proper input");
                }
            }
        });

        // clear button function
        clearButton.addActionListener(Action ->{
            clear();
        });

        // back button function
        backButton.addActionListener(Action ->{
            back();
        });

        // back button function
        displayButton.addActionListener(Action ->{
            new DisplayLecturer(teachers);
        });


        GridBagConstraints constraints= new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0,5,10,10);
        gradeAssignmentPanel.add(gradeAssignmentLabel,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,5,10,10);
        gradeAssignmentPanel.add(teacherIdLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,5,10,10);
        gradeAssignmentPanel.add(teacherIdTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0,5,10,10);
        gradeAssignmentPanel.add(gradedScoreLabel,constraints);


        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,5,10,10);
        gradeAssignmentPanel.add(gradedScoreTextField,constraints);


        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0,5,10,10);
        gradeAssignmentPanel.add(departmentLabel,constraints);


        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,5,10,10);
        gradeAssignmentPanel.add(departmentTextField,constraints);


        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0,5,10,10);
        gradeAssignmentPanel.add(yearsOfExperienceLabel,constraints);


        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,5,10,10);
        gradeAssignmentPanel.add(yearsOfExperienceTextField,constraints);


        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,100,5,100);
        gradeAssignmentPanel.add(gradeScoreButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        gradeAssignmentPanel.add(displayButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        gradeAssignmentPanel.add(clearButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        gradeAssignmentPanel.add(backButton,constraints);

        add(gradeAssignmentPanel);

    }

    // clear method
    public void clear() {
        teacherIdTextField.setText("");
        gradedScoreTextField.setText("");
        departmentTextField.setText("");
        yearsOfExperienceTextField.setText("");
    }

    // back method
    public void back(){
        setVisible(false);
    }


}