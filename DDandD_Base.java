/**
 * DUNGEONS, DUNGEONS, AND MORE DUNGEONS
 * @author Ameen Rasheed Zafiruddin
 **/

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
NEW IMPLEMENTATIONS:
- Exception Handlers
- FileReader
- TimeUnit
*/

public class DDandD_Base
{
    private int[][] map;
    private int dimensions;
    private int exitR;
    private int exitC;
    private Scanner sc;
    private Scanner ex;
    private int playerMaxHP;
    private int playerAttack;
    private int playerMagic;
    private int level;
    private Weapon playerWeapon;
    private String playerName;
    
    /*
    Number ID:
    -1 : Player
     9 : Empty
     1 : Wall
     2 : Enemy
     3 : Skill
     4 : Item
     5 : Exit
     
     NOTE: if ID + 6 > Clouded
           if ID > Revealed
    */
    
    
    public DDandD_Base(int dim, int tunnel, int length, int lvl, String name)
    {
        playerMaxHP = 10;
        playerAttack = 1;
        playerMagic = 5;
        level = lvl;
        if(level == 1)
        {
            playerWeapon = new Weapon();
        }
        
        dimensions = dim;
        map = new int[dimensions][dimensions];
        playerName = name;
        
        for(int i = 0; i < dimensions; i++)
        {
            for(int j = 0; j < dimensions; j++)
            {
                map[i][j] = 16;
            }
        }
        
        int currentRow = (int)(dimensions/2);
        int currentCol = (int)(dimensions/2);
       
        int maxTunnel = tunnel;
        int maxLength = length;
        int directionID = 1;
        
        
        while(maxTunnel > 0)
        {
            int randomLength = (int)(Math.random()*maxLength);
            int randomDirection = (int)(Math.random()*2);
            
            //System.out.println("A---------------------------------");
            if(randomDirection == 0 && directionID == 1)
            {
                while(randomLength > 0)
                {
                    //System.out.println("Ba");
                    if(currentRow < dimensions-4 && currentRow > 4) // NaN, 1
                    {
                        currentRow--;
                        //System.out.println("up > " + currentRow + "," + currentCol);
                        map[currentRow][currentCol] = 96;
                    }
                    randomLength--;
                }
                directionID = 0;
            }
            else if(randomDirection == 1 && directionID == 1)
            {
                while(randomLength > 0)
                {
                    //System.out.println("Bb");
                    if(currentRow < dimensions-5 && currentRow > 2) //-1,-1
                    {
                        currentRow++;
                        //System.out.println("down > " + currentRow + "," + currentCol);
                        map[currentRow][currentCol] = 96;
                    }
                    randomLength--;
                }
                directionID = 0;
            }
            else if(randomDirection == 0 && directionID == 0)
            {
                while(randomLength > 0)
                {
                    //System.out.println("Bc");
                    if(currentCol < dimensions-5 && currentCol > 2) //-1,-1
                    {
                        currentCol++;
                        //System.out.println("right > " + currentRow + "," + currentCol);
                        map[currentRow][currentCol] = 96;
                    }
                    randomLength--;
                }
                directionID = 1;
            }
            else if(randomDirection == 1 && directionID == 0)
            {
                while(randomLength > 0)
                {
                    //System.out.println("Bd");
                    if(currentCol < dimensions-4 && currentCol > 4) //NaN, 1
                    {
                        currentCol--;
                        //System.out.println("left > " + currentRow + "," + currentCol);
                        map[currentRow][currentCol] = 96;
                    }
                    randomLength--;
                }
                directionID = 1;
            }
            maxTunnel--;
        }
        map[currentRow][currentCol] = 5;
        map[(int)(dimensions/2)][(int)(dimensions/2)] = -1;
        
        exitR = currentRow;
        exitC = currentCol;
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    public void printMap()
    {
        for(int i = 0; i < dimensions; i++)
        {
            for(int j = 0; j < dimensions; j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    public void printLayoutMap()
    {
        for(int i = 0; i < dimensions; i++)
        {
            for(int j = 0; j < dimensions; j++)
            {
                if(map[i][j] == 9)
                {
                    System.out.print("[]");
                }
                else if(map[i][j] == 2)
                {
                    System.out.print("XX");
                }
                else if(map[i][j] == 3)
                {
                    System.out.print("SK");
                }
                else if(map[i][j] == 4)
                {
                    System.out.print("##");
                }
                else if(map[i][j] == 5)
                {
                    System.out.print("<>");
                }
                else if(map[i][j] == -1)
                {
                    System.out.print("@@");
                }
                else if(map[i][j] == 1)
                {
                    System.out.print("  ");
                }
                else
                {
                    System.out.print("░░");
                }
            }
            System.out.println();
        }
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    public void printCaveMap()
    {
        for(int i = 0; i < dimensions; i++)
        {
            for(int j = 0; j < dimensions; j++)
            {
                if(map[i][j] == 9)
                {
                    System.out.print("   ");
                }
                else if(map[i][j] == 2)
                {
                    System.out.print("¶¶ "); 
                }
                else if(map[i][j] == 3)
                {
                    System.out.print("╠╣ ");
                }
                else if(map[i][j] == 4)
                {
                    System.out.print("[] ");
                }
                else if(map[i][j] == 5)
                {
                    System.out.print("<> ");
                }
                else if(map[i][j] == -1)
                {
                    System.out.print("██ ");
                }
                else if (map[i][j] == 1)
                {
                    System.out.print("▒▒▒");
                }
                else
                {
                    System.out.print("░░░");
                }
            }
            System.out.println();
        }
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    public void printSnowMap()
    {
        for(int i = 0; i < dimensions; i++)
        {
            for(int j = 0; j < dimensions; j++)
            {
                if(map[i][j] == 9)
                {
                    System.out.print("▒▒ ");
                }
                else if(map[i][j] == 2) 
                {
                    System.out.print("¶¶ ");
                }
                else if(map[i][j] == 3)
                {
                    System.out.print("╠╣ ");
                }
                else if(map[i][j] == 4)
                {
                    System.out.print("[] ");
                }
                else if(map[i][j] == 5)
                {
                    System.out.print("<> ");
                }
                else if(map[i][j] == -1)
                {
                    System.out.print("██ ");
                }
                else if(map[i][j] == 1)
                {
                    int chance = (int)(Math.random()*4);
                    if(chance == 0)
                        System.out.print("\"  ");
                    else
                        System.out.print("   ");
                }
                else
                {
                    System.out.print("░░░");
                }
            }
            System.out.println();
        }
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    public void printVectrixMap()
    {
        for(int i = 0; i < dimensions; i++)
        {
            for(int j = 0; j < dimensions; j++)
            {
                if(map[i][j] == 9)
                {
                    System.out.print("···");
                }
                else if(map[i][j] == 2)
                {
                    System.out.print("¶¶ "); 
                }
                else if(map[i][j] == 3)
                {
                    System.out.print("╠╣ ");
                }
                else if(map[i][j] == 4)
                {
                    System.out.print("[] ");
                }
                else if(map[i][j] == 5)
                {
                    System.out.print("<> ");
                }
                else if(map[i][j] == -1)
                {
                    System.out.print("██ ");
                }
                else if(map[i][j] == 1)
                {
                    int chance = (int)(Math.random()*4);
                    if(chance == 0)
                        System.out.print("010");
                    else if(chance == 1)
                        System.out.print("101");
                    else if(chance == 2)
                        System.out.print("111");
                    else
                        System.out.print("000");
                }
                else
                {
                    System.out.print("░░░");
                }
            }
            System.out.println();
        }
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    public Weapon returnCurrentWeapon()
    {
        return playerWeapon;
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    public void setupMapItems(int en, int sk, int it, Weapon wpn)
    {
        int enemies = en;
        int skills = sk;
        int items = it;
        playerWeapon = wpn;
        
        while(enemies > 0)
        {
            int randomRow = (int)(Math.random()*dimensions);
            int randomCol = (int)(Math.random()*dimensions);
            
            if(map[randomRow][randomCol] == 96)
            {
                map[randomRow][randomCol] = 26;
                enemies--;
            }
        }
        while(skills > 0)
        {
            int randomRow = (int)(Math.random()*dimensions);
            int randomCol = (int)(Math.random()*dimensions);
            
            if(map[randomRow][randomCol] == 96)
            {
                map[randomRow][randomCol] = 36;
                skills--;
            }
        }
        while(items > 0)
        {
            int randomRow = (int)(Math.random()*dimensions);
            int randomCol = (int)(Math.random()*dimensions);
            
            if(map[randomRow][randomCol] == 96)
            {
                map[randomRow][randomCol] = 46;
                items--;
            }
        }
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    /*
    Return Possibilities:
    1 : Flee
    2 : Win
    3 : Loss
    */
    public int enemyEncounter()
    {
        Enemy currentEnemy = new Enemy(level);
        int playerHP = playerMaxHP;
        int enemyHP = ((int)(Math.random()*10))*level;
        boolean flee = false;
        ex = new Scanner(System.in);
        
        while(enemyHP > 0 && playerHP > 0 && flee == false)
        {
            sc = new Scanner(System.in);
            
            try {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println(currentEnemy.enemyName() + " Lvl. " + currentEnemy.enemyLevel());
            System.out.println("HP:" + enemyHP);
            System.out.println();
            System.out.println(playerName);
            System.out.println("HP:" + playerHP);
            System.out.println("--------------------------------------------------------------------------");
            
            System.out.println("Press...");
            System.out.println("[1]: Attack with your " + playerWeapon.weaponName());
            System.out.println("[2]: Magic");
            System.out.println("[3]: Flee");
            int answer = sc.nextInt();
            
            if(answer == 1)
            {
                enemyHP -= playerWeapon.weaponDamage()*playerAttack;
                System.out.println("You attacked " + currentEnemy.enemyName() + "!");
                try { TimeUnit.SECONDS.sleep(1); }
                catch (InterruptedException ie) { ie.printStackTrace(); }
                System.out.println("--------------------------------------------------------------------------");
            }
            else if(answer == 2)
            {
                int chance = (int)(Math.random()*10);
                if(chance < 3)
                {
                    enemyHP -= playerMagic;
                    System.out.println("Your magic cursed " + currentEnemy.enemyName() + "!");
                    try { TimeUnit.SECONDS.sleep(1); }
                    catch (InterruptedException ie) { ie.printStackTrace(); }
                    System.out.println("--------------------------------------------------------------------------");
                }
                else
                {
                    System.out.println("Your magic was ineffective against " + currentEnemy.enemyName() + "!");
                    try { TimeUnit.SECONDS.sleep(1); }
                    catch (InterruptedException ie) { ie.printStackTrace(); }
                    System.out.println("--------------------------------------------------------------------------");
                }
            }
            else
            {
                flee = true;
            }
            }  
            catch(Exception e) {System.out.println("ERROR: That input is not an accepted value");}
            
            if(enemyHP > 0 && playerHP > 0 && flee == false)
            {
                playerHP -= (int)((Math.random()*level+2)+level);
                System.out.println("You took damage from " + currentEnemy.enemyName());
                try { TimeUnit.SECONDS.sleep(2); }
                catch (InterruptedException ie) { ie.printStackTrace(); }
            }
        }
        
        if(flee == true)
        {
            System.out.println("You've fled the battle");
            try { TimeUnit.SECONDS.sleep(1); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
            System.out.println("Press [ENTER] to continue...");
            ex.nextLine();
            return 1;
        }
        else if(enemyHP <= 0)
        {
            System.out.println("You've defeated " + currentEnemy.enemyName() + ". Onward!");
            try { TimeUnit.SECONDS.sleep(1); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
            System.out.println("Press [ENTER] to continue...");
            ex.nextLine();
            return 2;
        }
        else if(playerHP <= 0)
        {
            try { TimeUnit.SECONDS.sleep(1); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
            System.out.println("You've been desecrated!");
            try { TimeUnit.SECONDS.sleep(1); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
            System.out.println("Level: " + level);
            try { TimeUnit.SECONDS.sleep(1); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
            return 3;
        }
        return -1;
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    public void skillUpgrade()
    {
        sc = new Scanner(System.in);
        ex = new Scanner(System.in);
        
        try {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("You've encountered a skill upgrade...");
        System.out.println(playerName + "'s CURRENT SKILL LEVELS:");
        System.out.println("HP: " + playerMaxHP);
        System.out.println("Attack Multiplier: " + playerAttack);
        System.out.println("Magic Strength: " + playerMagic);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Which skill would you like to upgrade:");
        System.out.println("[1]: +2 HP");
        System.out.println("[2]: +1 Attack");
        System.out.println("[3]: +3 Magic");
        int answer = sc.nextInt();
        
        if(answer == 1)
        {
            playerMaxHP += 2;
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Your maximum Health has increased by 2!");
            try { TimeUnit.SECONDS.sleep(1); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
            System.out.println("Press [ENTER] to continue...");
            ex.nextLine();
        }
        else if(answer == 2)
        {
            playerAttack++;
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("You weapon damage multipler has increased by 1!");
            try { TimeUnit.SECONDS.sleep(1); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
            System.out.println("Press [ENTER] to continue...");
            ex.nextLine();
        }
        else
        {
            playerMagic += 3;
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("You magic has strengthened by 3!");
            try { TimeUnit.SECONDS.sleep(1); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
            System.out.println("Press [ENTER] to continue...");
            ex.nextLine();
        }
        }
        catch(Exception e) {System.out.println("ERROR: That input is not an accepted value");}
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    public void findWeapon()
    {
        sc = new Scanner(System.in);
        ex = new Scanner(System.in);
        Weapon newWeapon = new Weapon(level);
        
        try {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("You've found a new weapon...");
        System.out.println("WEAPON FOUND:");
        System.out.println("Name: " + newWeapon.weaponName());
        System.out.println("Damage: " + newWeapon.weaponDamage());
        System.out.println();
        System.out.println(playerName + "'s CURRENT WEAPON:");
        System.out.println("Name: " + playerWeapon.weaponName());
        System.out.println("Damage: " + playerWeapon.weaponDamage());
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Would you like to swap your current weapon with the new one?");
        System.out.println("[1]: Yes");
        System.out.println("[2]: No");
        int answer = sc.nextInt();
        
        if(answer == 1)
        {
            playerWeapon = newWeapon;
            System.out.println("You've swapped out your weapon.");
            try { TimeUnit.SECONDS.sleep(2); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
            System.out.println("Press [ENTER] to continue...");
            ex.nextLine();
        }
        else
        {
            playerWeapon = playerWeapon;
            System.out.println("You've kept your current weapon.");
            try { TimeUnit.SECONDS.sleep(2); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
            System.out.println("Press [ENTER] to continue...");
            ex.nextLine();
        }
        }
        catch(Exception e) {System.out.println("ERROR: That input is not an accepted value");}
    }
    
    
    //---------------------------------------------------------------------------------------------------------------
    
    
    public void playMap(int lvl)
    {
        level = lvl;
        
        int playerPosR = (int)(dimensions/2);
        int playerPosC = (int)(dimensions/2);
        
        int biome = (int)(Math.random()*10);
        
        while(map[exitR][exitC] == 5)
        {
            
            if(biome <= 4)
                this.printCaveMap();
            else if(biome <= 8)
                this.printSnowMap();
            else
                this.printVectrixMap();
            
            //this.printLayoutMap();
            
            sc = new Scanner(System.in);
            ex = new Scanner(System.in);
            
            for(int i = -4; i < 5; i++)
            {
                for(int j = -4; j < 5; j++)
                {
                    if(map[playerPosR+(i)][playerPosC+(j)] > 9)
                    {
                        map[playerPosR+(i)][playerPosC+(j)] = ((map[playerPosR+(i)][playerPosC+(j)])/10);
                    }
                }
            }
            
            try {
            System.out.println("Current Level: " + level);
            System.out.println("[W][A][S][D] : Move Character");
            System.out.println("[E] : View Player's Skills");
            System.out.println("[Q] : End the Program");
            String answer = sc.nextLine();
            if(answer.equals("w"))
            {
                if(map[playerPosR-1][playerPosC] == 9 || map[playerPosR-1][playerPosC] == 5)
                {
                    map[playerPosR][playerPosC] = 9;
                    playerPosR--;
                    map[playerPosR][playerPosC] = -1;
                }
                else if(map[playerPosR-1][playerPosC] == 2)
                {
                int result = this.enemyEncounter();
                    if(result == 1)
                    {
                        map[playerPosR][playerPosC] = -1;
                    }
                    else if(result == 2)
                    {
                        map[playerPosR][playerPosC] = 9;
                        playerPosR--;
                        map[playerPosR][playerPosC] = -1;
                    }
                    else if(result == 3)
                    {
                        System.exit(0);
                    }
                }
                else if(map[playerPosR-1][playerPosC] == 3)
                {
                    this.skillUpgrade();
                    map[playerPosR][playerPosC] = 9;
                    playerPosR--;
                    map[playerPosR][playerPosC] = -1;
                }
                else if(map[playerPosR-1][playerPosC] == 4)
                {
                    this.findWeapon();
                    map[playerPosR][playerPosC] = 9;
                    playerPosR--;
                    map[playerPosR][playerPosC] = -1;
                }
            }
            else if(answer.equals("a"))
            {
                if(map[playerPosR][playerPosC-1] == 9 || map[playerPosR][playerPosC-1] == 5)
                {
                    map[playerPosR][playerPosC] = 9;
                    playerPosC--;
                    map[playerPosR][playerPosC] = -1;
                }
                else if(map[playerPosR][playerPosC-1] == 2)
                {
                    int result = this.enemyEncounter();
                    if(result == 1)
                    {
                        map[playerPosR][playerPosC] = -1;
                    }
                    else if(result == 2)
                    {
                        map[playerPosR][playerPosC] = 9;
                        playerPosC--;
                        map[playerPosR][playerPosC] = -1;
                    }
                    else if(result == 3)
                    {
                        System.exit(0);
                    }
                }
                else if(map[playerPosR][playerPosC-1] == 3)
                {
                    this.skillUpgrade();
                    map[playerPosR][playerPosC] = 9;
                    playerPosC--;
                    map[playerPosR][playerPosC] = -1;
                }
                else if(map[playerPosR][playerPosC-1] == 4)
                {
                    this.findWeapon();
                    map[playerPosR][playerPosC] = 9;
                    playerPosC--;
                    map[playerPosR][playerPosC] = -1;
                }
            }
            else if(answer.equals("s"))
            {
                if(map[playerPosR+1][playerPosC] == 9 || map[playerPosR+1][playerPosC] == 5)
                {
                    map[playerPosR][playerPosC] = 9;
                    playerPosR++;
                    map[playerPosR][playerPosC] = -1;
                }
                else if(map[playerPosR+1][playerPosC] == 2)
                {
                    int result = this.enemyEncounter();
                    if(result == 1)
                    {
                        map[playerPosR][playerPosC] = -1;
                    }
                    else if(result == 2)
                    {
                        map[playerPosR][playerPosC] = 9;
                        playerPosR++;
                        map[playerPosR][playerPosC] = -1;
                    }
                    else if(result == 3)
                    {
                        System.exit(0);
                    }
                }
                else if(map[playerPosR+1][playerPosC] == 3)
                {
                    this.skillUpgrade();
                    map[playerPosR][playerPosC] = 9;
                    playerPosR++;
                    map[playerPosR][playerPosC] = -1;
                }
                else if(map[playerPosR+1][playerPosC] == 4)
                {
                    this.findWeapon();
                    map[playerPosR][playerPosC] = 9;
                    playerPosR++;
                    map[playerPosR][playerPosC] = -1;
                }
            }
            else if(answer.equals("d"))
            {
                if(map[playerPosR][playerPosC+1] == 9 || map[playerPosR][playerPosC+1] == 5)
                {
                    map[playerPosR][playerPosC] = 9;
                    playerPosC++;
                    map[playerPosR][playerPosC] = -1;
                }
                else if(map[playerPosR][playerPosC+1] == 2)
                {
                    int result = this.enemyEncounter();
                    if(result == 1)
                    {
                        map[playerPosR][playerPosC] = -1;
                    }
                    else if(result == 2)
                    {
                        map[playerPosR][playerPosC] = 9;
                        playerPosC++;
                        map[playerPosR][playerPosC] = -1;
                    }
                    else if(result == 3)
                    {
                        System.exit(0);
                    }
                }
                else if(map[playerPosR][playerPosC+1] == 3)
                {
                    this.skillUpgrade();
                    map[playerPosR][playerPosC] = 9;
                    playerPosC++;
                    map[playerPosR][playerPosC] = -1;
                }
                else if(map[playerPosR][playerPosC+1] == 4)
                {
                    this.findWeapon();
                    map[playerPosR][playerPosC] = 9;
                    playerPosC++;
                    map[playerPosR][playerPosC] = -1;
                }
            }
            else if(answer.equals("q"))
            {
                System.exit(0); //Ends the program
            }
            else if(answer.equals("e"))
            {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println(playerName + "'s CURRENT SKILL LEVELS:");
                System.out.println("HP: " + playerMaxHP);
                System.out.println("Attack Multiplier: " + playerAttack);
                System.out.println("Magic Strength: " + playerMagic);
                System.out.println("--------------------------------------------------------------------------");
                System.out.println(playerName + "'s CURRENT WEAPON:");
                System.out.println("Name: " + playerWeapon.weaponName());
                System.out.println("Damage: " + playerWeapon.weaponDamage());
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Press [ENTER] to return to the game...");
                ex.nextLine();
            }
            else
            {
                map[playerPosR][playerPosC] = -1;
            }
            }
            catch(Exception e) {System.out.println("ERROR: That input is not an accepted value");}
        }
    }
}