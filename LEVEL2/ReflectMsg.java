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
		frame = new JFrame();
		button = new JButton("Click Here");
		button.setBounds(130, 100, 100, 40);
		frame.add(button);
		frame.setSize(400, 500);
		frame.setVisible(true);


	}


	// our main function
	public static void main(String[] args){
		ReflectMsg root = new ReflectMsg();
	}




}



