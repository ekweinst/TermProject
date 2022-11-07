/**
 * Authors: Seb Favela, Matthew Maillet, Bryce Molner, Emily Weinstein
 * File: wild.scala
 * Last Updated: 11.5.2022
 * Desc:
 **/

import scala.io.StdIn.readLine
import jline.console.ConsoleReader
import scala.util.Random

/**
 * 1. Ask if the player wants to explore or go back to the town
 * 2a. If explore, then follow from 3
 * 2b. If go back to town, then send the player back to the town.
 * 3. Have them generate:
 * 4a. If gold, give random gold (1-100)  [5%]
 * 4b. If trip, deal random damage (1-34) [15%]
 * 4c. If rest, heal random health (5-20) [30%]
 * 4d. If monster, follow from 5          [50%]
 * 5. Generate either Goblin (60%) or Skeleton (40%)
 * 6. Battle the monster
 * 7. Player selects either attack or potion (20-30% health recovered)
 * 8a. If player selects attack, attack the monster first; get hit by monster
 * 8b. If player selects potion, heal the player for 20-30% of health
 * 9a. If player wins, recieve 5-30 gold, then follow from 10
 * 9b. If player dies, show "you lose" screen and exit the program
 * 10. Go back to 1
 **/

// mType = 2
// def battleArrowMatch(arrow: Int) : Int = {
//     var nextArrow = arrow
//     arrow match {
        
//     }
// }

def battle(character: Player, monster: Monster) : Boolean = {
    var dead = false

    dead
}

def explore(character: Player) : Boolean = {
    var dead = false
    var walkChance = Random.nextInt(100)
    var randMonster = Random.nextInt(100)
    if (walkChance <= 5) {
        clearscr()
        println("You found gold!")
        Thread.sleep(2000)
    } else if (walkChance <= 20) {
        clearscr()
        println("You tripped over a rock!")
        character.takeDamage(Random.nextInt(34))
        Thread.sleep(2000)
    } else if (walkChance <= 50) {
        clearscr()
        println("You took a rest and got healed!")
        Thread.sleep(2000)
    } else if (walkChance <= 100) {
        clearscr()
        if (randMonster <= 40) {
            println("You encountered a skeleton!")
            Thread.sleep(2000)
            var skeleton = Skeleton()
            dead = battle(character, skeleton)
        } else {
            println("You encountered a goblin!")
            Thread.sleep(2000)
            var goblin = Goblin()
            dead = battle(character, goblin)
        }
    }
    dead
}
// def backToTown() =

// mType = 1
def wildArrowMatch(arrow: Int) : Int = {
    var nextArrow = arrow
    arrow match {
        case -1 => 
            nextArrow = 1
            clearscr()
            println("Would you like to explore or go back to town?\n  Explore\n> Go back")
        case 0 =>
            nextArrow = 0
            clearscr()
            println("Would you like to explore or go back to town?\n> Explore\n  Go back")
        case 1 =>
            nextArrow = 1
            clearscr()
            println("Would you like to explore or go back to town?\n  Explore\n> Go back")
        case 2 =>   
            nextArrow = 0
            clearscr()
            println("Would you like to explore or go back to town?\n> Explore\n  Go back")
    }
    nextArrow
}

def wild(character: Player) =
    var choice = 0
    var wildCheck = true
    var dead = false
    while (wildCheck) {
        clearscr()
        println("Would you like to explore or go back to town?\n> Explore\n  Go back")
        choice = menuStart(1)
        if (choice == 0) {
            dead = explore(character)
        } else if (!dead) {
            // backToTown()
            wildCheck = false
        } else if (dead) {
            println("You died. Better luck next time!")
            wildCheck = false
        }
    }

