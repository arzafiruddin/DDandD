# DDandD
  
<img src="https://github.com/arzafiruddin/DDandMoreD/blob/d739a5978eb8aa129c03815dbf010dbac268e5b1/readme_assets/logo.jpg" width="427" height="328"> <img src="https://github.com/arzafiruddin/DDandMoreD/blob/221033faf4110f1a7e750cc59bf40fba888956e3/readme_assets/cavedemogif.gif" width="378" height="344">

---

Version 0.4 - June 2019

## Features
- Unlimited unique procedurally-generated maps filled with enemies to kill, chests to discover, and skills to collect
- Fog-filled maps which clear out as you explore
- Player customizable enemy and weapon varieties
- Scaling enemy diffiulty and weapon strength as player progresses
- Top of the line ASCII-based console graphics, utilizing a whole 5 different shades of gray
- 3 uniques environments:

<img src="https://github.com/arzafiruddin/DDandMoreD/blob/c973595ed970a295cad71cd7e941f0d1f37e4478/readme_assets/cavegengif.gif"> &nbsp;&nbsp; <img src="https://github.com/arzafiruddin/DDandMoreD/blob/c973595ed970a295cad71cd7e941f0d1f37e4478/readme_assets/snowgengif.gif"> &nbsp;&nbsp; <img src="https://github.com/arzafiruddin/DDandMoreD/blob/c973595ed970a295cad71cd7e941f0d1f37e4478/readme_assets/matrixgengif.gif">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The Caverns &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The Snow Fields &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The Matrix

## How To Play
### Goal

Your goal is to survive as long as you can by reaching the exit of each area so you can progress to the next area. Use weapon chests and skill upgrades to help strengthen your character and fend off increasingly difficult enemies who may stand in your way.

### Movement

|     |  W  |     |       |         |
|:---:|:---:|:---:|:-----:|:-------:|
|**A**|**S**|**D**| . . . |**Enter**|

In order to move around, use the [ W ], [ A ], [ S ], and [ D ] keys followed by the [ ENTER ] key.

### Interactions and Encounters

As you play, you'll encounter various things you can interact with, such as:

| Icon           | Description   |
|:--------------:|---------------|
| [&nbsp;&nbsp;] | Weapons Chest |
|  ¶¶            | Enemy         |
|  ╠╣            | Skill Upgrade |
|  <>            | Exit          |

In order to interact with these, simply walk into the icon on the map screen. In order to take action during an in-game scene, use the [ 1 ], [ 2 ], [ 3 ], and [ E ] keys as prompted in the game.

### Combat

There are 3 options during an enemy encounter:

|   Option   | Description                                                                                                                                                   |
|:----------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------|
|[ 1 ] Attack| Enemy loses an amount of HP equal to the attack power of the player's weapon and skill (damage can increase +1 with each Attack skill upgrade or a new weapon)|
|[ 2 ] Magic | A random chance that the enemy will lose HP equal to the magic power of the player or no damage at all (damage can increase +2 with each Magic skill upgrade) |
|[ 3 ] Flee  | Player leaves enemy encounter, but the enemy remains on the map                                                                                               |

### Quit

If the journey ahead is too daunting, click the [ Q ] key followed by the [ ENTER ] key on the map screen to quit.

## Additional Information
### Downloading and Running

"Dungeons, Dungeons, and More Dungeons" can run on any environment or IDE with Java support in the command prompt, terminal, or console. Simply do the following:
1) Download all the files (including all .java, .class, and .txt files) from the root of the *DDandD* GitHub repository (`readme_assets` folder is not necessary) 
2) Open the command prompt, terminal, or console of your respective environment
3) Navigate to the directory containing all the *DDandD* files in the command prompt, terminal, or console
4) Run the `DDandD_Runner` program by entering `java DDandD_Runner` into the command prompt, terminal, or console
> NOTE: "Dungeons, Dungeons, and More Dungeons" is best experienced with a command prompt, terminal, or console that has **multi-line output** support. While single-line output still functions fine, the overall experience is not as snappy or seamless.

### Customizing Enemy and Weapon Varieties

"Dungeons, Dungeons, and More Dungeons" supports the ability for the pool of possible weapons and enemies to be customized by the player. Simply open the `Enemies.txt` and `Weapons.txt` files and add as many new enemies and weapons you'd like, or completely overhaul the preset options. The only stipulation is that **every seperate enemy and weapons must be on their own, separate line** in the .txt files.

### Known Bugs
- On occasion, skills obtained in a previous level will not transfer over to the next level
- A mis-input for the skills selection prompt will send the player back to the map screen without a skill upgrade
