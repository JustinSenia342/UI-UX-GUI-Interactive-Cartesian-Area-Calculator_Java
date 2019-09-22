/*
 * Programmer: Justin Senia
 */
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HW0405 extends JFrame{
    public HW0405(){
        setTitle("Rectangle Area Calculator");
        
        JFrame frame = new JFrame("hw0405");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new GridLayout(6, 1)); //6 rows, 1 column
        JPanel ulTextPanel = new JPanel();
        JPanel ulCoordPanel = new JPanel();
        JPanel brTextPanel = new JPanel();
        JPanel brCoordPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel answerPanel = new JPanel();
        
        JTextField ulXField = new JTextField("X value");
        ulXField.setEditable(true);
        JTextField ulYField = new JTextField("Y value");
        ulYField.setEditable(true);
        JTextField brXField = new JTextField("X value");
        brXField.setEditable(true);
        JTextField brYField = new JTextField("Y value");
        brYField.setEditable(true);
        JTextField areaAnswer = new JTextField("Answer");
        areaAnswer.setEditable(false);
        
        JButton calculateArea = new JButton("Calculate Area");
        calculateArea.addActionListener (new ActionListener (){
            public void actionPerformed(ActionEvent ev){
                String result = calculate(ulXField.getText(),ulYField.getText(),brXField.getText(),brYField.getText());
                areaAnswer.setText(result);
           } } );
           
        JButton randomizeInput = new JButton("Randomize Input");
        randomizeInput.addActionListener (new ActionListener (){
            public void actionPerformed(ActionEvent ev){
                int ulX = (int)(Math.random()*100);
                int ulY = (int)(Math.random()*100);
                int brX = (int)(Math.random()*100);
                int brY = (int)(Math.random()*100);
                while (brY >= ulY)
                    brY = (int)(Math.random()*100);
                while (brX <= ulX)
                    brX = (int)(Math.random()*100);
                ulXField.setText(String.valueOf(ulX));
                ulYField.setText(String.valueOf(ulY));
                brXField.setText(String.valueOf(brX));
                brYField.setText(String.valueOf(brY));
           } } );
        
        ulTextPanel.add(new JLabel(" Upper Left corner of a rectangle's Coordinates "));
           
        ulCoordPanel.add(new JLabel(" (X = "));
        ulCoordPanel.add(ulXField);
        ulCoordPanel.add(new JLabel(",  Y = "));
        ulCoordPanel.add(ulYField);
        ulCoordPanel.add(new JLabel(")"));
        
        brTextPanel.add(new JLabel(" Bottom Right corner of a rectangle's Coordinates "));
        
        brCoordPanel.add(new JLabel(" (X = "));
        brCoordPanel.add(brXField);
        brCoordPanel.add(new JLabel(",  Y = "));
        brCoordPanel.add(brYField);
        brCoordPanel.add(new JLabel(")"));
        
        buttonPanel.add(calculateArea);
        buttonPanel.add(randomizeInput);
        
        answerPanel.add(new JLabel(" Area = "));
        answerPanel.add(areaAnswer);
        
        add(ulTextPanel);
        add(ulCoordPanel);
        add(brTextPanel);
        add(brCoordPanel);
        add(buttonPanel);
        add(answerPanel);
    }
   
    String calculate (String ulXP, String ulYP, String brXP, String brYP){
        double length = Double.valueOf(brXP) - Double.valueOf(ulXP);
        double width = Double.valueOf(ulYP) - Double.valueOf(brYP);
        double areaAnswDbl = length * width;
        String areaAnswStr = String.valueOf(areaAnswDbl);
        return areaAnswStr;
    }
    
    public static void main(String[] args){
        HW0405 gui = new HW0405();
        gui.setVisible(true);
    }
}