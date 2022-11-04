// Authors: Seb Favela, Matthe Maillet, Bryce Molner, Emily Weinstein
// File: group.scala (tentative)

import scala.io.StdIn.readLine

object main extends App {
	println("This is the beginning of our group project. \n")
	println("Character name: ")
	var input = readLine()
	var character = Player(input)
	println(s"Hello there, ${character.getName}")
}

class Player(var name: String):
// We can add stats to the constructor up here ^^
	def getName: String = name
end Player