import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
*
*GameSlider class.
*@author Jason Cusolito
*/

public class GameSlider extends ShapeGroup

{ 
    private Rectangle slider;
    private Point lastMousePosition;
    private Color darkblue = new Color ( 100 , 0 , 200 );
    private int diffX;
    
/**
*
*GameSlider method .
*
*@param x int
*@param y int
*/
    
    public GameSlider( int x , int y )
    {
        slider = new Rectangle( x , y );
      
        slider.setSize( 65 , 15 );
        slider.setFillColor ( darkblue );
        slider.setFrameColor ( Color.GREEN );
       
       
        add( slider );
       
       
    }
/**
*
*mousePressed method .
*
*@param e MouseEvent
*/
    
    
    public void mousePressed( MouseEvent e )
    {
    
        lastMousePosition = e.getPoint( );

    
    }
/**
*
*mouseDragged method .
*
*@param e MouseEvent
*/
    
    

    public void mouseDragged( MouseEvent e )
    {
        Point currentPoint = e.getPoint();
        diffX = currentPoint.x - lastMousePosition.x;
        setLocation( getLocation().x + diffX, getLocation().y );
        lastMousePosition = currentPoint;
    }
    
    
    
/**
*
*main method .
*
*@param args String[]
*/   
    
    
    
    public static void main ( String[] args )
    {
        new Frame( );
        new GameSlider ( 10 , 10 );
       
    
    
    
    }
}
    