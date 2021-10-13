import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    private String up;
    private String down;
    

    /**
     * create new paddle
     */
    public Paddle(String up, String down)
    {
        this.up = up;
       this.down = down;
    }
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       checkKeys();
       setRotation(90);
    }
    
    /**
     * paddle movement
     */
    public void checkKeys()
    {
        if (Greenfoot.isKeyDown(up))
        {
            move(-4);
        }
        if (Greenfoot.isKeyDown(down))
        {
            move(4);
        }
    }
}
