package CodeRail;

import javax.swing.*;
import java.awt.event.*;

class AddMenuBar extends JMenuBar {
	// menu items
	private JMenu menu_file;
	private JMenu menu_edit;
	private JMenu menu_view;
	private JMenu menu_font;
	private JMenu menu_help;


	// menu file items
	public JMenuItem menu_file_new;
	public JMenuItem menu_file_open;
	public JMenuItem menu_file_save;
	public JMenuItem menu_file_saveas;
	public JMenuItem menu_file_print;
	public JMenuItem menu_file_exit;


	// menu edit
	public JMenuItem menu_edit_undo;
	public JMenuItem menu_edit_redo;
	public JMenuItem menu_edit_cut;
	public JMenuItem menu_edit_copy;
	public JMenuItem menu_edit_paste;
	public JMenuItem menu_edit_delete;
	public JMenuItem menu_edit_selectall;
	public JMenuItem menu_edit_find;
	public JMenuItem menu_edit_findnext;
	public JMenuItem menu_edit_replace;
	public JMenuItem menu_edit_replaceall;
	public JMenuItem menu_edit_goto;

	// menu view
	public JMenuItem menu_view_foreground;
	public JMenuItem menu_view_background;
	public JMenuItem menu_view_statusbar;

	// menu font
	public JMenuItem menu_font_wordwrap;
	public JMenuItem menu_font_font;

	// menu help
	public JMenuItem menu_help_topic;
	public JMenuItem menu_help_about;

	// Constructor
	AddMenuBar(){
		initUI();
	}

	// initialise method
	private void initUI(){

		menu_file = new JMenu("File");
		menu_edit = new JMenu("Edit");
		menu_view = new JMenu("Format");
		menu_font = new JMenu("View");
		menu_help = new JMenu("Help");


		// Menu Item Created
		menu_file_open 	= new JMenuItem("Open");
		menu_file_new 	= new JMenuItem("New");
		menu_file_save 	= new JMenuItem("Save");
		menu_file_saveas= new JMenuItem("Save As");
		menu_file_print = new JMenuItem("Print");
		menu_file_exit 	= new JMenuItem("Exit");
		

		// menu edit
		menu_edit_undo 		= new JMenuItem("Undo");
		menu_edit_redo 		= new JMenuItem("Redo");
		menu_edit_cut 		= new JMenuItem("Cut");
		menu_edit_copy 		= new JMenuItem("Copy");
	 	menu_edit_paste 	= new JMenuItem("Paste");
		menu_edit_delete 	= new JMenuItem("Delete");
		menu_edit_selectall = new JMenuItem("Select All");
		menu_edit_find 		= new JMenuItem("Find");
		menu_edit_findnext 	= new JMenuItem("Find Next");
		menu_edit_replace 	= new JMenuItem("Replace");
		menu_edit_replaceall= new JMenuItem("Replace All");
		menu_edit_goto 		= new JMenuItem("Goto");

		// menu view
	 	menu_view_foreground = new JMenuItem("Foreground");
	 	menu_view_background = new JMenuItem("Background");
	 	menu_view_statusbar  = new JMenuItem("StatusBar");

		// menu font
		menu_font_wordwrap  = new JMenuItem("Word wrap");
		menu_font_font 		= new JMenuItem("Font");

		// menu help
		menu_help_topic = new JMenuItem("Topic");
		menu_help_about = new JMenuItem("About");




		menu_file.add(menu_file_open );
		menu_file.add(menu_file_new);
		menu_file.add(menu_file_save);
		menu_file.add(menu_file_saveas);
		menu_file.add(menu_file_print);
		menu_file.add(menu_file_exit);
	

		// menu edit
		menu_edit.add(menu_edit_undo);
		menu_edit.add(menu_edit_redo);
		menu_edit.add(menu_edit_cut);
		menu_edit.add(menu_edit_copy);
	 	menu_edit.add(menu_edit_paste);
		menu_edit.add(menu_edit_delete);
		menu_edit.add(menu_edit_selectall);
		menu_edit.add(menu_edit_find);
		menu_edit.add(menu_edit_findnext);
		menu_edit.add(menu_edit_replace);
		menu_edit.add(menu_edit_replaceall);
		menu_edit.add(menu_edit_goto);

		// menu view
	 	menu_view.add(menu_view_foreground);
	 	menu_view.add(menu_view_background);
	 	menu_view.add(menu_view_statusbar);


		// menu font
		menu_font.add(menu_font_wordwrap);
		menu_font.add(menu_font_font);

		// menu help
		menu_help.add(menu_help_topic);
		menu_help.add(menu_help_about);




		// Add menu to bar
		add(menu_file);
		add(menu_edit);
		add(menu_view);
		add(menu_font);
		add(menu_help);
	}

	
}
