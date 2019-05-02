/*
    Author :    

            Suraj Singh Bisht
            surajsinghbisht054@gmail.com
            www.bitforestinfo.com
            www.blaregroup.com

    =============================================
                Snake Game
    =============================================

    Instruction.

        Supported KEYS:

                [ UP Arrow]
                     W
    [ LEFT Arrow ] A + D [ RIGHT Arrow ]
                     S
                [ Down Arrow ]


        ESC, Q = QUIT
    
    Snake Don't Have To Touch Border.

*/

// importing modules
import java.awt.event.*;    // Events
import javax.swing.*;       // Swing    
import java.awt.Graphics;   // Graphic Object
import java.awt.BasicStroke;    
import java.awt.Graphics2D;
import java.lang.Thread;    // Sleep
import java.util.Random;    // Random
import java.awt.Font;       // Font Family
import java.awt.Color;      // Color


class Board extends JPanel{
    private int width;          // Board Width
    private int height;         // Board height
    private int xPoints[];      // Snake X Points
    private int yPoints[];      // Snake Y Points
    private int snakelen = 3;   // Snake Body Length
    private int direction = 4;  // Direction of Move, 4, 6, 8, 2
    private int i=0;            // Iteration variable   
    private int xNP;            // New X Point
    private int yNP;            // New Y Point
    private int xOP;            // Old X Point
    private int yOP;            // Old Y Point
    private int lunchX;         // Lunch X Point
    private int lunchY;         // Lunch Y Point
    private int lunchavailable; // Lunch Availability
    private Random ran = new Random();
    private int Score;          // Game Score
    public int GameOver;        // Game Over
    public int keystroke = 6;   // User Key Press


    Board(int w, int h){

        // Widget Configuration
        width = w;
        height = h;
        xPoints = new int[w];
        yPoints = new int[w];


        // Snake Starting Point
        xPoints[0] = 200;
        yPoints[0] = 200;
        xPoints[1] = 201;
        yPoints[1] = 200;
        xPoints[2] = 202;
        yPoints[2] = 200;
        xPoints[3] = 203;
        yPoints[3] = 200;



        // Canvas Configuration
        setFocusable(true);
        setVisible(true);
        setSize(width, height);
    }

    // draw lunch if required
    void drawlunch(Graphics2D g){

        // Random Lunch Coordinates
        if(lunchavailable==0){
            lunchX = ran.nextInt(width-100)+20;
            lunchY = ran.nextInt(height-100)+20;
            Score+=1;
            lunchavailable = 1;
        }

        if (lunchavailable==1) {    
            g.drawString("@", lunchX+1, lunchY+1);
        }

        // Check Collision
        if ( 
            (lunchX-8) < xPoints[1] &&
            (lunchX+8) > xPoints[1] &&
            (lunchY-8) < yPoints[1] &&
            (lunchY+8) > yPoints[1] &&
            lunchavailable == 1
            ){

            lunchavailable = 0;
        }

        // Check Border Touch
        if (
            width < xPoints[1] ||
            0 > xPoints[1] ||
            height < yPoints[1] ||
            0 > yPoints[1]
            ){
            GameOver = 1;

        }

    }

    // move snake coordinate array
    void movesnake(int x, int y){
        xNP = xPoints[snakelen]+x;
        yNP = yPoints[snakelen]+y;

        for (i=snakelen;i>-1;i--) {
            xOP = xPoints[i];
            yOP = yPoints[i];
            xPoints[i] = xNP;
            yPoints[i] = yNP;
            xNP = xOP;
            yNP = yOP;
        }
    }

    // Display Game Over Message
    void GameOverDisplay(Graphics2D g){
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 28);
        g.setColor(Color.blue);
        g.setFont(small);
        g.drawString(msg,width/2, height/3 );

    }

    // Draw Snake Over Canvas
    void drawsnake(Graphics2D g){
        g.setStroke(new BasicStroke(10f));
        g.drawPolyline(xPoints, yPoints, snakelen);
    }

    // Overrided Paint Component Method
    public void paintComponent(Graphics g){

        // KeyStroke Conditions
        if (keystroke==6 && direction != 4) {
            direction=6;
        }
        else if (keystroke==4 && direction != 6) {
            direction=4;
        }
        else if (keystroke==8 && direction != 2) {
            
            direction=8;
        }
        else if (keystroke==2 && direction != 8) {
            direction=2;
        }

        if (direction==2 && GameOver==0) {
            movesnake(0, 1);
        }
        else if (direction==8 && GameOver==0) {
            movesnake(0, -1);
        }
        else if (direction==4 && GameOver==0) {
            movesnake(1, 0);
        }
        else if (direction==6 && GameOver==0) {
            movesnake(-1, 0);   
        }
        // Procede Further 
        update(g);
    }

    // update frame
    public void update(Graphics g){
        // Erase Everything
        g.clearRect(0,0,width, height);

        // Type Casting To Graphic2D
        Graphics2D g2D = (Graphics2D) g;
        // Draw Snake
        drawsnake(g2D);
        // Draw Score
        g.drawString(Integer.toString(Score), width-50, height-50);
        // Draw Lunch
        drawlunch(g2D);
        // Check Game Status
        if (GameOver==1) {
            GameOverDisplay(g2D);
            
        }
    }
}


class SnakeGame extends JFrame implements KeyListener{

    /*
        ================================
                Configuration 
        ================================
    */
    private final int width = 800;  // Board Width
    private final int height =500; // Board Height
    private int keystroke = 0;
    private int DELAY = 5;
    Board ground;

    // Constructor
    SnakeGame(){
    
        // Initialise Board
        ground = new Board(width, height);
        
        // Widget Configuration
        setFocusable(true);
        setVisible(true);
        add(ground);
        addKeyListener(this);
        setResizable(false);
        setSize(width, height);


        while (true) {
            //Timer timer = new Timer(140);
            //timer.start();
            try{Thread.sleep(DELAY);}catch(Exception e){};
            ground.repaint();
            //System.out.println("");
        }
    } 

    public void keyReleased(KeyEvent event){
        ground.keystroke = 0;
    }
    public void keyTyped(KeyEvent event){
    }
    
    // Capture Key Press
    public void keyPressed(KeyEvent event){
        int id = event.getKeyCode();
        
    /*
    Keyboard Mapping
    UP      38, 87
    Down    40, 83
    Left    39, 68
    Right   37, 65
    QUIT    27, 81


    */
        // Quit
        if (id==27 || id==81) {
            System.exit(0);
        }
        
        // Turn Left
        if (id==39 || id==68) {
            ground.keystroke = 4;
            ground.repaint();   
        }
        
        // Turn Right
        if (id==37 || id==65 ) {
            ground.keystroke = 6;
            ground.repaint();
        }

        // Turn Down    
        if (id==40 || id==83) {
            ground.keystroke = 2;
            ground.repaint();
        }

        // Turn Up
        if (id ==38 || id==87) {
            ground.keystroke = 8;
            ground.repaint();
        }
    }


    // main function 
    public static void main(String[] args) {
        SnakeGame root = new SnakeGame();
    }
}
