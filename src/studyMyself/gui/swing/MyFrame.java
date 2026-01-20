package studyMyself.gui.swing;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class MyFrame {
    public static void main(String[] args) {

        JLabel label = new JLabel(); // set label
        JLabel label2 = new JLabel(); // set label
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

        ImageIcon image = new ImageIcon("images/doidoboceta.png"); // create an ImageIcon
        label.setText("fuck"); // set text
        // label.setText("Hello");
        label.setIcon(image); // set icon of label
        label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.blue); // or label.setForeground(new Color(0,255,0)); //custom color
        label.setFont(new Font("MV Boli", Font.PLAIN, 50));
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        label2.setVerticalAlignment(JLabel.TOP); // set vertical position of icon+text
        label2.setHorizontalAlignment(JLabel.RIGHT);
        // label.setIconTextGap(100);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.TOP); // set vertical position of icon+text
        label.setHorizontalAlignment(JLabel.CENTER);// set horizontsl position of icon+text
        label.setBounds(0, 0, 500, 400);

        JFrame frame = new JFrame();

        frame.setIconImage(image.getImage()); // change icon of this
        frame.setTitle("Java Crazy Coding"); // sets the title of the this
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of the application when the this is closed
        frame.setResizable(true); // prevent from being resized
        frame.setSize(505, 435); // sets the x dimension, y dimension of this
        frame.setLocation(500, 200); // where it will appear on my screen
        frame.setLayout(null); // deletes all; needed to make border
        frame.setVisible(true); // make this visible
        frame.getContentPane().setBackground(Color.white); // colour for background
        frame.add(label);
        frame.add(label2);

    }

}