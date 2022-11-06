/**
 * Authors: Seb Favela, Matthew Maillet, Bryce Molner, Emily Weinstein
 * File: group.scala (tentative)
 * Last Updated: 11.5.2022
 * Desc:
 **/

/**	README - IMPORTANT!!!! <-- <-- <-- <-- <-- <-- <-- <-- <--
 * 
 * How to call functions from other files:
 * compile: scalac group.scala monsters.scala
 * run: scala main
 * end: kaboom
 * 
 * Alternatively:
 * Use 'sbt' to compile and run the code
 * sbt will automatically compile everything in the main file
 */

import scala.io.StdIn.readLine
import jline.console.ConsoleReader

// mType = 0
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
 
def menuStart(mType: Int) : Int = {
	var reader = 0
	var arrow = 0
	var enter = false

	while (!enter) {
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
		}
	}
	arrow	
}

// This is the class selection function, runs classArrowMatch to change where the arrow points
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


//Clears the screen if your terminal is 24x80 dimensions or less
def clearscr() = {
	for (index <- 0 to 100)
		println()
}
		

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

def playGame(character: Player) = {
	println(s"Okay young ${character.getClass}. This will be an adventure of a lifetime.")
	Thread.sleep(3000)
	wild(character)

}

/**
 * The main function facillitates the operation of the program
 * 
 * */

@main def main = {
	clearscr()
	Thread.sleep(1000)
	var character = createChar
	playGame(character)
}


