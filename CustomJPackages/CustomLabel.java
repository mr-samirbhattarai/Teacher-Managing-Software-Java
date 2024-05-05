package CustomJPackages;

import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel {

    public CustomLabel(String text) {
        super(text);
        super.setForeground(new Color(0, 0, 0));
        super.setFont(new Font("Poppins", Font.PLAIN, 17));
    }
}