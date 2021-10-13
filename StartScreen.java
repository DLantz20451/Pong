import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends Actor
{
    private int delayTimer = 0;
    
    /**
     * Act - do whatever the StartScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        delayTimer++;
        setLocation(300, 250);
    }
    
    /**
     * how the pong ball moves
     */
    public void spawnThenGone()
    {
        if(delayTimer >= 35)
        {
          getWorld().removeObject(this);
          delayTimer = 0;
        }
    }
}


