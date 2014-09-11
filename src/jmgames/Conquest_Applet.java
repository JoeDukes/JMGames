
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
    private boolean game = true;
    private int x,y,dx,dy;
    private int mouseX, mouseY;
    private final char[][] array = new char[20][20];
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
        while(!game)
        {     
            repaint();
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
    public void paint(Graphics g) 
    {
        x = 1;
        y = 1;
        dx = 0;
        dy = 0;
        tr = new MediaTracker(this);
        arrowUp = getImage(getCodeBase(), "images/arrowUp.png");
        arrowLeft = getImage(getCodeBase(), "images/arrowleft.png");
        arrowDown = getImage(getCodeBase(), "images/arrowDown.png");
        arrowRight = getImage(getCodeBase(), "images/arrowRight.png");
        
        for (int i = 0; i < array.length; i++) 
        {

            for (int j = 0; j < array[i].length; j++) 
            {
                if(array[i][j] == 'U')
                {
                    tr.addImage(arrowUp,0);
                    g.drawImage(arrowUp, dx, dy, this);
                }
                if(array[i][j] == 'U')
                {
                    tr.addImage(arrowUp,0);
                    g.drawImage(arrowUp, dx, dy, this);
                }
                if(array[i][j] == 'D')
                {
                    tr.addImage(arrowDown,0);
                    g.drawImage(arrowDown, dx, dy, this);
                }
                if(array[i][j] == 'R')
                {
                    tr.addImage(arrowRight,0);
                    g.drawImage(arrowRight, dx, dy, this);
                }
                if(array[i][j] == 'L')
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
                int x = rnd.nextInt(4);
                
                array[0][0] = 'U';
                array[0][19] = 'R';
                
                switch(x)
                {
                    case 0: array[i][j] = 'U';
                        break;
                        
                    case 1: array[i][j] = 'D';
                        break;
                        
                    case 2: array[i][j] = 'L';
                        break;
                        
                    case 3: array[i][j] = 'R';
                        break;                             
                }
            }
        }
    }
//****************************************************************************** 
    public void game()
    {
        
    }
//******************************************************************************
    @Override
    public void keyTyped(KeyEvent e) 
    {
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_UP:
                break;

            case KeyEvent.VK_DOWN:
                break;

            case KeyEvent.VK_LEFT:
                break;

            case KeyEvent.VK_RIGHT:
                break;

            case KeyEvent.VK_SPACE:
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
        System.out.println(mouseX+" ,"+mouseY);
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