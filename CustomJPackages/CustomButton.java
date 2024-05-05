package CustomJPackages;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(true);
        setFont(new java.awt.Font("Poppins", Font.BOLD, 14));
        setForeground(new Color(255, 255, 255));
        setBackground(new Color(22, 56, 91));
        setMargin(new Insets(10, 10, 10, 10));
        setPreferredSize(new Dimension(250,50));
        setOpaque(false);
    }
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isPressed()) {
                    g.setColor(Color.lightGray);
                }else if(getModel().isRollover()){
                    g.setColor(new Color(22, 56, 72));
                }
                else {
                    g.setColor(getBackground());
                }
                g.fillRoundRect(0, 0, getWidth() -1, getHeight() -1, 35, 35);
                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                g.setColor(getForeground());
                g.drawRoundRect(0, 0, getWidth() -1, getHeight() -1, 35, 35);
            }
}
