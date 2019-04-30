/*
	Author:
		Suraj Singh Bisht
		surajsinghbisht054@gmail.com

*/

// import module
//import java.awt.*;
//import java.awt.event.*;
import java.awt.event.*;
import javax.swing.*;




// Our GUI Class 
public class ReflectMsg {

	// decleration of objects
	private JFrame frame;
	private String WindowName;
	private JLabel label1;
	private JLabel label2;
	private JPanel panel1;
	private JButton button;

	// static constructor
	ReflectMsg(){
		//prepareGUI();	// prepare GUI Function Call

	}

	ReflectMsg(String s){
		WindowName = s;
		prepareGUI();
	}





	// Prepare GUI Object
	public void prepareGUI(){

		// creating frame object
		frame = new JFrame(WindowName);

		// creating button
		button = new JButton("Click Here");

		// button bounds
		button.setBounds(130, 100, 100, 40);

		// button event listner
		button.addActionListener(new CloseListener());

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
		String windowname = "YESH";
		ReflectMsg root = new ReflectMsg(windowname);
	}




}



// Event Object Created
class CloseListener extends ReflectMsg implements ActionListener{

        public void actionPerformed(ActionEvent e){
                        System.exit(0);
                }

}


