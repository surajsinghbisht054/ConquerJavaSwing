//package CodeRail;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.undo.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.UIManager;




class CombinedControls extends JFrame implements ActionListener {
	private AddMenuBar menu;
	private editor obj;
	private UndoManager manager; 

	CombinedControls(){
		super("CodeRail Text");

		// Window Configuration

		//obj1.setExtendedState(JFrame.MAXIMIZED_BOTH);		
		setSize(1000, 700);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		setFocusable(true);
		

		// Create TextArea Object
		obj = new editor(900, 700);

		manager = new UndoManager();
		obj.getDocument().addUndoableEditListener(manager);

		//pack();
		
		// Create Menu Bar Object
		menu = new AddMenuBar();
		//System.out.println((ActionListener)this);
		//menu.registerListener(this);
		
		//setting backgound color of menu bar
		menu.setBackground(Color.black);


		// Add Object
		add(menu);
		add(obj);
		setJMenuBar(menu);  
		registerListener();
		setVisible(true);

	}
	public void registerListener(){

		// menu file items
		menu.menu_file_new.addActionListener(this);
		menu.menu_file_open.addActionListener(this);
		menu.menu_file_save.addActionListener(this);
		menu.menu_file_saveas.addActionListener(this);
		menu.menu_file_print.addActionListener(this);
		menu.menu_file_exit.addActionListener(this);


		// menu edit
		menu.menu_edit_undo.addActionListener(this);
		menu.menu_edit_redo.addActionListener(this);
		menu.menu_edit_cut.addActionListener(this);
		menu.menu_edit_copy.addActionListener(this);
		menu.menu_edit_paste.addActionListener(this);
		menu.menu_edit_delete.addActionListener(this);
		menu.menu_edit_selectall.addActionListener(this);
		menu.menu_edit_find.addActionListener(this);
		menu.menu_edit_findnext.addActionListener(this);
		menu.menu_edit_replace.addActionListener(this);
		menu.menu_edit_replaceall.addActionListener(this);
		menu.menu_edit_goto.addActionListener(this);

		// menu view
		menu.menu_view_foreground.addActionListener(this);
		menu.menu_view_background.addActionListener(this);
		menu.menu_view_statusbar.addActionListener(this);

		// menu font
		menu.menu_font_wordwrap.addActionListener(this);
		menu.menu_font_font.addActionListener(this);
		menu.menu_font_font_size_large.addActionListener(this);
		menu.menu_font_font_size_medium.addActionListener(this);
		menu.menu_font_font_size_small.addActionListener(this);

		// menu help
		menu.menu_help_topic.addActionListener(this);
		menu.menu_help_about.addActionListener(this);

	}

	public void exit(){
		System.exit(0);
	}

	public void actionPerformed(ActionEvent e){
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

	// menu file items
		if (e.getSource()==menu.menu_file_new){
			System.out.println(e.getSource());
		}
		
		else if (e.getSource()==menu.menu_file_open){}
		
		else if (e.getSource()==menu.menu_file_save){}
		
		else if (e.getSource()==menu.menu_file_saveas){}
		
		else if (e.getSource()==menu.menu_file_print){}
		
		else if (e.getSource()==menu.menu_file_exit){
			exit();
		}


		// menu edit
		else if (e.getSource()==menu.menu_edit_undo){
			manager.undo();
		}
		
		else if (e.getSource()==menu.menu_edit_redo){
			manager.redo();
		}
		
		else if (e.getSource()==menu.menu_edit_cut){
			obj.cut();
		}
		
		else if (e.getSource()==menu.menu_edit_copy){
			obj.copy();
		}
		
		else if (e.getSource()==menu.menu_edit_paste){
			obj.paste();
		}
		
		else if (e.getSource()==menu.menu_edit_delete){
			obj.setText("");

		}

		else if (e.getSource()==menu.menu_edit_selectall){
			obj.selectAll();
		}
		
		else if (e.getSource()==menu.menu_edit_find){}
		
		else if (e.getSource()==menu.menu_edit_findnext){}
		
		else if (e.getSource()==menu.menu_edit_replace){}
		
		else if (e.getSource()==menu.menu_edit_replaceall){}
		
		else if (e.getSource()==menu.menu_edit_goto){}

		// menu view		
		else if (e.getSource()==menu.menu_view_foreground){}
		
		else if (e.getSource()==menu.menu_view_background){}
		
		else if (e.getSource()==menu.menu_view_statusbar){}


		// menu font
		else if (e.getSource()==menu.menu_font_wordwrap){}
		else if (e.getSource()==menu.menu_font_font){}
		else if (e.getSource()==menu.menu_font_font_size_large){
			
			obj.setFont(new Font("",Font.BOLD,30));   
		}
		else if (e.getSource()==menu.menu_font_font_size_medium){
			obj.setFont(new Font("",Font.BOLD,20));
		}
		else if (e.getSource()==menu.menu_font_font_size_small){
			obj.setFont(new Font("",Font.BOLD,13));
		}

		// menu help
		else if (e.getSource()==menu.menu_help_topic){}
		else if (e.getSource()==menu.menu_help_about){}


	}
}



class setup{


	public static void main(String[] args){
		CombinedControls obj = new CombinedControls();
		System.out.println("SETUP");

	}

}
