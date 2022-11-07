/**
 * Authors: Seb Favela, Matthew Maillet, Bryce Molner, Emily Weinstein
 * File: wild.scala
 * Last Updated: 11.7.2022
 * Desc: See lines 12-29
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
 * 7. Player selects either attack or potion (50 health recovered)
 * 8a. If player selects attack, attack the monster first; get hit by monster
 * 8b. If player selects potion, heal the player for 20-30% of health
 * 9a. If player wins, recieve 5-30 gold, then follow from 10
 * 9b. If player dies, show "you lose" screen and exit the program
 * 10. Go back to 1
 **/

// mType = 1
/**
 * The wild menu
 * @param arrow, the option that the arrow points at
 * @return nextArrow, the option that the arrow points at
 */
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

// mType = 2
/**
 * The battle menu
 * @param arrow, the option that the arrow points at
 * @return nextArrow, the option that the arrow points at
 */
def battleArrowMatch(arrow: Int) : Int = {
    var nextArrow = arrow
    nextArrow match {
        case -1 => 
            nextArrow = 2
            clearscr()
            println("Battle options:\n  Attack\n> Potion")
        case 0 =>
            clearscr()
            println("Battle options:\n> Attack\n  Potion")
        case 1 =>
            clearscr()
            println("Battle options:\n  Attack\n> Potion")
        case 2 =>
            nextArrow = 0
            clearscr()
            println("Battle options:\n> Attack\n  Potion")
    }
    nextArrow
}

/**
 * Print the player's current health
 * @param character, the player's character
 */
def printCurrentHealth(character: Player) : Unit = {
    println("You have " + character.getHealth + "/" + character.getMaxHealth + " health remaining")
}

/**
 * Simulates the battle menu
 * @param character, the player's character
 * @param monster, the random monster to encounter
 * @return dead, whether the player is alive or not
 */
def battle(character: Player, monster: Monster) : Boolean = {
    var dead = false
    var choice = 0
    var monsterDead = false
    while(!dead && !monsterDead) {
        println("Battle options:\n> Attack\n  Potion")
        choice = menuStart(2)
        if (choice == 0) {
            clearscr()
            println("You dealt " + monster.takeDamage(character.getDamage) + " damage!")
            Thread.sleep(1500)
            if (monster.getHealth <= 0) {
                clearscr()
                println("You won!")
                Thread.sleep(1500)
                println("You got " + character.addCoins(Random.nextInt(50) + 5) + " coins!")
                var experianceGained = character.getLevel * 5
                println("You gained " + experianceGained + " experiance!")
                character.setExperience(character.getExperience + experianceGained)
                character.willItLevelUp
                Thread.sleep(5000)
                monsterDead = true
            } else {
                println("You took " + character.takeDamage(monster.getDamage) + " damage!")
                Thread.sleep(1500)
                printCurrentHealth(character)
                if (character.getHealth <= 0) {
                    dead = true
                }
            }
            
        } else if (choice == 1) {
            if (character.getPotions >= 1) {
                clearscr()
                println("You recovered " + character.usePotion + " health!")
                printCurrentHealth(character)
            } else {
                clearscr()
                println("You do not have any potions.")
            }
        }
    }
    dead
}

/**
 * Random chance to get coins, trip over a rock, rest, or encounter a monster
 * @param character, the player's character
 */
def explore(character: Player) : Boolean = {
    var dead = false
    var walkChance = Random.nextInt(100)
    var randMonster = Random.nextInt(100)
    if (walkChance <= 5) {
        clearscr()
        val randCoins = Random.nextInt(100) + 3
        println("You found " + randCoins + " coins!")
        character.addCoins(randCoins)
        Thread.sleep(2000)
    } else if (walkChance <= 20) {
        clearscr()
        println("You tripped over a rock!")
        character.takeDamage(Random.nextInt(34))
        printCurrentHealth(character)
        Thread.sleep(2000)
    } else if (walkChance <= 50) {
        clearscr()
        var randHeal = Random.nextInt(33) + 11
        println("You took a rest and got healed!")
        if (randHeal + character.getHealth >= character.getMaxHealth) {
            character.setHealth(character.getMaxHealth)
        } else {
            character.setHealth(character.getHealth + randHeal)
        }
        printCurrentHealth(character)
        Thread.sleep(2000)
    } else if (walkChance <= 100) {
        clearscr()
        if (randMonster <= 40) {
            println("You encountered a skeleton!")
            Thread.sleep(2000)
            var skeleton = Skeleton(character.getLevel)
            dead = battle(character, skeleton)
        } else {
            println("You encountered a goblin!")
            Thread.sleep(2000)
            var goblin = Goblin(character.getLevel)
            dead = battle(character, goblin)
        }
    }
    dead
}

/**
 * Simulates the wild menu
 * @param character, the player's character
 */
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
            town(character)
            wildCheck = false
        }
        if (dead) {
            println("You died. Better luck next time!")
            wildCheck = false
        }
    }

