import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
*
*Ball class .
* 
*@author Jason Cusolito
*
*
*/

public class Ball extends Ellipse 
{

    private int deltaX, deltaY;
    private int size;
    private Color darkblue = new Color ( 100 , 0 , 200 );
    private int x1 , y1, reserveballs;

    
/**
*
*Ball constructor method .
*
*/
    public Ball (  )
    {    
        reserveballs = 2;   
    
        setSize ( 15 , 15 );
        setColor( Color.WHITE );
        deltaY = 5; 
        deltaX = 5;
        
        setLocation ( 350 , 375 );
        
        
        
        for ( int i = 0; i < 1; i++ )
        {
            deltaY = -deltaY;
        }





        
    }
    
/**
*
*move method .
*
*/


    public void move(  ) 
    {
        x1 = getXLocation() + deltaX;
        y1 = getYLocation() + deltaY;
       
        setLocation ( x1 , y1 );
       
        
     
        if ( x1 < 0 )
        {
            deltaX *= -1;
            x1 = 0;
        }
        
        else if ( x1 > 700 )
        {
            x1 = 700;
            deltaX *= -1;
        }
        
        if ( y1 < 0 )
        {
            y1 = 0;
            deltaY *= -1;
        }

    }
/**
*
*getDeltaY method .
*
*@return int
*/
    
    public int getDeltaY()
    {
        return deltaY;
    }
        
        
/**
*
*setDeltaY method .
*
*@param dy int
*/
        
    public void setDeltaY( int dy )
    {
        deltaY = dy;
    }
           
    
    

    

    
    
/**
*
*main method .
*
*@param args String[]
*/
    public static void main( String[] args )
    {
        new Frame( );
        Ball bb = new Ball();
        while ( true )
        { 
            //bb.move();
            Utilities.sleep( 20 );
        }

        
        
        
    }



}
