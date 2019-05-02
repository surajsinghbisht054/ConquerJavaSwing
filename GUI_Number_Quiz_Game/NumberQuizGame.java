/*
    Author :    

            Himanshu Sharma
            himanshusharma2972@gmail.com
            www.blaregroup.com
	*********************************************
                   Number Quiz Game
    *********************************************

    Instruction.
		Main Class name is NumberQuizGame
		which is used to run the program after compiling


*/


import javax.swing.*;
import java.awt.event.*;  //used for event handling
import java.util.Random; //used to take random value
import java.awt.*;

public class NumberQuizGame extends JFrame implements ActionListener
{	/*global declaration of variable for this class*/
	JLabel game_name,user_guide_1,user_guide_2,copy_right;
	JLabel exit_message_1,exit_message_2;
	JButton start_button,exit_button;
	JLabel user_guide;
	JLabel score;
	JButton var_1,var_2,sign,equal,ques_mark;
	JButton op1,op2,op3,op4;
	int correct_op;
	int current_score=0;

	NumberQuizGame()
	{

	}
	NumberQuizGame(String title)
	{
		super(title);
	}

	/*for restart the game*/
	public void restart()
	{	current_score=0;
		var_1.setVisible(false);
		var_2.setVisible(false);
		user_guide.setVisible(false);
		sign.setVisible(false);
		equal.setVisible(false);
		ques_mark.setVisible(false);
		op1.setVisible(false);
		op2.setVisible(false);
		op3.setVisible(false);
		op4.setVisible(false);
		score.setVisible(false);
	}

