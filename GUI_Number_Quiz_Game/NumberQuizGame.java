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
	
	About:
		In this game you have to solve a Mathematic equation and choose the correct answer from the given option 
		if you give the correct answer then in time then your score will increase by 1
		and you will get another equation to solve.
		when you give the wrong answer the game is over
		

*/

//importing module
import javax.swing.*; 
import java.awt.event.*;     //used for event handling
import java.util.Random;     //used to take random value
import java.awt.*;
import javax.swing.Timer;	 //used for timer or hold the program
 

public class NumberQuizGame extends JFrame
{	
	/*global declaration of variable for this class*/
	Timer countdown,hold_program;			   //used to set the countdown and hold the program
	JLabel user_guide_1,user_guide_2;    	   //represent instruction at the starting display
	JLabel copy_right;                     	   //represent copyright message on frame
	JLabel exit_message_1,exit_message_2;	   //represent message at the last display
	JButton start_button,exit_button;      	   //represent button on first and last display
	JLabel user_guide;          	           //represent instruction on second display
	JLabel timer_text,timer_value;			   //represent the timer on screen
	JLabel score;							   //represent score Label
	JButton var_1,var_2,sign,equal,ques_mark;  //represent equation
	JButton op1,op2,op3,op4;  				   //represent options
 	int correct_op;							   //represent correct option
	int current_score=0;					   //represent current score
	JLabel frame_background;				   //represent the Frame Background
	

	
	//this contructor will create the JFrame
	NumberQuizGame(String title)
	{
		super(title);   //setting title by calling JFrame class constructor

		//Setting Background Image
		ImageIcon img=new ImageIcon("Background_img.jpg"); 		 //Locating Image 
		frame_background=new JLabel(img);
		frame_background.setBounds(0,0,500,470);	 //setting background image size
		add(frame_background);
		setLayout(null);
		frame_background.setLayout(null);
	}

