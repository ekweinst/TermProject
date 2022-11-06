/**
 * Authors: Seb Favela, Matthew Maillet, Bryce Molner, Emily Weinstein
 * File: player.scala
 * Last Updated: 11.5.2022
 * Desc:
 **/

 import scala.util.Random

/**
 * The player class that tracks the stats of the character
 * @param name, the player's name
 * @param health, the current health -- an integer
 * @param armor, the armor -- an integer
 * @param damage, the damage dealt by player -- an integer
 * @param level, the player's current level -- an integer
 * @param experience, the player's current xp -- an integer
 * @param coins, the money the player has access to -- an integer
 * */
class Player(name: String, var health: Int, var armor: Int, var damage: Int, var level: Int, var experiance: Int, var coins: Int):
	var max_health = health
	var max_armor = armor
	var all_potions = 0

	// A getter method for the player name
	def getName: String = name
	// A getter method for the player class
	def getClass: String = "Default Class"
	// A getter method for the player's current health
	def getHealth: Int = health
	// A setter method for the player's current health
	def setHealth(_health: Int): Unit =
	    health = _health
	// A getter method for the player's maximum health
	def getMaxHealth: Int = max_health
	// A setter method for the player's maximum health
	def setMaxHealth(_newHealth: Int): Unit =
	    max_health = _newHealth 
	// A getter method for the player's maximum armor
	def getMaxArmor: Int = max_armor
	// A setter method for the player's maximum armor
	def setMaxArmor(_newArmor: Int): Unit =
	    max_armor = _newArmor
	// A getter method for the player's current armor
	def getArmor: Int = armor
	// A setter method for the player's current armor
	def setArmor(_armor: Int): Unit =
	    armor = _armor
	// A getter method for the player's potions
	def getPotions: Int = all_potions
	// A setter method for the player's potions
	def setPotions(_potion: Int): Unit =
	    all_potions = _potion
	// A getter method for the player's damage
	def getDamage: Int = damage
	// A setter method for the player's damage
	def setDamage(_damage: Int): Unit =
	    damage = _damage
	// A getter method for the player's level
	def getLevel: Int = level
	// A getter method for the player's XP
	def getExperiance: Int = experiance
	// A setter method for the player's XP
	def setExperiance(_experiance: Int): Unit =
	    experiance = _experiance
	// A getter method for the player's money
	def getCoins: Int = coins
	// A setter method for the player's money
	def setCoins(_coins: Int): Unit =
	    coins = _coins
	// Check to see if the player has leveled up
	def willItLevelUp: Unit = {
	    if(getExperiance >= ((4 * getLevel)/5)) {
	    	setExperiance(getExperiance - ((4 * getLevel) / 5))
	    	levelUp
	    }
	}
    // Level up the player and update states
	def levelUp: Unit =
	    damage += 2
	    health += 5
	    armor += 1
	    level += 1
	    println("You leveled up! You now have: " + getDamage + " damage " + getHealth + " health and " +getArmor+" armor!")
  	// Updates player health and returns the lost health value
	def takeDamage(enemyDamage: Int): Int = {
		val lostHealth = (2 * enemyDamage/armor) + Random.nextInt((damage/10))
		if ((health - lostHealth) <= 0) { health = 0
		} else { health = health - lostHealth }
		lostHealth
	}
end Player

// CITE: https://www.geeksforgeeks.org/method-overriding-in-scala/
// DESC: How to override a method in a subclass

/**
 * Rogue is a subclass of Player with specific functionality to warrior types
 * @param name, the player's name
 * */ 
class Rogue(var name: String) extends Player(name, 100, 5, 25, 1, 0, 0):
  override def getClass: String = "Rogue"
end Rogue

/**
 * Wizard is a subclass of Player with specific functionality to warrior types
 * @param name, the player's name
 * */ 
class Wizard(var name: String) extends Player(name, 100, 10, 50, 1, 0, 0):
  override def getClass: String = "Wizard"
end Wizard

/**
 * Warrior is a subclass of Player with specific functionality to warrior types
 * @param name, the player's name
 * */ 
class Warrior(var name: String) extends Player(name, 150, 15, 100, 1, 0, 0):
  override def getClass: String = "Warrior"
end Warrior