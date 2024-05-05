package Functionality;

import CourseWork1.Teacher;
import CourseWork1.Tutor;
import CustomJPackages.CustomButton;
import CustomJPackages.CustomComboBox;
import CustomJPackages.CustomLabel;
import CustomJPackages.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SetSalary extends JFrame {

    CustomLabel setSalaryLabel, teacherIdLabel, newSalaryLabel, newPerformanceIndexLabel;
    CustomTextField teacherIdTextField, newSalaryTextField;
    CustomComboBox newPerformanceIndexComboBox;
    CustomButton setSalaryButton, clearButton, displayButton, backButton;
    public SetSalary(ArrayList<Teacher> teachers) {
        super("Set Salary");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel setSalaryPanel = new JPanel();
        setSalaryPanel.setLayout(new GridBagLayout());
        setSalaryPanel.setBackground(Color.LIGHT_GRAY);

        // Labels
        setSalaryLabel = new CustomLabel("Set Salary");
        setSalaryLabel.setFont(new Font("Poppins", Font.PLAIN, 20));
        teacherIdLabel = new CustomLabel("Teacher Id");
        newSalaryLabel = new CustomLabel("Salary");
        newPerformanceIndexLabel = new CustomLabel("Performance Index");

        // TextFields
        teacherIdTextField = new CustomTextField("");
        newSalaryTextField = new CustomTextField("");

        // ComboBoxs
        newPerformanceIndexComboBox = new CustomComboBox(new String[]{"Select Performance Index", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});

        // Buttons
        setSalaryButton = new CustomButton("Set Salary");
        clearButton = new CustomButton("Clear");
        displayButton = new CustomButton("Display");
        backButton = new CustomButton("Back");

        // ActionListener
        setSalaryButton.addActionListener(Action ->{
            String teacherIdText = teacherIdTextField.getText();
            String newSalaryText = newSalaryTextField.getText();

            if(teacherIdText.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill the field for teacher id");
            }if(newSalaryText.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill the field for salary");
            }if(newPerformanceIndexComboBox.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null,"Please select an option for performance Index");
            }else{
                try{
                    int teacherId = Integer.parseInt(teacherIdText);
                    int newSalary = Integer.parseInt(newSalaryText);
                    int newPerformanceIndex = Integer.parseInt((String) (newPerformanceIndexComboBox.getSelectedItem()));

                    if (teacherId <= 0){
                        JOptionPane.showMessageDialog(null,"Error! Please Fill field for teacher id");
                    }else {
                        Tutor tutor = null;
                        for (Teacher teacher : teachers) {
                            if (teacher.getTeacherId() == teacherId && teacher instanceof Tutor) {
                                tutor = (Tutor) teacher;
                                break;
                            }
                        }
                        if (tutor != null) {
                            if (tutor.getTeacherId() == teacherId) {
                                if (newPerformanceIndex >= 5) {
                                    if (newPerformanceIndex >= tutor.getPerformanceIndex()) {
                                        if (newSalary == tutor.getSalary()) {
                                            if (tutor.getWorkingHours() > 20) {
                                                tutor.setSalary(newSalary, newPerformanceIndex);
                                                JOptionPane.showMessageDialog(null, "Salary set successfully.");
                                                clear();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Sorry! Salary cannot be approved.\nWorking Hours Less Than Required!!");
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Sorry! Salary cannot be approved.\nSalary mismatched!!");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Sorry! Salary cannot be approved.\n Performance Index mismatched!!");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Sorry! Salary cannot be approved\nPerformance index is less than 5");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Teacher Id not Found");
                            }
                        }
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Invalid Input");
                }
            }
        });

        clearButton.addActionListener(Action ->{
            clear();
        });

        backButton.addActionListener(Action ->{
            back();
        });

        displayButton.addActionListener(Action ->{
            new DisplayTutor(teachers);
        });



        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0,5,10,10);
        setSalaryPanel.add(setSalaryLabel,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,5,10,10);
        setSalaryPanel.add(teacherIdLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,5,10,10);
        setSalaryPanel.add(teacherIdTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0,5,10,10);
        setSalaryPanel.add(newSalaryLabel,constraints);


        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,5,10,10);
        setSalaryPanel.add(newSalaryTextField,constraints);


        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0,5,10,10);
        setSalaryPanel.add(newPerformanceIndexLabel,constraints);


        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,5,10,10);
        setSalaryPanel.add(newPerformanceIndexComboBox,constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0,100,5,100);
        constraints.anchor = GridBagConstraints.CENTER;
        setSalaryPanel.add(setSalaryButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        setSalaryPanel.add(displayButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        setSalaryPanel.add(clearButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        setSalaryPanel.add(backButton,constraints);

        add(setSalaryPanel);
    }
    public void clear() {
        teacherIdTextField.setText("");
        newSalaryTextField.setText("");
        newPerformanceIndexComboBox.setSelectedIndex(0);
    }
    public void back(){
        setVisible(false);
    }
}
