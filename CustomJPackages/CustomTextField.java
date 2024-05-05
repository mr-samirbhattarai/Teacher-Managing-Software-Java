package CustomJPackages;

import javax.swing.*;
import java.awt.*;

public class CustomTextField extends JTextField {
    public CustomTextField(String text){
        super(text);
        setPreferredSize(new Dimension(250,30));
        setColumns(15);
        super.setBackground(new Color(255, 255, 255));
        super.setFont(new Font("Poppins",Font.PLAIN,14));
//        setMargin(new java.awt.Insets(0, 10, 0, 10));
    }

}