	/*for closing the game */
	public void close()
	{
		restart();
		user_guide_1.setVisible(false);
		user_guide_2.setVisible(false);
		
		start_button.setVisible(false);
		exit_button=new JButton("EXIT");
		exit_message_1=new JLabel("Thanks for Playing.");
		exit_message_2=new JLabel("Come back again We love you !!");
		exit_message_1.setBounds(177,120,200,20);
		exit_message_2.setBounds(137,150,250,20);
		exit_button.setBounds(170,200,150,50);
		add(exit_message_1);
		add(exit_message_2);
		add(exit_button);
		exit_message_1.setVisible(true);
		exit_message_2.setVisible(true);
		exit_button.setVisible(true);
		exit_message_1.setForeground(Color.white);
		exit_message_2.setForeground(Color.white);
		exit_button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);
			}
				
		});

	}
	/*first user Interting display*/
	public void setComponent()
	{
		

		/*setting text on components*/
		
		game_name=new JLabel("Number Game");
		user_guide_1=new JLabel("Get Ready To Jog your Brain. All the Best !!");
		user_guide_2=new JLabel("Click The Start Button");
		start_button=new JButton("START GAME");
		copy_right=new JLabel("© 2019 BLARE GROUP(www.blaregroup.com)");
		game_name.setFont(new Font("CALIBARIAN", Font.BOLD, 30));
		game_name.setForeground(Color.red);
		user_guide_1.setForeground(Color.white);
		user_guide_2.setForeground(Color.white);
		copy_right.setForeground(Color.white);
		copy_right.setFont(new Font("algerian",Font.ITALIC,10));
		
		setLayout(null); //setting layout to null so that we give our own layout

		/*Setting position of components*/
		game_name.setBounds(130,30,300,30); 
		user_guide_1.setBounds(100,100,350,20);
		user_guide_2.setBounds(170,130,300,20);
		start_button.setBounds(120,210,250,50);
		copy_right.setBounds(130,340,300,20);
		/*adding components to frame*/
		add(game_name);	
		add(start_button);
		add(user_guide_1);
		add(user_guide_2);
		add(copy_right);
		/*event handling on start button this will actionperformed method of this class which is override of ActionListener interface*/
		start_button.addActionListener(this);
	
	}
	/*this method is used to test the condition */
	public void condition_test()
	{		/*option 1 button*/
			JFrame f1=new JFrame("Number Game");
			op1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					if(correct_op==1)
					{	
						
						 repeat();

					}
					else {	
						
								int a=JOptionPane.showConfirmDialog(f1,"Game Over \n Your Score = "+(current_score-1)+"\n Do you want to play again");
								if(a==JOptionPane.YES_OPTION){restart();setComponent();}
								else { close();}
						 }
			}
				
		});
			/*option 2 button*/
		op2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
		
					if(correct_op==2){repeat();}
						else {
		
									int a=JOptionPane.showConfirmDialog(f1,"Game Over \n Your Score = "+(current_score-1)+"\n Do you want to play again");
									if(a==JOptionPane.YES_OPTION){restart();setComponent();}
									else { close();}
							 }
			}
				
		});
			/*option 3 button*/
		op3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
		
					if(correct_op==3){repeat();}
						else {
		
									int a=JOptionPane.showConfirmDialog(f1,"Game Over \n Your Score = "+(current_score-1)+"\n Do you want to play again");
									if(a==JOptionPane.YES_OPTION){restart();setComponent();}
									else { close();}
							 }
			}
				
		});
			/*option 4 button*/
		op4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
		
					if(correct_op==4){repeat();}
						else {
		
									int a=JOptionPane.showConfirmDialog(f1,"Game Over \n Your Score = "+(current_score-1)+"\n Do you want to play again");
									if(a==JOptionPane.YES_OPTION){restart();setComponent();}
									else { close();}
							 }
			}
				
		});
	}
	/*this method is used to set the value in var_1 button*/
	public int ran_number1()
	{
		Random rand=new Random();
		int i=rand.nextInt(50);
		return(i);
	}
	/*this method is used to set the value in var_2 button*/
	public int  ran_number2()
	{
		Random rand=new Random();
		int j=rand.nextInt(50);
		return(j);
	}
	/*this method is used to set the value in sign button*/
	public String ran_sign()
	{
		Random rand=new Random();
		int k=rand.nextInt(3);

		switch(k)
		{
			case 0: return("+");
			case 1: return("-");
			case 2: return("*");
			case 4: return("/");
			default: return("+");
		}
	}
	/*this method is used to calculate the answer of euqation*/
	public int calculation(int a,int b,String s)
	{	
		char sym=s.charAt(0);
		int ans=0;
		
		if(sym=='+'){ans=a+b;}
		if(sym=='-'){ans=a-b;}
		if(sym=='*'){ans=a*b;}
		if(sym=='/'){ans=a/b;}
		return(ans);
	}
	/*this method is used to set correct option in op button randomly*/
	public int option(int ans)
	{
		Random rand=new Random();
		int n=rand.nextInt(4);
		
		if(n==0){n=1;}
		return(n);

	}
	/*this method is used to for changing the value after correct answer */
	public void repeat()
	{	
		current_score++;
		int a=ran_number1();
		int b=ran_number2();
		String v1=new String(Integer.toString(a));
		String v2=new String(Integer.toString(b));
		String sign_1=new String(ran_sign());
		int c=calculation(a,b,sign_1);
		String ans=new String(Integer.toString(c));
		String  op_val1=new String(Integer.toString(c+10));
		String  op_val2=new String(Integer.toString(c-10));
		String  op_val3=new String(Integer.toString(c*2));
		correct_op=option(c);
		
		switch(correct_op)
		{
			case 1:op1.setText(ans);op2.setText(op_val1);op3.setText(op_val3);op4.setText(op_val2);break;
			case 2:op2.setText(ans);op1.setText(op_val2);op3.setText(op_val3);op4.setText(op_val1);break;
			case 3:op3.setText(ans);op2.setText(op_val1);op1.setText(op_val3);op4.setText(op_val2);break;
			case 4:op4.setText(ans);op2.setText(op_val1);op3.setText(op_val3);op1.setText(op_val2);
		}
		score.setText("Score = "+Integer.toString(current_score-1));
		var_1.setText(v1);
		var_2.setText(v2);
		sign.setText(sign_1);
	}

	/*this method is used to handle event after Start button  and 2nd user Interacting display*/
	public void actionPerformed(ActionEvent e)
	{	
		/*setting visibility of preloaded component false*/
		
		start_button.setVisible(false);
		user_guide_1.setVisible(false);
		user_guide_2.setVisible(false);

		
		/*setting new components*/
		user_guide=new JLabel("Choose the right answer");
		score=new JLabel();
		var_1=new JButton();
		var_2=new JButton();
		sign=new JButton();
		equal=new JButton("=");
		ques_mark=new JButton("?");
		op1=new JButton();
		op2=new JButton();
		op3=new JButton();
		op4=new JButton();
		
		setLayout(null);
			user_guide.setForeground(Color.white);
			score.setForeground(Color.red);

		
		/*setting position*/
		var_1.setBounds(110,90,50,50);
		sign.setBounds(165,90,50,50);
		var_2.setBounds(220,90,50,50);
		equal.setBounds(275,90,50,50);
		ques_mark.setBounds(330,90,50,50);
		user_guide.setBounds(160,160,200,20);
		op1.setBounds(122,190,68,50);
		op2.setBounds(182,190,68,50);
		op3.setBounds(242,190,68,50);
		op4.setBounds(302,190,68,50);
		score.setBounds(195,270,150,20);
		/*Adding component*/
		add(user_guide);
		add(var_1);
		add(var_2);
		add(sign);
		add(ques_mark);
		add(equal);
		add(op1);
		add(op2);
		add(op3);
		add(op4);
		add(score);
		repeat();//funcition for setting value in buttons
		condition_test();
		
		
	}
	

	public static void main(String args[])
	{
	
		NumberQuizGame f=new NumberQuizGame("Number Game");
		
		/*used for setting the position of JFrame on screen*/
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		final int WIDTH = screenSize.width;
		final int HEIGHT = screenSize.height;
		f.setLocationRelativeTo(null);
		f.setLocation(WIDTH/4,HEIGHT/4);

		f.setSize(500,400); //set size of JFrame
		f.setVisible(true); //setting Visibility
		f.setResizable(false); //used for avoid resizing
		f.getContentPane().setBackground(Color.black);	//color the Background for JFrame	

		f.setComponent(); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
}
