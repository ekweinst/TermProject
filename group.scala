// Authors: Seb Favela, Matthew Maillet, Bryce Molnar, Emily Weinstein
// File: group.scala (tentative)

import scala.io.StdIn.readLine

/**
 * The main function facillitates the operation of the program
 * */
object main extends App {
  clearscr()
  var in_town = true
  var choice = ""
  var character = createChar
  clearscr()
  print(s"Okay young ${character.getClass}. Let's go into the town")
  Thread.sleep(650)
  for (rep <- 1 to 5) {
    print(".")
    Thread.sleep(650)
  }

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

/**
 * This function intakes a name and class choice from the player,
 * checking for appropriate inputs from the user
 * @param N/A
 * @return a player object of type Warrior, Wizard, or Rogue
 * */
def createChar: Player = {
  println("Hello there, young traveler. What might your name be?")
  var name = ""
  var validName = false
  while (!validName) {
    name = readLine()
    validName = true
    for (elem <- name) {
      val asciiVal = elem.toInt
      if (asciiVal < 65 || asciiVal > 122 || (asciiVal > 91 && asciiVal < 97)) {
        println("I highly doubt that's your name. Try again.")
        validName = false
      }
    }
  }
  clearscr()
  println(s"Hello $name!\n")
  Thread.sleep(650)
  println("You have stumbled into the beginning of quite the adventure. First, you must choose your class. Would you like to be a rogue, wizard, or warrior?")
  println("1) Rogue\n2) Wizard\n3) Warrior\n")
  var character = Player(name, 0, 0, 0, 0, 0, 0)
  var selectClass = true
  while (selectClass) {
    var charClass = readLine()
    // CITE: https://www.geeksforgeeks.org/scala-list-contains-method-with-example/
    // DESC: contains function and other string functionalities
    if (charClass.length == 1 && "123".contains(charClass)) { selectClass = false }
    if (charClass.equals("1")) { character = Rogue(name) }
    else if (charClass.equals("2")) { character = Wizard(name) }
    else if (charClass.equals("3")) { character = Warrior(name) }
    else { println("That's not an option, kid. Try again.") }
  }
  character
}

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
  def takeDamage(lostHealth: Int): Unit =
    // Matt how do you want armor to factor into this?
    damage = damage - lostHealth
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
  // A default attack method for the character
  def attack: Unit = println("Default attack")
end Player

// CITE: https://www.geeksforgeeks.org/method-overriding-in-scala/
// DESC: How to override a method in a subclass

/**
 * Rogue is a subclass of Player with specific functionality to warrior types
 * @param name, the player's name
 * */ 
class Rogue(var name: String) extends Player(name, 100, 5, 25, 1, 0, 0):
  override def attack: Unit = println("Rogue attacks!")
  override def getClass: String = "Rogue"
end Rogue

/**
 * Wizard is a subclass of Player with specific functionality to warrior types
 * @param name, the player's name
 * */ 
class Wizard(var name: String) extends Player(name, 100, 10, 50, 1, 0, 0):
  override def attack: Unit = println("Wizard attacks!")
  override def getClass: String = "Wizard"
end Wizard

/**
 * Warrior is a subclass of Player with specific functionality to warrior types
 * @param name, the player's name
 * */ 
class Warrior(var name: String) extends Player(name, 150, 15, 100, 1, 0, 0):
  override def attack: Unit = println("Warrior attacks!")
  override def getClass: String = "Warrior"
end Warrior