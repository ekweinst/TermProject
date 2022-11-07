/**
 * Authors: Seb Favela, Matthew Maillet, Bryce Molner, Emily Weinstein
 * File: monsters.scala
 * Last Updated: 11.7.2022
 * Desc: Monster classes
 **/
 
import scala.util.Random

/**
 * The monster class that tracks the stats of the character
 * @param health, the current health -- an integer
 * @param armor, the armor -- an integer
 * @param damage, the damage dealt by monster -- an integer
 */
class Monster(var health: Int, var armor: Int, var damage: Int):
	def getHealth: Int = health
	def setHealth(_health: Int): Unit = 
		health = _health
	def getArmor: Int = armor
	def setArmor(_armor: Int): Unit = 
		armor = _armor
	def getDamage: Int = damage
	def takeDamage(enemyDamage: Int): Int = {
		val lostHealth = (2 * enemyDamage/armor) + Random.nextInt((enemyDamage/10))
		if ((health - lostHealth) <= 0) {
			health = 0
		} else {
			health = health - lostHealth
		}
		lostHealth
	}
end Monster

/** 
 * The goblin class, creates a default goblin
 * The base stats of the monster generation are added by 0-2.5 per level that the user is to scale monsters with the user
 */
class Goblin(val level: Int) extends Monster((45 + (Random.between(1,2500)/1000) * level), (10 + (Random.between(1,2) * level)), (60 + Random.between(1,4) * level)):
end Goblin

/**
 * The skeleton class, creates a default skeleton
 * The base stats of the monster generation are added by 0-2.5 per level that the user is to scale monsters with the user
 */
class Skeleton(val level: Int) extends Monster((60 + (Random.between(1,2500)/1000) * level), (4 + (Random.between(1,2) * level)), (80 + Random.between(1,4) * level)):
end Skeleton