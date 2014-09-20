package jmgames;

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class Conquest_Applet extends Applet implements Runnable, KeyListener, MouseListener
{
    private boolean gameOver = true;
    private int dx,dy;
    private int mouseX, mouseY;
    private final int boardSize = 5;
    private final String[][] boardArray = new String[boardSize][boardSize];
    private final Random rnd = new Random();
    Image arrowUp, arrowDown, arrowLeft, arrowRight;
    Image arrowUpPlayer, arrowDownPlayer, arrowLeftPlayer, arrowRightPlayer;
    Image arrowUpComputer, arrowDownComputer, arrowLeftComputer,
            arrowRightComputer;
    MediaTracker tr;
    
    
//******************************************************************************
    @Override
    public void init()
    {        
        setSize(boardArray.length * 40, boardArray.length * 40);
        setBackground(Color.GRAY);
        setFocusable(true);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("Conquest Game");
        frame.setMenuBar(null);

        addMouseListener(this);
    }
//******************************************************************************    
    @Override
    public void start()
    {
        Thread thread = new Thread();
        thread.start();
        buildBoard();
    }
//******************************************************************************    
    @Override
    public void stop()
    {
        
    }
//****************************************************************************** 
    @Override
    public void run()
    {
        while(!gameOver)
        {     
            repaint();
            game();
            try
            {
                Thread.sleep(17);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
//******************************************************************************   
    @Override
    public void destroy()
    {

    }
//******************************************************************************  
    @Override
    public void paint(Graphics g) 
    {
        dx = 0;
        dy = 0;
        tr = new MediaTracker(this);
        arrowUp = getImage(getCodeBase(), "images/arrowUp.png");
        arrowDown = getImage(getCodeBase(), "images/arrowDown.png");
        arrowLeft = getImage(getCodeBase(), "images/arrowleft.png");
        arrowRight = getImage(getCodeBase(), "images/arrowRight.png");
        
        arrowUpPlayer = getImage(getCodeBase(), "images/arrowUpPlayer.png");
        arrowDownPlayer = getImage(getCodeBase(), "images/arrowDownPlayer.png");
        arrowLeftPlayer = getImage(getCodeBase(), "images/arrowleftPlayer.png");
        arrowRightPlayer = getImage(getCodeBase(), "images/arrowRightPlayer.png");

        arrowUpComputer = getImage(getCodeBase(), "images/arrowUpComputer.png");
        arrowLeftComputer = getImage(getCodeBase(), "images/arrowleftComputer.png");
        arrowDownComputer = getImage(getCodeBase(), "images/arrowDownComputer.png");
        arrowRightComputer = getImage(getCodeBase(), "images/arrowRightComputer.png");
        
        
        
        
        for (int i = 0; i < boardArray.length; i++) 
        {

            for (int j = 0; j < boardArray[i].length; j++) 
            {
                switch(boardArray[i][j]){
                    case "CU":
                        tr.addImage(arrowUpComputer,0);
                        g.drawImage(arrowUpComputer, dx, dy, this);
                        break;
                    case "CD":
                        tr.addImage(arrowDownComputer,0);
                        g.drawImage(arrowDownComputer, dx, dy, this);
                        break;
                    case "CR":
                        tr.addImage(arrowRightComputer,0);
                        g.drawImage(arrowRightComputer, dx, dy, this);
                        break;
                    case "CL":
                        tr.addImage(arrowLeftComputer,0);
                        g.drawImage(arrowLeftComputer, dx, dy, this);
                        break;
                    case "PU":
                        tr.addImage(arrowUpPlayer,0);
                        g.drawImage(arrowUpPlayer, dx, dy, this);
                        break;
                    case "PD":
                        tr.addImage(arrowDownPlayer,0);
                        g.drawImage(arrowDownPlayer, dx, dy, this);
                        break;
                    case "PR":
                        tr.addImage(arrowRightPlayer,0);
                        g.drawImage(arrowRightPlayer, dx, dy, this);
                        break;
                    case "PL":
                        tr.addImage(arrowLeftPlayer,0);
                        g.drawImage(arrowLeftPlayer, dx, dy, this);
                        break;
                    case "U":
                        tr.addImage(arrowUp,0);
                        g.drawImage(arrowUp, dx, dy, this);
                        break;
                    case "D":
                        tr.addImage(arrowDown,0);
                        g.drawImage(arrowDown, dx, dy, this);
                        break;
                    case "R":
                        tr.addImage(arrowRight,0);
                        g.drawImage(arrowRight, dx, dy, this);
                        break;
                    case "L":
                        tr.addImage(arrowLeft,0);
                        g.drawImage(arrowLeft, dx, dy, this);
                        break;
                    default:
                        System.out.println("Error. No image direction given.");
                }
               dx += 40;
            }
            dx = 0;
            dy += 40;
        }
        
    }
//******************************************************************************   
    public void buildBoard()
    {
        for(int i = 0; i < boardArray.length; i++)
        {
            for(int j = 0; j < boardArray[i].length; j++)
            {
                int caseVar = rnd.nextInt(4);
                
                switch(caseVar)
                {
                    case 0: boardArray[i][j] = "U";
                        break;
                        
                    case 1: boardArray[i][j] = "D";
                        break;
                        
                    case 2: boardArray[i][j] = "L";
                        break;
                        
                    case 3: boardArray[i][j] = "R";
                        break;                             
                }
            }
        }
        //initial Player piece
        boardArray[0][0] = "PU";
        //initial Computer piece
        boardArray[boardArray.length-1][boardArray.length-1] = "CR";
                
    }
//****************************************************************************** 
    public void nextLocation(int x, int y){
        
    }
//******************************************************************************
    public void game()
    {

    }
//******************************************************************************
    public void rotate()
    {
        
    }
//******************************************************************************
    @Override
    public void keyTyped(KeyEvent e) 
    {
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_UP:
                System.out.println("Move up");
                break;

            case KeyEvent.VK_DOWN:
                System.out.println("Move down");
                break;

            case KeyEvent.VK_LEFT:
                System.out.println("Move left");
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println("Move right");
                break;

            case KeyEvent.VK_SPACE:
                System.out.println("Rotate Tile");
                break;
        }
    }
//******************************************************************************
    @Override
    public void keyPressed(KeyEvent e) 
    {
        
    }
//******************************************************************************
    @Override
    public void keyReleased(KeyEvent e) 
    {
        
    }
//******************************************************************************    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        
    }
//****************************************************************************** 
    @Override
    public void mousePressed(MouseEvent e) 
    {
        mouseX = e.getX();
        mouseY = e.getY();
        System.out.println(mouseX+", "+mouseY);
    }
//****************************************************************************** 
    @Override
    public void mouseReleased(MouseEvent e) 
    {

    }
//****************************************************************************** 
    @Override
    public void mouseEntered(MouseEvent e) 
    {

    }
//****************************************************************************** 
    @Override
    public void mouseExited(MouseEvent e)
    {

    }
//****************************************************************************** 
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
