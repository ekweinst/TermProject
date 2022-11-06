/**
 * Authors: Seb Favela, Matthew Maillet, Bryce Molner, Emily Weinstein
 * File: player.scala
 * Last Updated: 11.5.2022
 * Desc:
 **/

 import scala.util.Random

class Player(name: String, var charClass: String, var health: Int, var armor: Int, var damage: Int):
	def getName: String = name
	def getClass: String = charClass
	def getHealth: Int = health
	def setHealth(_health: Int): Unit = 
		health = _health
	def getArmor: Int = armor
	def setArmor(_armor: Int): Unit = 
		armor = _armor
	def takeDamage(enemyDamage: Int): Unit = 
		val lostHealth = (2 * enemyDamage/armor) + Random.nextInt((damage/10))
		if ((health - lostHealth) <= 0) {
			health = 0
		} else {
			health = health - lostHealth
		}
end Player

// CITE: https://www.geeksforgeeks.org/method-overriding-in-scala/
// DESC: How to override a method in a subclass
class Rogue(var name: String) extends Player(name, "Rogue", 80, 15, 60):

end Rogue

class Wizard(var name: String) extends Player(name, "Wizard", 100, 5, 100):
	
end Wizard

class Warrior(var name: String) extends Player(name, "Warrior", 150, 10, 50):
	
end Warrior