/*
	Author:
		Suraj Singh Bisht
		surajsinghbisht054@gmail.com

*/

// importing modules
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;



// Creating Frame Subclass
public class helloworld extends Frame {

	// Constructor
	public helloworld(){
		super("Hello World Example");
		System.out.println("Hello World Constructor Call");
		prepareGUI();
	}

	// Static Main Function
	public static void main(String[] args){
		System.out.println("Main Method Call");
		// Creating 
		helloworld root = new helloworld();
		root.setVisible(true);
	}

	private void prepareGUI(){
		System.out.println("Prepare GUI Method Call");

		setSize(400,400);
		addWindowListener(new WindowAdapter() {
       			public void windowClosing(WindowEvent windowEvent){
			System.exit(0);
			}
      	});
   }

	@Override
	public void paint(Graphics g) {
		System.out.println("Paint");

		g.setColor(Color.GRAY);
		Font font = new Font("Serif", Font.PLAIN, 24);
		g.setFont(font);
		g.drawString("Welcome to TutorialsPoint", 50, 150);      
   }

}
