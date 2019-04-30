/*
	Author:
		Suraj Singh Bisht
		surajsinghbisht054@gmail.com

*/

// import module
//import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;



// Our GUI Class 
public class ReflectMsg {

	// decleration of objects
	private JFrame frame;
	private JLabel label1;
	private JLabel label2;
	private JPanel panel1;
	private JButton button;

	// constructor
	ReflectMsg(){
		prepareGUI();	// prepare GUI Function Call

	}




	// Prepare GUI Object
	public void prepareGUI(){
		// creating frame object
		frame = new JFrame("Reflect Message Frome");
		// creating button
		button = new JButton("Click Here");
		// button bounds
		button.setBounds(130, 100, 100, 40);
		// Adding Button into Frame
		frame.add(button);
		// frame size
		frame.setSize(400, 500);
		// set frame layout type
		frame.setLayout(null);
		// set frame visibility
		frame.setVisible(true);


	}


	// our main function
	public static void main(String[] args){
		ReflectMsg root = new ReflectMsg();
	}




}



