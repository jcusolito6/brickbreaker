import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.*;

/**
*
*Block class .
*
*@author Jason
*
*/

public class Block extends Rectangle
{

    
/**
*
*Block constructor method .
*
*@param x int
*@param y int 
*/
    
    public Block( int x , int y )
    {
        super( x , y );

    }









/**
*
*main method .
*
*@param args String[] 
*/



    public static void main ( String [] args )
    {
        new Frame();
        new Block( 200 , 200 );


    }



}