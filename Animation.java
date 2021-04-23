import wheelsunh.users.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Point;
import java.util.*;

/**
*
*Animation class .
*
*@author Jason Cusolito
*
*/

public class Animation implements Animator 
{
    

    private AnimationTimer timer; 
    private Ellipse bomb; 
    private int n; 
    private Color orange = new Color ( 255, 205, 0 ); 
/**
*
*Animation constructor method .
*
*@param x int 
*@param y int
*/
    
    public Animation( int x, int y ) 
    {
        
        
        timer = new AnimationTimer( 1, this );
        bomb = new Ellipse( x, y ); 
        bomb.setSize( 40, 2 );
        timer.start();
        bomb.setColor( orange );
        
        
        
    }
/**
*
*animation method .
*/
    
    public void animate()
    {
        ++n;
        bomb.setSize( bomb.getWidth() + 1, bomb.getHeight() + 1 );
        if( n > 50 )
        {
            
            timer.stop();
            bomb.hide(); 
        }
    }
    
/**
*
*main method .
*
*@param args String []
*
*/
    public static void main( String[] args )
    {
        
        new Frame( );
        Animation app = new Animation( 50, 50 );
        
    }
}