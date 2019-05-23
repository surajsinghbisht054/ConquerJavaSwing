package CodeRail;

// import modules
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;


// editor class name
public class editor extends JTextArea implements DocumentListener {

	// Constructor
	public editor(int w, int h){
		super(w, h);
		// Configurations
		setVisible(true);
		setFocusable(true);
		getDocument().addDocumentListener(this);
	}

	// Overrided Event Listeners
	public void changedUpdate(DocumentEvent doc){

	}
	public void removeUpdate(DocumentEvent doc){
	
	}
	public void insertUpdate(DocumentEvent doc){
	}

	/*

	USEFUL Methods

	copy()
	cut()
	getSelectedText()
	getSelectionEnd
	getSelectionStart
	getText
	getText <-- Specific Portion
	paste
	replaceSelection
	select
	selectAll
	setText
	updateUI

	*/


	// main function trigger 
	public static void main(String[] args){
		
		// Create Window Frame
		JFrame obj1 = new JFrame("Test Object");

		// Window Configuration
		//obj1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		obj1.setSize(300, 400);
		obj1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		obj1.setVisible(true);
		obj1.setFocusable(true);
		
		// Create Text Area Object
		editor obj = new editor(200, 300);
		obj1.add(obj);
		
	}

}


