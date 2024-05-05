package CustomJPackages;

import javax.swing.*;
import java.awt.*;

public class CustomComboBox extends JComboBox{
    public CustomComboBox(String[] items){
        super(items);
        setFont(new java.awt.Font("Arial", Font.PLAIN, 15));
        setForeground(new java.awt.Color(0, 0, 0));
        setBackground(new java.awt.Color(255, 255, 255));
        setPopupVisible(false);
        setPreferredSize(new Dimension(250,30));
//        setMaximumRowCount(5);
    }
}
