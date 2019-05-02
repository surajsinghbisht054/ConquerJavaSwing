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

//importing module
import javax.swing.*; 
import java.awt.event.*;  //used for event handling
import java.util.Random; //used to take random value
import java.awt.*;


public class NumberQuizGame extends JFrame implements ActionListener
{	
	/*global declaration of variable for this class*/
	JLabel game_name;                     	   //represent name of game
	JLabel user_guide_1,user_guide_2;    	   //represent instruction at the starting display
	JLabel copy_right;                     	   //represent copyright message on frame
	JLabel exit_message_1,exit_message_2;	   //represent message at the last display
	JButton start_button,exit_button;      	   //represent button on first and last display
	JLabel user_guide;          	           //represent instruction on second display
	JLabel score;							   //represent score Label
	JButton var_1,var_2,sign,equal,ques_mark;  //represent equation
	JButton op1,op2,op3,op4;  				   //represent options
 	int correct_op;							   //represent correct option
	int current_score=0;					   //represent current score

	

	NumberQuizGame()
	{

	}

	//this contructor will create the JFrame
	NumberQuizGame(String title)
	{
		super(title);   //setting title by calling JFrame class constructor
	}

	/*first user Interacting display or beginning of game*/
	public void setComponent()
	{
		
		/*setting text on components*/
		
		game_name=new JLabel("Number Game");
		game_name.setFont(new Font("CALIBARIAN", Font.BOLD, 30));
		game_name.setForeground(Color.red);

		user_guide_1=new JLabel("Get Ready To Jog your Brain. All the Best !!");
		user_guide_1.setForeground(Color.white);

		user_guide_2=new JLabel("Click The Start Button");
		user_guide_2.setForeground(Color.white);

		start_button=new JButton("START GAME");

		copy_right=new JLabel("© 2019 BLARE GROUP(www.blaregroup.com)");
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
		
		//event handling on start button this will call  actionperformed method of this class
		// which is override of method of ActionListener interface
		start_button.addActionListener(this);
	}

	/*this method is used to handle event after clicking Start button  and it is second user Interacting display*/
	public void actionPerformed(ActionEvent e)
	{	
		/*setting visibility of preloaded component false*/
		
		start_button.setVisible(false);
		user_guide_1.setVisible(false);
		user_guide_2.setVisible(false);

		
		/*setting new components*/
		user_guide=new JLabel("Choose the right answer");
		user_guide.setForeground(Color.white);

		score=new JLabel();
		score.setForeground(Color.red);

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
		repeat();         //funcition for setting value in buttons 
		condition_test(); //checking option entered by user correct or not
		
		
	}

	/*this method is used  for changing the value after correct answer or put the initial value  */
	public void repeat()
	{	
		current_score++; //increase the score after correct option

		//getting random value for var_1 and var_2 by calling method  
		int a=ran_number1();              
		int b=ran_number2();
		//converting a and b into string for displaying on frame
		String v1=new String(Integer.toString(a));
		String v2=new String(Integer.toString(b));

		String sign_1=new String(ran_sign());

		int c=calculation(a,b,sign_1);                //getting answer in int form 
		String ans=new String(Integer.toString(c));   //converting answer from int to string 

		/*this is used for creating other option that to be put on op button */
		String  op_val1=new String(Integer.toString(c+10));
		String  op_val2=new String(Integer.toString(c-10));
		String  op_val3=new String(Integer.toString(c*2));

		correct_op=option();    //getting the postion of op button in which correct option is displayed
		
		//putting values in op button 
		switch(correct_op)
		{
			case 1:op1.setText(ans);op2.setText(op_val1);op3.setText(op_val3);op4.setText(op_val2);break;
			case 2:op2.setText(ans);op1.setText(op_val2);op3.setText(op_val3);op4.setText(op_val1);break;
			case 3:op3.setText(ans);op2.setText(op_val1);op1.setText(op_val3);op4.setText(op_val2);break;
			case 4:op4.setText(ans);op2.setText(op_val1);op3.setText(op_val3);op1.setText(op_val2);
		}

		//putting score 
		score.setText("Score = "+Integer.toString(current_score-1));
		var_1.setText(v1);     //putting value in var_1
		var_2.setText(v2);	   //putting value in var_2	
		sign.setText(sign_1);  //putting value in sign button
	}

	/*this method is used to set the random value in var_1 button*/
	public int ran_number1()
	{
		Random rand=new Random();
		int i=rand.nextInt(50);
		return(i);
	}

