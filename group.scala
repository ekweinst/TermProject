// Authors: Seb Favela, Matthew Maillet, Bryce Molnar, Emily Weinstein
// File: group.scala (tentative)

import scala.io.StdIn.readLine

/**
 * The main function facillitates the operation of the program
 * 
 * */
object main extends App {
	println("This is the beginning of our group project.")
	Thread.sleep(1000)
	var character = createChar
	println(s"Okay young ${character.getClass}.")
	// test attack function
	character.attack
	character.levelUp
}

def createChar: Player = {
	println("Hello there, young traveller. What might your name be?")
	var name = readLine()
	println(s"Hello there, $name")
	println("You have stumbled into the beginning of quite the adventure. First, you must choose your class. Would you like to be a rogue, wizard, or warrior?")
	println("(1) for rogue, (2) for wizard, (3) for warrior\n")

	var character = Player(name, null, 0, 0, 0, 0, 0)

	var selectClass = true
	while (selectClass) {
		var charClass = readLine()
		if (charClass.equals("1")) { 
			character = Rogue(name)
			selectClass = false
		}
		else if (charClass.equals("2")) { 
			character = Wizard(name) 
			selectClass = false
		}
		else if (charClass.equals("3")) { 
			character = Warrior(name) 
			selectClass = false
		}
		else { println("That's not an option, kid. Try again.") }
	}
	character
}

class Player(name: String, var charClass: String, var health: Int, var armor: Int, var damage: Int, var level: Int, var experiance: Int):
	def getName: String = name
	def getClass: String = charClass
	def getHealth: Int = health
	def setHealth(_health: Int): Unit =
		health = _health
	def getArmor: Int = armor
	def setArmor(_armor: Int): Unit =
		armor = _armor
	def getDamage: Int = damage
	def takeDamage(lostHealth: Int): Unit =
		// Matt how do you want armor to factor into this?
		damage = damage - lostHealth
	def setDamage(_damage: Int): Unit =
		damage = _damage
	def getLevel: Int = level
	def getExperiance: Int = experiance
	def setExperiance(_experiance: Int): Unit =
		experiance = _experiance
	def willItLevelUp: Unit = {
		if(getExperiance >= ((4 * getLevel)/5)) {
			setExperiance(getExperiance - ((4 * getLevel) / 5))
			levelUp
		}
	}

	def levelUp: Unit =
		damage += 2
		health += 5
		armor += 1
		level += 1
		println("You leveled up! You now have: " + getDamage + " damage " + getHealth + " health and " +getArmor+" armor!")
	def attack: Unit = println("Default attack")
end Player

// CITE: https://www.geeksforgeeks.org/method-overriding-in-scala/
// DESC: How to override a method in a subclass
class Rogue(var name: String) extends Player(name, "Rogue", 100, 5, 25, 1, 0):
	override def attack: Unit = println("Rouge attacks!")
end Rogue

class Wizard(var name: String) extends Player(name, "Wizard", 100, 10, 50, 1, 0):
	override def attack: Unit = println("Wizard attacks!")
end Wizard

class Warrior(var name: String) extends Player(name, "Warrior", 150, 15, 100, 1, 0):
	override def attack: Unit = println("Warrior attacks!")
end Warrior

