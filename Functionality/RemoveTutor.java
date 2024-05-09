package Functionality;

import CourseWork1.Teacher;
import CourseWork1.Tutor;
import CustomJPackages.CustomButton;
import CustomJPackages.CustomLabel;
import CustomJPackages.CustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.jar.JarFile;

public class RemoveTutor extends JFrame {
    CustomLabel removeTutorLabel, teacherIdLabel;
    CustomTextField teacherIdTextField;
    CustomButton removeTutorButton, clearButton, backButton, displayButton;

    public RemoveTutor(ArrayList<Teacher> teachers){

        super("Remove Tutor");
        setSize(500,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel removeTutorPanel = new JPanel();
        removeTutorPanel.setLayout(new GridBagLayout());
        removeTutorPanel.setBackground(Color.LIGHT_GRAY);
        // Labels
        removeTutorLabel = new CustomLabel("Remove Tutor");
        removeTutorLabel.setFont(new Font("Poppins", Font.BOLD,20));
        teacherIdLabel = new CustomLabel("Teacher Id");

        // TextFields
        teacherIdTextField = new CustomTextField("");

        // Buttons
        removeTutorButton = new CustomButton("Remove");
        clearButton = new CustomButton("Clear");
        backButton = new CustomButton("Back");
        displayButton = new CustomButton("Display Tutor");

        removeTutorButton.addActionListener(Action ->{
            String teacherIdText = teacherIdTextField.getText();

            if(teacherIdText.isEmpty()){
                JOptionPane.showMessageDialog(null,"Error! Please Input correct Value");
            }else {
                try {
                    int teacherId = Integer.parseInt(teacherIdText);

                    for(Teacher teacher : teachers) {
                        if (  teacher.getTeacherId() == teacherId && teacher instanceof Tutor) {
                            Tutor tutor = (Tutor) teacher;
                            if (tutor.getIsCertified()) {
                                JOptionPane.showMessageDialog(null, "Tutor Certified, cant remove");
                            } else {
                                tutor.removeTutor();
                                JOptionPane.showMessageDialog(null, "Tutor successfully removed");
                                clear();
                            }
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null, "Tutor Not Found");
                        }
                        break;
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Enter Proper input");
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

        GridBagConstraints constraints= new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0,5,10,10);
        removeTutorPanel.add(removeTutorLabel,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,5,10,10);
        removeTutorPanel.add(teacherIdLabel,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0,5,10,10);
        removeTutorPanel.add(teacherIdTextField,constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0,100,5,100);
        constraints.anchor = GridBagConstraints.CENTER;
        removeTutorPanel.add(removeTutorButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        removeTutorPanel.add(displayButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        removeTutorPanel.add(clearButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        removeTutorPanel.add(backButton,constraints);

    add(removeTutorPanel);
    }
    public void clear() {
        teacherIdTextField.setText("");
    }
    public void back(){
        setVisible(false);
    }
}
