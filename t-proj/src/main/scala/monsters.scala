/**
 * Authors: Seb Favela, Matthew Maillet, Bryce Molner, Emily Weinstein
 * File: monsters.scala
 * Last Updated: 11.5.2022
 * Desc: Monster classes
 **/
 
import scala.util.Random

class Monster(var health: Int, var armor: Int, var damage: Int):
	def getHealth: Int = health
	def setHealth(_health: Int): Unit = 
		health = _health
	def getArmor: Int = armor
	def setArmor(_armor: Int): Unit = 
		armor = _armor
	def getDamage: Int = damage
	def takeDamage(enemyDamage: Int): Unit = 
		val lostHealth = (2 * enemyDamage/armor) + Random.nextInt((damage/10))
		if ((health - lostHealth) <= 0) {
			health = 0
		} else {
			health = health - lostHealth
		}
end Monster

class Goblin() extends Monster(45, 10, 60)
	
end Goblin

class Skeleton() extends Monster(60, 4, 80)

end Skeleton