	/*this method is used to set the random value in var_2 button*/
	public int  ran_number2()
	{
		Random rand=new Random();
		int j=rand.nextInt(50);
		return(j);
	}

	/*this method is used to set the value random sign in sign button*/
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


	/*
		this method is used to calculate the answer of equation
		it take value of var_1,var_2,sign in a,b,c variable respectivily
		and return the answer
	*/
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

	
	//	this method will return the option which contain the correct option	
	public int option()
	{
		Random rand=new Random();
		int n=rand.nextInt(4);
		
		if(n==0){n=1;}
		return(n);

	}

	//this method is used to handle the user response on clicking the option
	//it will check clicked option is correct or not and perform acction accordingly
	public void condition_test()
	{		
		JFrame f1=new JFrame("Number Game"); //for dialog box 
			
		//option 1 button handling
			
		op1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				if(correct_op==1){ repeat(); }
				else
			    {			
					int a=JOptionPane.showConfirmDialog(f1,"Game Over \n Your Score = "+(current_score-1)+"\n Do you want to play again");
					if(a==JOptionPane.YES_OPTION){restart();setComponent();}
					else { close();}
				}
			}
			
		});

		//option 2 button handling
		op2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(correct_op==2){repeat();}
				else 
				{
					int a=JOptionPane.showConfirmDialog(f1,"Game Over \n Your Score = "+(current_score-1)+"\n Do you want to play again");
					if(a==JOptionPane.YES_OPTION){restart();setComponent();}
					else { close();}
				}
			}
				
		});

		//option 3 button handling
		op3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
		
				if(correct_op==3){repeat();}
				else
				{
					int a=JOptionPane.showConfirmDialog(f1,"Game Over \n Your Score = "+(current_score-1)+"\n Do you want to play again");
					if(a==JOptionPane.YES_OPTION){restart();setComponent();}
					else { close();}
				}
			}
				
		});

		//option 4 button handling
		op4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
		
				if(correct_op==4){repeat();}
				else 
				{
					int a=JOptionPane.showConfirmDialog(f1,"Game Over \n Your Score = "+(current_score-1)+"\n Do you want to play again");
					if(a==JOptionPane.YES_OPTION){restart();setComponent();}
					else { close();}
				}
			}
				
		});
	}

	//  this function is used to restart the game by making the component invisible
	//       so that new components can be loaded on frame
	public void restart()
	{	
		current_score=0;                  //setting value of score to 0
		
		//setting visibility of all components to false for restart from beginning
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
		user_guide_1.setVisible(false);		 	
		user_guide_2.setVisible(false);
		start_button.setVisible(false);

	}

	/*this function is used to create third display means exit application display*/
	public void close()
	{
		restart();      //here this method is used to make the all component invisible
		
		//Creating exit window display

		exit_message_1=new JLabel("Thanks for Playing.");
		exit_message_1.setForeground(Color.white);
		
		exit_message_2=new JLabel("Come back again We love you !!");
		exit_message_2.setForeground(Color.white);

		exit_button=new JButton("EXIT");
		
		exit_message_1.setBounds(177,120,200,20);
		exit_message_2.setBounds(137,150,250,20);
		exit_button.setBounds(170,200,150,50);
		
		add(exit_message_1);
		add(exit_message_2);
		add(exit_button);
		
		exit_message_1.setVisible(true);
		exit_message_2.setVisible(true);
		exit_button.setVisible(true);
		
		//adding action on exit button
		exit_button.addActionListener(new ActionListener(){
				
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
				
		});

	}
	

	public static void main(String args[])
	{
	
		NumberQuizGame f=new NumberQuizGame("Number Game");      //creating object and call the parameterized constructor
		
		f.setSize(500,400);                     //set size of JFrame
		f.setVisible(true);                     //setting Visibility of Frame
		f.setComponent();                       //setting components of first display

		f.getContentPane().setBackground(Color.black);	  //color the Background for JFrame		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allowing to close the application by click close button
		
		/*used for setting the position of JFrame on screen*/
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); 
		final int WIDTH = screenSize.width;     //getting user screen width
		final int HEIGHT = screenSize.height;   //getting user screen height
		f.setLocationRelativeTo(null);          //settng default location to null
		f.setLocation(WIDTH/4,HEIGHT/4);        //setting Frame on middle of screen
 
	}
}