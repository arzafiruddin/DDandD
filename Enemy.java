import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Enemy
{
    private String [] allNames;
    private String enemy;
    private int level;
    
    public Enemy(int lvl)
    {
        this.importNames();
        int randName = (int)(Math.random()*(allNames.length));
        enemy = allNames[randName];
        level = lvl;
    }
    
    public String enemyName()
    {
        return enemy;
    }
    
    public int enemyLevel()
    {
        return level;
    }
    
    private void importNames()
   {
        allNames = new String[10];
        int i = 0;
        try (Scanner s = new Scanner(new FileReader("Enemies.txt")))
        {
            while (s.hasNext())
            {
                allNames[i] = (s.nextLine());
                i++;
            }
        }
        catch(FileNotFoundException e)
        {
         System.out.println("ERROR: File not found! Make sure that Enemies.txt is in the same folder as the game classes.");
        }
   }
}