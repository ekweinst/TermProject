// Authors: Seb Favela, Matthew Maillet, Bryce Molnar, Emily Weinstein
// File: group.scala (tentative)

import scala.io.StdIn.readLine

/**
 * The main function facillitates the operation of the program
 * 
 * */
object main extends App {
  clearscr()
  var in_town = true
  var choice = ""
  var character = createChar
  clearscr()
  print(s"Okay young ${character.getClass}. Let's go into the town")
  Thread.sleep(650)
  print(".")
  Thread.sleep(650)
  print(".")
  Thread.sleep(650)
  print(".")
  Thread.sleep(650)
  print(".")
  Thread.sleep(650)
  print(".")
  Thread.sleep(650)

  character.setCoins(10000)

  while (in_town) {
    clearscr()
    println("---------- Town ----------")
    println(" 1) Shop")
    println(" 2) Inn")
    println(" 3) Leave Town")
    print("Select the place you would like to go: ")
    choice = readLine
    in_town = enter(choice, character)
  }
  clearscr()
}

def createChar: Player = {
  println("Hello there, young traveler. What might your name be?")
  var name = readLine()
  println(s"Hello there, $name")
  println("You have stumbled into the beginning of quite the adventure. First, you must choose your class. Would you like to be a rogue, wizard, or warrior?")
  println("(1) for rogue, (2) for wizard, (3) for warrior\n")

  var character = Player(name, null, 0, 0, 0, 0, 0, 0)

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

class Player(name: String, var charClass: String, var health: Int, var armor: Int, var damage: Int, var level: Int, var experiance: Int, var coins: Int):
  var max_health = health
  var max_armor = armor
  var all_potions = 0

  def getName: String = name
  def getClass: String = charClass
  def getHealth: Int = health
  def setHealth(_health: Int): Unit =
    health = _health
  def getMaxHealth: Int = max_health
  def setMaxHealth(_newHealth: Int): Unit =
    max_health = _newHealth 
  def getMaxArmor: Int = max_armor
  def setMaxArmor(_newArmor: Int): Unit =
    max_armor = _newArmor
  def getArmor: Int = armor
  def setArmor(_armor: Int): Unit =
    armor = _armor
  def getPotions: Int = all_potions
  def setPotions(_potion: Int): Unit =
    all_potions = _potion
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
  def getCoins: Int = coins
  def setCoins(_coins: Int): Unit =
    coins = _coins
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
class Rogue(var name: String) extends Player(name, "Rogue", 100, 5, 25, 1, 0, 0):
  override def attack: Unit = println("Rouge attacks!")
end Rogue

class Wizard(var name: String) extends Player(name, "Wizard", 100, 10, 50, 1, 0, 0):
  override def attack: Unit = println("Wizard attacks!")
end Wizard

class Warrior(var name: String) extends Player(name, "Warrior", 150, 15, 100, 1, 0, 0):
  override def attack: Unit = println("Warrior attacks!")
end Warrior





































