import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DDandD_Runner
{
    public static void main(String [] args)
    {
        int level = 1;
        Scanner sc = new Scanner(System.in);
        Scanner ex = new Scanner(System.in);
        Weapon temp = new Weapon();
        String playerName = "";
        
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();
        try { TimeUnit.MICROSECONDS.sleep(200000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println("WELCOME TO...");
        System.out.println();
        try { TimeUnit.MICROSECONDS.sleep(500000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println("_____ __ __ __  __  ____  _____  _____  __  __   __    ");
        System.out.println("||  ) || || ||\\\\|| (( ___ ||==  ((   )) ||\\\\||  ((     ");
        System.out.println("||_// \\\\_// || \\||  \\\\_|| ||___  \\\\_//  || \\|| \\_)) // ");
        try { TimeUnit.MICROSECONDS.sleep(1000000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println("_____ __ __ __  __  ____  _____  _____  __  __   __    ");
        System.out.println("||  ) || || ||\\\\|| (( ___ ||==  ((   )) ||\\\\||  ((     ");
        System.out.println("||_// \\\\_// || \\||  \\\\_|| ||___  \\\\_//  || \\|| \\_)) // ");
        try { TimeUnit.MICROSECONDS.sleep(1000000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println(" ___  __  __ _____    ___  __  _____  _____ _____      ");
        System.out.println("||=|| ||\\\\|| ||  )    || \\/ | ((   )) ||_// ||==       ");
        System.out.println("|| || || \\|| ||_//    ||    |  \\\\_//  || \\\\ ||___      ");
        try { TimeUnit.MICROSECONDS.sleep(500000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println("_____ __ __ __  __  ____  _____  _____  __  __   __    ");
        System.out.println("||  ) || || ||\\\\|| (( ___ ||==  ((   )) ||\\\\||  ((     ");
        System.out.println("||_// \\\\_// || \\||  \\\\_|| ||___  \\\\_//  || \\|| \\_))");
        System.out.println();
        System.out.println();
        try { TimeUnit.MICROSECONDS.sleep(1000000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println("<<<  <<   <   Press [ENTER] to Begin   >   >>  >>>");
        ex.nextLine();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();
        try { TimeUnit.MICROSECONDS.sleep(500000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println("Before your off on your quest, enter your name below...");
        playerName = ex.nextLine();
        System.out.println("Player Name: " + playerName);
        try { TimeUnit.MICROSECONDS.sleep(500000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();
        try { TimeUnit.MICROSECONDS.sleep(500000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println("HOW TO PLAY");
        System.out.println();
        System.out.println("       +---+");
        System.out.println("       | W |");
        System.out.println("   +---+---+---+");
        System.out.println("   | A | S | D |");
        System.out.println("   +---+---+---+");
        System.out.println("In order to move around the map, use the W, A, S, D keys and press [ENTER]");
        System.out.println();
        System.out.println("As you play, you'll encounter various things you can interact with, such as:");
        System.out.println();
        System.out.println(" [] : Weapons Chests");
        System.out.println(" ¶¶ : Enemies");
        System.out.println(" ╠╣ : Skill Upgrades");
        System.out.println(" <> : Exit");
        System.out.println();
        System.out.println("In order to interact or take action during a scene during the game, follow the");
        System.out.println("on screen prompt provided.");
        System.out.println();
        System.out.println("You goal is to reach the exit so that you can progress to the next area.");
        System.out.println("Use Weapon Chests and Skill Upgrades to help strengthen you player and");
        System.out.println("fend off more difficult enemies who may stand in your way.");
        System.out.println();
        System.out.println("Press [ENTER] to Continue...");
        ex.nextLine();
        try { TimeUnit.MICROSECONDS.sleep(500000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println("--------------------------------------------------------------------------");
        try { TimeUnit.MICROSECONDS.sleep(1000000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println("Best of wishes on your journey!");
        try { TimeUnit.MICROSECONDS.sleep(1000000); }
            catch (InterruptedException ie) { ie.printStackTrace(); }
        System.out.println();
        System.out.println();
        System.out.println();
        
        for( ; ; )
        {
            DDandD_Base game = new DDandD_Base(40, 90, 10, level, playerName);
            game.setupMapItems(10, 1, 2, temp);
            game.playMap(level);
            System.out.println();
            System.out.println("--------------------------------------------------------------------------");
            String [] endMessage = {"L", "E", "V", "E", "L", " ", " ", " ",
                                    "C", "O", "M", "P", "L", "E", "T", "E"};
            temp = game.returnCurrentWeapon();
            for(int i = 0; i < endMessage.length; i++)
            {
                if(i == 6)
                {
                    System.out.print(level);
                }
                else
                {
                    System.out.print(endMessage[i]);
                }
                try { TimeUnit.MICROSECONDS.sleep(400000); }
                    catch (InterruptedException ie) { ie.printStackTrace(); }
            }
            System.out.println();
            System.out.println("--------------------------------------------------------------------------");
            try { TimeUnit.MICROSECONDS.sleep(500000); }
                catch (InterruptedException ie) { ie.printStackTrace(); }
            System.out.println("Enter any button to continue onto the next level... ");
            level++;
            sc.nextLine();
        }
        
    }
}