/**Class: CIT-130-BIN1
Name: Meghan Moore
Date: 11/15/2014
Programming Assignment 13
Purpose: Implement a face that smiles/frowns.*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Assignment13 extends JFrame implements ActionListener{
  publilc static final int FACE_DIAMETER = 300;
  publilc static final int X_FACE = 75;
  publilc static final int Y_FACE = 75;
  
  publilc static final int EYE_WIDTH = 50;
  publilc static final int EYE_HEIGHT = 35;
  publilc static final int X_RIGHT_EYE = X_FACE + 80;
  publilc static final int Y_RIGHT_EYE = Y_FACE + 85;
  publilc static final int X_LEFT_EYE = X_FACE + 175;
  publilc static final int Y_LEFT_EYE = Y_FACE + 85;
  
  publilc static final int MOUTH_WIDTH = 150;
  publilc static final int MOUTH_HEIGHT = 75;
  publilc static final int X_MOUTH = X_FACE + 75;
  publilc static final int Y_MOUTH = Y_FACE + 150;
  publilc static final int MOUTH_START_ANGLE = 180;
  publilc int mouthArcSweep = 180;
  
  private JPanel panel;
  
  public static void main(String[] args) {
    Assignment12 gui = new Assignment12();
    gui.setVisible(true);
  } //end main
  
  public Assignment13(){
    setTitle("Smile/Frown Face Demo");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500,550);
    setLayout(new BorderLayout());
    panel = new JPanel();
    add(panel, "Center");
    panel.setSize(500, 500);
    
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    JButton startButton = new JButton("Cheer Up!");
    startButton.addActionListener(this);
    buttonPanel.add(startButton);
    add(buttonPanel, "South");
  } //end constructor
  
  public void actionPerformed(ActionEvent e){
    mouthArcSweep = -180;
    repaint();
    doNothing(8000); //wait 8 seconds
    mouthArcSweep = 180;
    repaint();
  } //end event listener
  
  public void paint(Graphics g){
    super.paint(g);
    g.drawOval(X_FACE, Y_FACE, FACE_DIAMETER, FACE_DIAMETER);
    //Draw Eyes:
    g.fillOval(X_RIGHT_EYE, Y_RIGHT_EYE, EYE_WIDTH, EYE_HEIGHT);
    g.fillOval(X_LEFT_EYE, Y_LEFT_EYE, EYE_WIDTH, EYE_HEIGHT);
    //Draw Mouth:
    g.drawArc(X_MOUTH, Y_MOUTH, MOUTH_WIDTH, MOUTH_HEIGHT, MOUTH_START_ANGLE, mouthArcSweep);
  } //end paint
  
  public void doNothing(int milliseconds){
    try{
      Thread.sleep(milliseconds);
    }
    catch{
      System.err.println("Unexpected interruption");
      System.exit(0);
    }
  } //end doNothing
}
