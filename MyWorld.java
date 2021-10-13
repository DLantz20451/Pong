import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x500 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        
        
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        ball ball = new ball();
        addObject(ball,getWidth()/2,getHeight()/2);

        Paddle paddle = new Paddle("w", "s");
        addObject(paddle,25,getHeight()/2);

        Paddle paddle2 = new Paddle( "up", "down");
        addObject(paddle2,575,getHeight()/2);

        Counter counter = new Counter("P2 Score ");
        addObject(counter,55,25);

        Counter2 counter2 = new Counter2("P1 Score ");
        addObject(counter2,550,25);

        ball.setLocation(297,249);

        //StartScreen startScreen = new StartScreen();
        //addObject(startScreen,getWidth()/2,getHeight()/2);
        
    }
    
}