	/*first user Interacting display or beginning of game*/
	public void first_display()
	{
		
		/*setting text on components*/
		
		user_guide_1=new JLabel("Get Ready To Jog your Brain. All the Best !!");
		user_guide_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		user_guide_1.setForeground(Color.white);

		user_guide_2=new JLabel("Click The Play Button");
		user_guide_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		user_guide_2.setForeground(Color.white);

		start_button=new JButton("PLAY");
		start_button.setBackground(new Color(102,0,10));
		start_button.setForeground(Color.white);
		start_button.setFont(new Font("algerian",Font.BOLD,30));
		start_button.setBorder(BorderFactory.createBevelBorder(0));
		 

		copy_right=new JLabel("© 2019 BLARE GROUP(www.blaregroup.com)");
		copy_right.setForeground(Color.white);
		copy_right.setFont(new Font("algerian",Font.ITALIC,10));
		
		setLayout(null); //setting layout to null so that we give our own layout

	
		/*Setting position of components*/
		user_guide_1.setBounds(75,145,400,25);
		user_guide_2.setBounds(132,175,360,25);
		start_button.setBounds(147,265,200,50);
		copy_right.setBounds(135,410,300,20);

	
		/*adding components to frame*/
		frame_background.add(start_button);
		frame_background.add(user_guide_1);
		frame_background.add(user_guide_2);
		frame_background.add(copy_right);
		
		//event handling on start button this will call  actionperformed method of second_display class
		start_button.addActionListener(new second_display());
		
		//Adding hover effect on start button
		start_button.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        start_button.setBackground(new Color(17,97,0));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        start_button.setBackground(new Color(102,0,10));
		    }
		});

	}

	/*this class is used to handle event after clicking Start button  and it will create second user Interacting display*/
	private class second_display implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{	
			/*setting visibility of preloaded component false*/
			
			start_button.setVisible(false);
			user_guide_1.setVisible(false);
			user_guide_2.setVisible(false);

			
			/*setting new components*/
			user_guide=new JLabel("Choose the right answer");
			user_guide.setFont(new Font("algerian",Font.BOLD,20));
			user_guide.setForeground(Color.white);

			timer_text=new JLabel("Time Left");
			timer_text.setForeground(Color.white);
			timer_text.setFont(new Font("algerian",Font.BOLD,20));

			timer_value=new JLabel();
			timer_value.setForeground(Color.red);
			timer_value.setFont(new Font("algerian",Font.BOLD,25));

			score=new JLabel();
			score.setFont(new Font("algerian",Font.BOLD,20));
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
			var_1.setBounds(110,135,60,50);
			sign.setBounds(165,135,60,50);
			var_2.setBounds(220,135,60,50);
			equal.setBounds(275,135,60,50);
			ques_mark.setBounds(330,135,60,50);
			user_guide.setBounds(115,205,300,20);
			op1.setBounds(112,245,68,50);
			op2.setBounds(181,245,68,50);
			op3.setBounds(249,245,68,50);
			op4.setBounds(317,245,68,50);
			timer_text.setBounds(195,303,200,30);
			timer_value.setBounds(230,337,100,30);
			score.setBounds(192,380,150,20);

		
			/*Adding component*/
			frame_background.add(user_guide);
			frame_background.add(var_1);
			frame_background.add(var_2);
			frame_background.add(sign);
			frame_background.add(ques_mark);
			frame_background.add(equal);
			frame_background.add(op1);
			frame_background.add(op2);
			frame_background.add(op3);
			frame_background.add(op4);
			frame_background.add(timer_text);
			frame_background.add(timer_value);
			frame_background.add(score);
			
			set_value();         //funcition for setting value in buttons 
			
			/*Event handling when user click on any of the option button*/
			op1.addActionListener(new option_clickhandle(1));
			op2.addActionListener(new option_clickhandle(2));
			op3.addActionListener(new option_clickhandle(3));
			op4.addActionListener(new option_clickhandle(4));
						

			/*	mouse over effect on options	*/	

			op1.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			        op1.setBackground(Color.pink);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			        op1.setBackground(Color.white);
			    }
			});
			op2.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			        op2.setBackground(Color.pink);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			        op2.setBackground(Color.white);
			    }
			});
			op3.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			        op3.setBackground(Color.pink);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			        op3.setBackground(Color.white);
			    }
			});
			op4.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			        op4.setBackground(Color.pink);
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			        op4.setBackground(Color.white);
			    }
			});

			
		}
	}

	/*this method is used  for changing the value after correct answer or put the initial value  */
	public void set_value()
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

		/*this is used for creating other option value  that to be put on op button */
		String  op_val1=new String(Integer.toString(c+10));
		String  op_val2=new String(Integer.toString(c-10));
		String  op_val3=new String(Integer.toString(c+2));

		correct_op=option();    //getting the postion of op button in which correct option is displayed
		
		//putting values in op button 
		switch(correct_op)
		{
			case 1:op1.setText(ans);op2.setText(op_val1);op3.setText(op_val3);op4.setText(op_val2);break;
			case 2:op2.setText(ans);op1.setText(op_val2);op3.setText(op_val3);op4.setText(op_val1);break;
			case 3:op3.setText(ans);op2.setText(op_val1);op1.setText(op_val3);op4.setText(op_val2);break;
			case 4:op4.setText(ans);op2.setText(op_val1);op3.setText(op_val3);op1.setText(op_val2);
		}

		score.setText("Score = "+Integer.toString(current_score-1)); //Display  score 
		
		//creating timer
		countdown=new Timer(1000,new ActionListener()
			{	int st=6;  //timer start no.
				public void actionPerformed(ActionEvent e)
				{
					st--;
					if(st>=0){timer_value.setText(Integer.toString(st));}
					else
					{	countdown.stop();
						int a=JOptionPane.showConfirmDialog(null,"Time Over \n Your Score = "+(current_score-1)+"\n Do you want to play again");
						if(a==JOptionPane.YES_OPTION){restart();first_display();}
						else { exit_display();}
					}
				}
			});

		countdown.start(); 		   //starting countdown
		var_1.setText(v1);     	   //putting value in var_1
		var_2.setText(v2);	       //putting value in var_2	
		sign.setText(sign_1);  	   //putting value in sign button

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

	
	//	this method will return the option which contain the correct option	randomly
	public int option()
	{
		Random rand=new Random();
		int n=rand.nextInt(4);
		
		if(n==0){n=1;}
		return(n);

	}

	/*this class is used to handle the user response on clicking the option button
	   it will check clicked option is correct or not and perform action accordingly*/
	private class option_clickhandle implements ActionListener
	{	
		int op_number;  //represent option number of user choice

		//this constructor will put the value in op_choice variable of class
		option_clickhandle(int op_number)
		{
			this.op_number=op_number;
		}

		public void actionPerformed(ActionEvent e)
			{	
				countdown.stop(); //stoping timer
				switch(correct_op)
				 		{
				 			case 1:op1.setBackground(Color.green);op1.setForeground(Color.white);break;
				 			case 2:op2.setBackground(Color.green);op2.setForeground(Color.white);break;
				 			case 3:op3.setBackground(Color.green);op3.setForeground(Color.white);break;
				 			case 4:op4.setBackground(Color.green);op4.setForeground(Color.white);break;
				 		}

				if(correct_op==op_number){
					
					
				 	hold_program=new Timer(1200,new ActionListener()
							{	
								public void actionPerformed(ActionEvent e)
								{
									op1.setBackground(Color.white);op1.setForeground(Color.black);
									op2.setBackground(Color.white);op2.setForeground(Color.black);
									op3.setBackground(Color.white);op3.setForeground(Color.black);
									op4.setBackground(Color.white);op4.setForeground(Color.black);
									set_value();			
									hold_program.stop();								
								}
							});
				 	hold_program.start();	

				  }
				else
			    {			
			    	switch(op_number)
				 		{
				 			case 1:op1.setBackground(Color.red);op1.setForeground(Color.white);break;
				 			case 2:op2.setBackground(Color.red);op2.setForeground(Color.white);break;
				 			case 3:op3.setBackground(Color.red);op3.setForeground(Color.white);break;
				 			case 4:op4.setBackground(Color.red);op4.setForeground(Color.white);break;
				 		}

					int a=JOptionPane.showConfirmDialog(null,"Game Over \n Your Score = "+(current_score-1)+"\n Do you want to play again");
					if(a==JOptionPane.YES_OPTION){restart();first_display();}
					else { exit_display();}
				}
			}


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
		timer_value.setVisible(false);
		timer_text.setVisible(false);
		

	}

	/*this function is used to create third display means exit application display*/
	public void exit_display()
	{
		restart();      //here this method is used to make the all component invisible
		
		//Creating exit window display

		exit_message_1=new JLabel("Thanks for Playing.");
		exit_message_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		exit_message_1.setForeground(Color.white);
		
		exit_message_2=new JLabel("Come back again We love you !!");
		exit_message_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		exit_message_2.setForeground(Color.white);

		exit_button=new JButton("QUIT");
		exit_button.setBackground(new Color(102,0,10));
		exit_button.setFont(new Font("Times new Roman",Font.BOLD,25));
		exit_button.setForeground(Color.white);
		
		exit_message_1.setBounds(147,160,300,25);
		exit_message_2.setBounds(80,190,400,25);
		exit_button.setBounds(170,270,150,50);
		exit_button.setBorder(BorderFactory.createBevelBorder(0));
		
		frame_background.add(exit_message_1);
		frame_background.add(exit_message_2);
		frame_background.add(exit_button);
		
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

		//Adding hover effect on exit button
		exit_button.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        exit_button.setBackground(new Color(17,97,0));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        exit_button.setBackground(new Color(102,0,10));
		    }
		});

	}
	

	public static void main(String args[])
	{
	
		NumberQuizGame f=new NumberQuizGame("Number Game");      //creating object and call the parameterized constructor
		
		f.setSize(500,470);                     //set size of JFrame
		f.setVisible(true);                     //setting Visibility of Frame
		f.first_display();                       //creating first display or start of game

		

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