import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Weapon
{
    private String [] allWeapons;
    private String weapon;
    private int damage;
    
    public Weapon()
    {
        this.importWeapons();
        weapon = "Rusty Sword";
        damage = 1;
    }
    
    public Weapon(int level)
    {
        this.importWeapons();
        int weaponNum = (int)(Math.random()*(allWeapons.length));
        weapon = allWeapons[weaponNum];
        damage = ((int)(Math.random()*4))+level;
    }
    
    public String weaponName()
    {
        return weapon;
    }
    
    public int weaponDamage()
    {
        return damage;
    }
    
    private void importWeapons()
    {
        allWeapons = new String[17];
        int i = 0;
        try (Scanner s = new Scanner(new FileReader("Weapons.txt")))
        {
            while (s.hasNext())
            {
                allWeapons[i] = (s.nextLine());
                i++;
            }
        }
        catch(FileNotFoundException e)
        {
         System.out.println("ERROR: File not found! Make sure that Weapons.txt is in the same folder as the game classes.");
        }
    }
}