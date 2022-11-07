/**
 * Authors: Seb Favela, Matthew Maillet, Bryce Molner, Emily Weinstein
 * File: Main.scala
 * Last Updated: 11.7.2022
 * Desc: Controls the introduction of the game and the functionality of the rest
 **/

/**	README - IMPORTANT!!!! <-- <-- <-- <-- <-- <-- <-- <-- <--
 * How to compile and run this code:
 * 1. Navigate to the t-proj directory in your terminal
 * 2. Run the command 'sbt' in your terminal
 * 3. Run the command 'compile' in your terminal
 * 4. Run the command 'run' in your terminal
 * 5. Play the game :)
 */

import scala.io.StdIn.readLine
import jline.console.ConsoleReader

// mType = 0
/**
 * The class menu
 * @param arrow, the option that the arrow points at
 * @return nextArrow, the option that the arrow points at
 */
def classArrowMatch(arrow: Int) : Int = {
	var nextArrow = arrow
	nextArrow match {
		case -1 =>
			nextArrow = 2
			clearscr()
			println("Choose your class: (Use 'W' and 'S' to move, 'Enter' to select) \n  Rogue \n  Warrior \n> Wizard")
		case 0 =>
			clearscr()
			println("Choose your class: (Use 'W' and 'S' to move, 'Enter' to select) \n> Rogue \n  Warrior \n  Wizard")
		case 1 =>
			clearscr()
			println("Choose your class: (Use 'W' and 'S' to move, 'Enter' to select) \n  Rogue \n> Warrior \n  Wizard")
		case 2 =>
			clearscr()	
			println("Choose your class: (Use 'W' and 'S' to move, 'Enter' to select) \n  Rogue \n  Warrior \n> Wizard")
		case 3 =>
			nextArrow = 0
			clearscr()
			println("Choose your class: (Use 'W' and 'S' to move, 'Enter' to select) \n> Rogue \n  Warrior \n  Wizard")
	}
	nextArrow
}

/**
 * Dependent on the mType (a programmer-defined parameter), creates the menu to cycle through
 * @param mType, the menu type that menuStart will operate on
 * @return arrow, the option that the arrow points at
 */
def menuStart(mType: Int) : Int = {
	var reader = 0
	var arrow = 0
	var enter = false

	while (!enter) {
		// CITE: https://jline.github.io/jline2/apidocs/reference/jline/console/ConsoleReader.html
		// HOW: How to read a single character input
		reader = ConsoleReader().readCharacter()
		if (reader == 119) { 			// W key
			arrow -= 1
		} else if (reader == 115) {		// S key
			arrow += 1
		} else if (reader == 13) {		// Enter key
			enter = true
		}
		// Will choose the menu type (sequence of choices)
		// based on an assigned number
		mType match {
			case 0 => arrow = classArrowMatch(arrow)
			case 1 => arrow = wildArrowMatch(arrow)
			case 2 => arrow = battleArrowMatch(arrow)
			case 3 => arrow = townArrowMatch(arrow)
			case 4 => arrow = shopArrowMatch(arrow)
			case 5 => arrow = innArrowMatch(arrow)
		}
	}
	arrow	
}

// This is the class selection function, runs classArrowMatch to change where the arrow points
/**
 * Class selection to open up the class menu
 * @param name, the name of the player
 * @return character, the player's completed character
 */
def classSelect(name: String) : Player = {
	var character = Player(name, 0, 0, 0, 0, 0, 0)

	clearscr() 
	println("Choose your class: (Use 'W' and 'S' to move, 'Enter' to select) \n> Rogue \n  Warrior \n  Wizard")

	val select = menuStart(0)
	if (select == 0) {
		character = Rogue(name)
	} else if (select == 1) {
		character = Warrior(name)
	} else if (select == 2) {
		character = Wizard(name)
	}
	character
}

/**
 * Clears the screen. That's literally it.
 */
def clearscr() = {
	for (index <- 0 to 100)
		println()
}
		
/**
 * Creates the player's character
 * @return character, the player's completed character
 */
def createChar: Player = {
	var validName = false
	var name = ""
	while (!validName) {
		clearscr() 
		println("Hello there, young traveler. What might your name be?")
		name = readLine()
		validName = true
		for (elem <- name) {
			val asciiVal = elem.toInt
			if (asciiVal < 32 || (asciiVal > 32 && asciiVal < 65) || asciiVal > 122 || (asciiVal > 91 && asciiVal < 97)) { validName = false }
		}
		if (!validName) {
			println("I highly doubt that's your name. Let's try that again.")
			Thread.sleep(1500)
		}
	}
	println(s"Hello, $name.")
	println("You have stumbled into the beginning of quite the adventure.")
	Thread.sleep(1500)
	println("First, you must choose your class.")
	Thread.sleep(3000)

	clearscr()

	var character = classSelect(name)
	character
}

/**
 * Starts the game after creating a character
 * @param character, the player's playable character
 */
def playGame(character: Player) = {
	clearscr()
	println(s"Okay young ${character.getClass}. This will be an adventure of a lifetime.")
	Thread.sleep(1500)
	println("Awaking from your slumber at the town . . .")
	Thread.sleep(3000)
	town(character)
}

/**
 * The main function facillitates the operation of the program
 * */
@main def main = {
	clearscr()
	Thread.sleep(1000)
	var character = createChar
	playGame(character)
}


