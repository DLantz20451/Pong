import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ball extends Actor
{
    private int dX = 4;     // x speed/movement
    private int dY = 3;     // y speed/movement
    
    private int score1 = 0;
    private int score2 = 0;
    
    private int delayTimer = 0;
    
    GifImage myGif = new GifImage("spinball.gif");
    
    /**
     * Act - do whatever the ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
        checkForBounce();
        setRotation(45);
        checkForPaddle();
        score();
        delayTimer++;
        setImage( myGif.getCurrentImage());
    }
    
    
    /**
     * how the pong ball moves
     */
    public void move()
    {
        if(delayTimer >= 100)
        {
            setLocation(getX() + dX,getY() + dY);
        }
    }
    
    /**
     * How our ball bounces off of our walls
     * 
     */
    public void checkForBounce()
    {
        if (getY() <= 0 || getY() >= getWorld().getHeight()-1)
        {
            dY = -dY;
            Greenfoot.playSound("Blip_Select9.wav");
        }
    }
    
    /**
     * How our ball bounces off our paddles
     */
    public void checkForPaddle()
    {
        if (isTouching(Paddle.class))
        {
            dX = -dX;
            Greenfoot.playSound("Blip_Select9.wav");
            
        }
        if (getX() >= 565 && (isTouching(Paddle.class)))
        {
            dX = -10;
            move();
            dX = -4;
        }
        if (getX() <= 35 && (isTouching(Paddle.class)))
        {
            dX = 10;
            move();
            dX = 4;
        }
    }
    
    /**
     * our temp startscreen
     */
    public void startScreen()
    {
        if (delayTimer >= 40)
        {
            getWorld().setBackground(new GreenfootImage("Start.png"));
            setLocation(getX() + dX,getY() + dY);
        }
    }
    
    /**
     * how our ball will return to spawn if it is missed
     * adds scores for Player 1 and 2
     */
    public void score()
    {
        if (getX() == 599 || getX() >= getWorld().getWidth()-1)
        {
          setLocation(300, 250); 
          delayTimer = 0;
          score1 +=1;
          checkForWin();
          Counter counter = (Counter)getWorld().getObjects(Counter.class).get(0);
          counter.add(1);
        }
        if (getX() <= 0 || getX() >= getWorld().getWidth())
        {
          setLocation(300, 250); 
          delayTimer= 0;
          score2 +=1;
          checkForWin();
          Counter2 counter2 = (Counter2)getWorld().getObjects(Counter2.class).get(0);
          counter2.add(1);
        }
    }
    
    
    /**
     * Checcks for win and plays Winner theme
     */
     public void checkForWin()
    {
         if (score2 >= 8)
        {
            Greenfoot.playSound("ayayay.mp3");
            setRotation(0);
            getWorld().setBackground(new GreenfootImage("GO2.png"));
            Greenfoot.stop();
        }
        if (score1 >= 8)
        {
            Greenfoot.playSound("ayayay.mp3");
            setRotation(0);
            getWorld().setBackground(new GreenfootImage("GO1.png"));
            Greenfoot.stop();
        }
    }
}
