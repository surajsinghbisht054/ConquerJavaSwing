import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class helloworld extends Frame {

	public helloworld(){
		super("Hello World Example");
		prepareGUI();
	}

	public static void main(String[] args){
		helloworld root = new helloworld();
		root.setVisible(true);
	}

private void prepareGUI(){
	setSize(400,400);
	addWindowListener(new WindowAdapter() {
       		public void windowClosing(WindowEvent windowEvent){
		System.exit(0);
		}
      	});
   }

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		Font font = new Font("Serif", Font.PLAIN, 24);
		g.setFont(font);
		g.drawString("Welcome to TutorialsPoint", 50, 150);      
   }

}
