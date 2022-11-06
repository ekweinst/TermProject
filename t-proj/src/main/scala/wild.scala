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
 * 4a. If gold, give random gold (1-100)
 * 4b. If trip, deal random damage (1-17)
 * 4c. If rest, heal random health (5-20)
 * 4d. If monster, follow from 5
 * 5. Generate either Goblin (60%) or Skeleton (40%)
 * 6. Battle the monster
 * 7. Player selects either attack or potion (20-30% health recovered)
 * 8a. If player selects attack, attack the monster first; get hit by monster
 * 8b. If player selects potion, heal the player for 20-30% of health
 * 9a. If player wins, recieve 5-30 gold, then follow from 10
 * 9b. If player dies, show "you lose" screen and exit the program
 * 10. Go back to 1
 **/

// def explore() =


// def backToTown() =

// mType = 1
def wildArrowMatch(arrow: Int) : Int =
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


def wild() =
    clearscr()
    println("Would you like to explore or go back to town?\n> Explore\n  Go back")
    var choice = menuStart(1)
    // if (choice == 0) {
    //     explore()
    // } else {
    //     backToTown()
    // }

