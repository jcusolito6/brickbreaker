import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.*;


/**
*
*Program9 class . 
*
*@author Jason Cusolito
*
*/

public class Program9
{
    private static TextBox scoreboard, scoreboard2, scoreboard3, scoreboard4;
    private static Ball gameball;
    private int reserveballs = 2;
    private GameSlider gs;
    private Vector<Block> blueblocks, redblocks, greenblocks;
    private Block redRectangle, greenRectangle, blueRectangle;
    private int nob;
    private int score = 0;
    private int score2 = 0;
    private int score3 = 0;
    private int redbonus, greenbonus, bluebonus;
    private Animation explode, explode2, explode3;
    private int gamewon;
    private int bricksleft;

/**
*
*Program9 constructor method .
*
*/ 


    public Program9()
    {

        new Frame( 700 , 550 );
        
        Rectangle background = new Rectangle( 0 , 0 );
        background.setSize( 700 , 420 );
        background.setColor( Color.BLACK );

        nob = Utilities.readInt( "Enter a number of bricks.", 8 );
        bricksleft = nob * 3;
        
        
        blueblocks = new Vector<Block>();
        for( int i = 0; i < nob; i++ )
        {
        
            blueRectangle = new Block ( 10 + 700 / nob * i + 5, 10 );
            blueRectangle.setSize( 500 / nob - 10 , 20 );
            blueRectangle.setColor( Color.BLUE );
            blueRectangle.setRotation( 180 );
            blueblocks.add( blueRectangle );

        }
        
        
        greenblocks = new Vector<Block>();
        for( int i = 0; i < nob; i++ )
        {
        
            greenRectangle = new Block ( 10 + 700 / nob * i + 5, 70 );
            greenRectangle.setSize( 500 / nob - 10 , 20 );
            greenRectangle.setColor( Color.GREEN );
            greenRectangle.setRotation( 180 );
            greenblocks.add( greenRectangle );

        }
        
        
        redblocks = new Vector<Block>();
        for( int i = 0; i < nob; i++ )
        {
        
            redRectangle = new Block ( 10 + 700 / nob * i + 5, 40 );
            redRectangle.setSize( 500 / nob - 10 , 20 );
            redRectangle.setColor( Color.RED );
            redRectangle.setRotation( 180 );
            redblocks.add( redRectangle );

        }












        scoreboard = new TextBox ( 300 , 450 );
        scoreboard.setText( "Reserve balls: " + reserveballs );
        scoreboard.setColor( Color.WHITE );
        
        scoreboard2 = new TextBox ( 300 , 500 );
        scoreboard2.setText( "Score: " + score );
        scoreboard2.setColor( Color.WHITE );
        
        scoreboard3 = new TextBox ( 300 , 515 );
        scoreboard3.setColor( Color.WHITE );
        
        scoreboard4 = new TextBox ( 150 , 500 ); 
        scoreboard4.setColor( Color.WHITE );
        scoreboard4.setText( "Bricks left: " + bricksleft );
        



        gs = new GameSlider ( 350 , 400 );
        gameball = new Ball ();


        while ( true )
        { 
            collisionDetection( gs , redblocks, blueblocks, greenblocks );
            gameball.move( );
            Utilities.sleep( 20 );
        }

  
  
  
    }
/**
*resetBall method .
*
*@param gb Ball
*/
    
