
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
    private final String[][] array = new String[20][20];
    private final Random rnd = new Random();
    Image arrowUp, arrowDown, arrowLeft, arrowRight;
    Image arrowUpPlayer, arrowDownPlayer, arrowLeftPlayer, arrowRightPlayer;
    MediaTracker tr;
    
    
//******************************************************************************
    @Override
    public void init()
    {        
        setSize(800, 800);
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
        arrowLeft = getImage(getCodeBase(), "images/arrowleft.png");
        arrowDown = getImage(getCodeBase(), "images/arrowDown.png");
        arrowRight = getImage(getCodeBase(), "images/arrowRight.png");
        arrowUpPlayer = getImage(getCodeBase(), "images/arrowUpPlayer.png");
        arrowRightPlayer = getImage(getCodeBase(), "images/arrowRightPlayer.png");
        
        for (int i = 0; i < array.length; i++) 
        {

            for (int j = 0; j < array[i].length; j++) 
            {
                if(array[i][j].equals("CR"))
                {
                    tr.addImage(arrowRightPlayer,0);
                    g.drawImage(arrowRightPlayer, dx, dy, this);
                }
                if(array[i][j].equals("PU"))
                {
                    tr.addImage(arrowUpPlayer,0);
                    g.drawImage(arrowUpPlayer, dx, dy, this);
                }
                if(array[i][j].equals("U"))
                {
                    tr.addImage(arrowUp,0);
                    g.drawImage(arrowUp, dx, dy, this);
                }
                if(array[i][j].equals("D"))
                {
                    tr.addImage(arrowDown,0);
                    g.drawImage(arrowDown, dx, dy, this);
                }
                if(array[i][j].equals("R"))
                {
                    tr.addImage(arrowRight,0);
                    g.drawImage(arrowRight, dx, dy, this);
                }
                if(array[i][j].equals("L"))
                {
                    tr.addImage(arrowLeft,0);
                    g.drawImage(arrowLeft, dx, dy, this);
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
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[i].length; j++)
            {
                int caseVar = rnd.nextInt(4);
                
                switch(caseVar)
                {
                    case 0: array[i][j] = "U";
                        break;
                        
                    case 1: array[i][j] = "D";
                        break;
                        
                    case 2: array[i][j] = "L";
                        break;
                        
                    case 3: array[i][j] = "R";
                        break;                             
                }
            }
        }
        //initial Player piece
         array[0][0] = "PU";
        //initial Computer piece
        array[0][19] = "CR";
                
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