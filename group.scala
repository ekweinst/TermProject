// Authors: Seb Favela, Matthew Maillet, Bryce Molner, Emily Weinstein
// File: group.scala (tentative)

import scala.io.StdIn.readLine

object main extends App {
	println("This is the beginning of our group project. \n")
	Thread.sleep(500)
	println("Hello there, young traveller. What might your name be?")
	var name = readLine()
	println(s"Hello there, $name")
	println("You have stumbled into the beginning of quite the adventure. First, you must choose your class. Would you like to be a rogue, wizard, or warrior?")
	println("~~ for now, this is (1) for rogue, (2) for wizard, (3) for warrior\n")
	var charClass = readLine().toInt
	var character = createChar(charClass, name)
	println(s"Okay young ${character.getClass}.")
	// test attack function 
	character.attack
}

def createChar(charClass: Int, name: String): Player = {
	if (charClass == 1) { Rogue(name) }
	else if (charClass == 2) { Wizard(name) }
	else if (charClass == 3) { Warrior(name) }
	else { null }
}

class Player(name: String, var charClass: String, var health: Int, var armor: Int, var damage: Int):
	def getName: String = name
	def getClass: String = charClass
	def getHealth: Int = health
	def getArmor: Int = armor
	def getDamage: Int = damage
	def attack: Unit = println("Default attack")
end Player

// CITE: https://www.geeksforgeeks.org/method-overriding-in-scala/
// DESC: How to override a method in a subclass
class Rogue(var name: String) extends Player(name, "Rogue", 100, 5, 25):
	override def attack: Unit = println("Rogue attacks!")
end Rogue

class Wizard(var name: String) extends Player(name, "Wizard", 100, 10, 50):
	override def attack: Unit = println("Wizard attacks!")
end Wizard

class Warrior(var name: String) extends Player(name, "Warrior", 150, 15, 100):
	override def attack: Unit = println("Warrior attacks!")
end Warrior