    public void resetBall( Ball gb ) 
    {
        System.out.println( "Ball lost!" );
        
        if ( reserveballs > 0 )
        {
            Utilities.sleep( 500 );
            gb.setLocation ( 350 , 300 );
        
            scoreboard.setText( "Reserve balls: " + ( --reserveballs  ) );
        
            reserveballs = reserveballs;
        }
        
        else
        {
            
            Rectangle rectanglego = new Rectangle ( 0 , 0 );
            rectanglego.setSize( 1000 , 1000 );
            rectanglego.setColor( Color.YELLOW );
            
            TextBox gameover = new TextBox( 200 , 200 );
            gameover.setSize( 300 , 300 );
            
            gameover.setText( " Game Over! " );
            scoreboard.hide();
            scoreboard2.hide();
            scoreboard3.hide();
            scoreboard4.hide();
            

            gameover.setColor( Color.YELLOW );
            rectanglego.setColor( Color.YELLOW );
            Utilities.sleep ( 500 );
            rectanglego.setColor( Color.BLACK );
            Utilities.sleep( 500 );
            rectanglego.setColor( Color.YELLOW );
            Utilities.sleep ( 500 );
            rectanglego.setColor( Color.BLACK );
            Utilities.sleep( 500 );



            
            
        }     
    
    
    }
/**
*
*collisionDetection method .
*
*@param gs1 GameSlider
*@param v1 Vector<Block>
*@param v2 Vector<Block>
*@param v3 Vector<Block>
*/
    
    
    public void collisionDetection( GameSlider gs1, Vector<Block> v1, 
        Vector<Block> v2, Vector<Block> v3 )
    {
        if ( gameball.getYLocation() >= 450 )
        {
            resetBall( gameball );
        }

        if ( gameball.getYLocation() == 385 && gameball.getXLocation() >= 
            gs1.getXLocation()  && gameball.getXLocation()
            <= gs1.getXLocation() + 150   )
        {
            int dyy = gameball.getDeltaY();
            dyy *= -1;
            gameball.setDeltaY( dyy );
            scoreboard3.setText( "" );  
        }
        
        for ( Block br: v1 )
        {
            if ( gameball.boundsIntersects ( br ) )
            {
                explode = new Animation( br.getXLocation() ,
                    br.getYLocation() );
                br.hide();
                br.setLocation ( 1000 , 1000 );
                int dyy = gameball.getDeltaY();
                dyy *= -1;
                gameball.setDeltaY( dyy );
                Ellipse e = new Ellipse ( br.getXLocation() , 
                    br.getYLocation() );
                ++gamewon;
                System.out.println( "10 points" );
                score = score + 10;
                score = score;
                scoreboard2.setText( "Score: " + score  );
                ++redbonus;
                scoreboard3.setText( "" );
                --bricksleft;
                bricksleft = bricksleft;
                scoreboard4.setText( "Bricks left: " + bricksleft );
                if ( redbonus == nob )
                {
                    score = score + 100;
                    score = score;
                    scoreboard2.setText( "Score: " + score  );
                    scoreboard3.setText( "+ 100!" );
                }
                

            }
        }
        
        for ( Block br2: v2 )
        {
            if ( gameball.boundsIntersects ( br2 ) )
            {
                explode2 = new Animation( br2.getXLocation() ,
                    br2.getYLocation() );                
                br2.hide();
                br2.setLocation ( 1000 , 1000 );
                int dyy = gameball.getDeltaY();
                dyy *= -1;
                gameball.setDeltaY( dyy );
                System.out.println( "20 points" );
                score = score + 20;
                score = score;
                scoreboard2.setText( "Score: " + score  );
                scoreboard3.setText( "" );
                ++gamewon;
                --bricksleft;
                bricksleft = bricksleft;
                scoreboard4.setText( "Bricks left: " + bricksleft );
                ++bluebonus;
                if ( bluebonus == nob )
                {
                    score = score + 200;
                    score = score;
                    scoreboard2.setText( "Score: " + score  );
                    scoreboard3.setText( "+ 200!" );

                }
            }

        }
        

        for ( Block br3: v3 )
        {
            if ( gameball.boundsIntersects ( br3 ) )
            {
                explode3 = new Animation( br3.getXLocation() , 
                    br3.getYLocation() );
                br3.hide();
                br3.setLocation ( 1000 , 1000 );
                int dyy = gameball.getDeltaY();
                dyy *= -1;
                gameball.setDeltaY( dyy );
                System.out.println( "5 points" );
                score = score + 5;
                score = score;
                scoreboard2.setText( "Score: " + score  );
                ++greenbonus;
                ++gamewon;
                --bricksleft;
                bricksleft = bricksleft;
                scoreboard4.setText( "Bricks left: " + 
                    bricksleft );                
                scoreboard3.setText( "" );
                if ( greenbonus == nob )
                {
                    score = score + 50;
                    score = score;
                    scoreboard2.setText( "Score: " + score  );
                    scoreboard3.setText( "+ 50!" );
                }


            
            
            }
            
            if ( gamewon == nob * 3 )
            {
                Rectangle r = new Rectangle ( 0 , 0 );
                r.setSize( 1000 , 1000 );
                r.setColor( Color.GREEN );
                scoreboard2.hide();
                scoreboard3.hide();
                scoreboard.hide();
                scoreboard4.hide();
                

                
                TextBox youwon = new TextBox ( 200 , 200 );
                youwon.setColor( Color.GREEN );
                r.setColor( Color.GREEN );
                youwon.setText( " You won! " );
                r.setColor( Color.BLUE );
                Utilities.sleep( 500 );
                r.setColor( Color.GREEN );
                Utilities.sleep( 500 );
                r.setColor( Color.BLUE );
            
            }
               
        }

    
    }
    
    

/**
*
*main method .
*
*@param args String[]
*/
    public static void main ( String [] args )
    {
        Program9 app = new Program9(); 

    
    
    
    
    
    }
    
    
    










}