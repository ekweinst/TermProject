/**
 * Authors: Seb Favela, Matthew Maillet, Bryce Molner, Emily Weinstein
 * File: town.scala
 * Last Updated: 11.7.2022
 * Desc: Allows player to explore the town (heal, upgrade, or view stats)
 **/

import scala.io.StdIn.readLine

// mType = 5
/**
 * The inn menu
 * @param arrow, the option that the arrow points at
 * @return nextArrow, the option that the arrow points at
 */
def innArrowMatch(arrow: Int) : Int = {
	var nextArrow = arrow
	nextArrow match {
		case -1 =>
			nextArrow = 3
			clearscr()
			println("---------- Inn ----------\n  Sleep (Regain 100hp) - 5 coins\n  Purchase Beer (Regain 150hp) - 3 coins\n  Purchase Grub (Regain 50hp) - 10 coins\n> Leave inn")
		case 0 =>
			clearscr()
			println("---------- Inn ----------\n> Sleep (Regain 100hp) - 5 coins\n  Purchase Beer (Regain 150hp) - 3 coins\n  Purchase Grub (Regain 50hp) - 10 coins\n  Leave inn")
		case 1 =>
			clearscr()
			println("---------- Inn ----------\n  Sleep (Regain 100hp) - 5 coins\n> Purchase Beer (Regain 150hp) - 3 coins\n  Purchase Grub (Regain 50hp) - 10 coins\n  Leave inn")
		case 2 =>
			clearscr()
			println("---------- Inn ----------\n  Sleep (Regain 100hp) - 5 coins\n  Purchase Beer (Regain 150hp) - 3 coins\n> Purchase Grub (Regain 50hp) - 10 coins\n  Leave inn")
		case 3 =>
			clearscr()
			println("---------- Inn ----------\n  Sleep (Regain 100hp) - 5 coins\n  Purchase Beer (Regain 150hp) - 3 coins\n  Purchase Grub (Regain 50hp) - 10 coins\n> Leave inn")
		case 4 =>
			clearscr()
			println("---------- Inn ----------\n> Sleep (Regain 100hp) - 5 coins\n  Purchase Beer (Regain 150hp) - 3 coins\n  Purchase Grub (Regain 50hp) - 10 coins\n  Leave inn")
	}
	nextArrow
}

// mType = 4
/**
 * The shop menu
 * @param arrow, the option that the arrow points at
 * @return nextArrow, the option that the arrow points at
 */
def shopArrowMatch(arrow: Int) : Int = {
	var nextArrow = arrow
	nextArrow match {
		case -1 =>
			nextArrow = 6
			clearscr()
			println("---------- Shop ----------\n  Potion (+1) - 200 coins\n  Upgrade Max Armor (+5) - 300 coins\n  Upgrade Max Health (+3) - 500 coins\n  Upgrade Attack Damage (+1) - 200 coins\n  Full Upgrade - 1500 coins\n  Display stats\n> Leave shop")
		case 0 =>
			clearscr()
			println("---------- Shop ----------\n> Potion (+1) - 200 coins\n  Upgrade Max Armor (+5) - 300 coins\n  Upgrade Max Health (+3) - 500 coins\n  Upgrade Attack Damage (+1) - 200 coins\n  Full Upgrade - 1500 coins\n  Display stats\n  Leave shop")
		case 1 =>
			clearscr()
			println("---------- Shop ----------\n  Potion (+1) - 200 coins\n> Upgrade Max Armor (+5) - 300 coins\n  Upgrade Max Health (+3) - 500 coins\n  Upgrade Attack Damage (+1) - 200 coins\n  Full Upgrade - 1500 coins\n  Display stats\n  Leave shop")
		case 2 =>
			clearscr()
			println("---------- Shop ----------\n  Potion (+1) - 200 coins\n  Upgrade Max Armor (+5) - 300 coins\n> Upgrade Max Health (+3) - 500 coins\n  Upgrade Attack Damage (+1) - 200 coins\n  Full Upgrade - 1500 coins\n  Display stats\n  Leave shop")
		case 3 =>
			clearscr()
			println("---------- Shop ----------\n  Potion (+1) - 200 coins\n  Upgrade Max Armor (+5) - 300 coins\n  Upgrade Max Health (+3) - 500 coins\n> Upgrade Attack Damage (+1) - 200 coins\n  Full Upgrade - 1500 coins\n  Display stats\n  Leave shop")
		case 4 =>
			clearscr()
			println("---------- Shop ----------\n  Potion (+1) - 200 coins\n  Upgrade Max Armor (+5) - 300 coins\n  Upgrade Max Health (+3) - 500 coins\n  Upgrade Attack Damage (+1) - 200 coins\n> Full Upgrade - 1500 coins\n  Display stats\n  Leave shop")
		case 5 =>
			clearscr()
			println("---------- Shop ----------\n  Potion (+1) - 200 coins\n  Upgrade Max Armor (+5) - 300 coins\n  Upgrade Max Health (+3) - 500 coins\n  Upgrade Attack Damage (+1) - 200 coins\n  Full Upgrade - 1500 coins\n> Display stats\n  Leave shop")
		case 6 =>
			clearscr()
			println("---------- Shop ----------\n  Potion (+1) - 200 coins\n  Upgrade Max Armor (+5) - 300 coins\n  Upgrade Max Health (+3) - 500 coins\n  Upgrade Attack Damage (+1) - 200 coins\n  Full Upgrade - 1500 coins\n  Display stats\n> Leave shop")
		case 7 =>
			nextArrow = 0
			clearscr()
			println("---------- Shop ----------\n> Potion (+1) - 200 coins\n  Upgrade Max Armor (+5) - 300 coins\n  Upgrade Max Health (+3) - 500 coins\n  Upgrade Attack Damage (+1) - 200 coins\n  Full Upgrade - 1500 coins\n  Display stats\n  Leave shop")
	}
	nextArrow
}

// mType = 3
/**
 * The town menu
 * @param arrow, the option that the arrow points at
 * @return nextArrow, the option that the arrow points at
 */
def townArrowMatch(arrow: Int) : Int = {
	var nextArrow = arrow
	nextArrow match {
		case -1 =>
			nextArrow = 2
			clearscr()
			println("---------- Town ----------\n  Shop\n  Inn\n> Wild")
		case 0 =>
			clearscr()
			println("---------- Town ----------\n> Shop\n  Inn\n  Wild")
		case 1 =>
			clearscr()
			println("---------- Town ----------\n  Shop\n> Inn\n  Wild")
		case 2 =>
			clearscr()
			println("---------- Town ----------\n  Shop\n  Inn\n> Wild")
		case 3 =>
			nextArrow = 0
			clearscr()
			println("---------- Town ----------\n> Shop\n  Inn\n  Wild")
	}
	nextArrow
}

/**
 * Checks to see if you can purchase the shop's goods
 * @param shop_choice, the player's choice
 * @param character, the player's character
 * @return shop_choice, the player's choice
 */
def shop_purchase(shop_choice: Int, character: Player): Int = {
	// 200
	// 300
	// 500
	// 200
	// 1500
	var curr_coins = character.getCoins
	var curr_potions = character.getPotions
	var curr_max_health = character.getMaxHealth
	var curr_max_armor = character.getMaxArmor
	var curr_damage = character.getDamage

	if (shop_choice == 0) {
		clearscr()
		if (curr_coins >= 200) {
			println("You purchased one potion!")
			character.setPotions(curr_potions + 1)
			character.setCoins(curr_coins - 200)
		} else {
			println("You don't have enough money for a potion.")
		}
		readLine
	} else if (shop_choice == 1) {
		clearscr()
		if (curr_coins >= 300) {
			println("Max armor increased!")
			character.setMaxArmor(curr_max_armor + 5)
			character.setCoins(curr_coins - 300)
		} else {
			println("You don't have enough money to upgrade your armor.")
		}
		readLine
	} else if (shop_choice == 2) {
		clearscr()
		if (curr_coins >= 500) {
			println("Max health increase!")
			character.setMaxHealth(curr_max_health + 3)
			character.setCoins(curr_coins - 500)
		} else {
			println("You don't have enough money to upgrade your health.")
		}
		readLine
	} else if (shop_choice == 3) {
		clearscr()
		if (curr_coins >= 200) {
			println("Attack damage increased!")
			character.setDamage(curr_damage + 1)
			character.setCoins(curr_coins - 200)
		} else {
			println("You don't have enough money to upgrade your attack damage.")
		}
		readLine
	} else if (shop_choice == 4) {
		clearscr()
		if (curr_coins >= 1500) {
			println("Full upgrade!")
			println("Max armor increased!")
			println("Max health increased!")
			println("Attack damage increased!")
			character.setMaxArmor(curr_max_armor + 6)
			character.setMaxHealth(curr_max_health + 4)
			character.setDamage(curr_damage + 4)
			character.setPotions(curr_potions + 1)
			character.setCoins(curr_coins - 1500)
		} else {
			println("You don't have enough money to do a full upgrade.")
		}
		readLine
	} 
	else if (shop_choice == 5) {
		clearscr()
		println(s"Potions: $curr_potions")
		println(s"Max Armor: $curr_max_armor")
		println(character.getHealth + "/" + character.getMaxHealth)
		println(s"Damage: $curr_damage")
		println(s"Coins: $curr_coins")
		readLine
	} else if (shop_choice == 6) {
		clearscr()
		println("Leaving the shop . . .")
		readLine
	} 
	shop_choice
}

/**
 * Checks to see if you can purchase the inn's services
 * @param inn_choice, the selected inn service
 * @param character, the player's character
 * @return inn_choice, the player's choice
 */
def inn_purchase(inn_choice: Int, character: Player): Int = {
	var curr_coins = character.getCoins
	var curr_health = character.getHealth
	if (inn_choice == 0) {
		if (curr_coins >= 5) {
			character.setCoins(curr_coins - 5)
			sleep(character)
		} else {
			clearscr()
			println(s"Looks like you only have $curr_coins coins which isn't enough to sleep at my inn.")
			readLine
		}
	} else if(inn_choice == 1) {
		if (curr_coins >= 3) {
			character.setCoins(curr_coins - 3)
			drink_beer(character)
		} else {
			clearscr()
			println(s"Looks like you only have $curr_coins coins which isn't enough to drink beer here.")
			readLine
		}
	} else if(inn_choice == 2) {
		if (curr_coins >= 10) {
			character.setCoins(curr_coins - 10)
			eat_grub(character)
		} else {
			clearscr()
			println(s"Looks like you only have $curr_coins coins which isn't enough to eat here.")
			readLine
		}
	} else if (inn_choice == 3) {
		clearscr()
		println("Leaving the inn . . .")
		readLine
	}
	inn_choice
}

/**
 * Sleep for a night and restore middle health
 * @param character, the player's character
 */
def sleep(character: Player): Unit = {
	clearscr()
	println("Looks like you're getting sleepy there bud")
	Thread.sleep(1500)
	for (index <- 0 to 2) {
		clearscr()
		print("Z")
		Thread.sleep(800)
		print("z")
		Thread.sleep(800)
		print("z")
		Thread.sleep(800)
		print("z")
		Thread.sleep(800)
	}

	clearscr()
	println("You alright there? You passed out for a while!")
	var curr_health = character.getHealth
	var max_health = character.getMaxHealth
	if (curr_health == max_health) {
		println("It looks like you were already at full health so maybe you were drunk when you paid me.")
		println("No idea to be honest, just glad your alive.")
	} else {
		if (curr_health <= max_health - 100){
			character.setHealth(curr_health + 100)
			println("Good thing is that you recovered 100 health during that nap. Must have been good!")
		} else {
			character.setHealth(max_health)
			var added_health = max_health - curr_health
			println(s"Good thing is that you recovered $added_health health during that nap. Must have been good!")
		}
		println("Your new health is " + character.getHealth + "hp")
	}
	readLine
}

/**
 * Drink beer restore the most health
 * @param character, the player's character
 */
def drink_beer(character: Player): Unit = {
	clearscr()
	println("Well here you go bud, a pint of beer!")
	for (index <- 0 to 4) {
		print("glug ")
		Thread.sleep(400)
	}

	clearscr()
	var curr_health = character.getHealth
	var max_health = character.getMaxHealth
	if (curr_health == max_health) {
		println("It looks like you were already at full health.")
		println("At this point you're getting drunk just to get drunk.")
		println("Don't pass out on us.")
	} else {
		if (curr_health <= max_health - 150){
			character.setHealth(curr_health + 150)
		} else {
			character.setHealth(max_health)
			var added_health = max_health - curr_health
			println(s"You recovered $added_health health.")
		}
		println("Your new health is " + character.getHealth + "hp")
	}
	readLine
}

/**
 * Eat food restore the least health
 * @param character, the player's character
 */
def eat_grub(character: Player): Unit = {
	clearscr()
	println("Here's a sandwich!")
	for (index <- 0 to 4) {
		print("nom ")
		Thread.sleep(400)
	}

	clearscr()
	var curr_health = character.getHealth
	var max_health = character.getMaxHealth
	if (curr_health == max_health) {
		println("It looks like you were already at full health.")
		println("Guess you're just a hungry fellow.")
		println("Just dont puke it all up.")
	} else {

		if (curr_health <= max_health - 50){
			character.setHealth(curr_health + 50)
		} else {
			character.setHealth(max_health)
			var added_health = max_health - curr_health
			println(s"Good thing is that you recovered $added_health health.")
		}
		println("Your new health is " + character.getHealth + "hp")
	}
	readLine
}

/**
 * Simulates the inn menu
 * @param character, the player's character
 */
def inn(character: Player) : Unit = {
	var innCheck = true
	var choice = 0
	while (innCheck) {
		clearscr()
		println("---------- Inn ----------\n> Sleep (Regain 100hp) - 5 coins\n  Purchase Beer (Regain 150hp) - 3 coins\n  Purchase Grub (Regain 50hp) - 10 coins\n  Leave inn")
		choice = menuStart(5)
		if (inn_purchase(choice, character) == 3) {
			innCheck = false
		}
	}
}

/**
 * Simulates the shop menu
 * @param character, the player's character
 */
def shop(character: Player) : Unit = {
	var shopCheck = true
	var choice = 0
	while (shopCheck) {
		clearscr()
		println("---------- Shop ----------\n> Potion (+1) - 200 coins\n  Upgrade Max Armor (+5) - 300 coins\n  Upgrade Max Health (+3) - 500 coins\n  Upgrade Attack Damage (+1) - 200 coins\n  Full Upgrade - 1500 coins\n  Display stats\n  Leave shop")
		choice = menuStart(4)
		if (shop_purchase(choice, character) == 6) {
			shopCheck = false
		}
	}
}

/**
 * Simulates the town menu
 * @param character, the player's character
 */
def town(character: Player) : Unit = {
	var townCheck = true
	var choice = 0
	while (townCheck) {
		clearscr()
		println("---------- Town ----------\n> Shop\n  Inn\n  Wild")
		choice = menuStart(3)
		if (choice == 0) {
			// Shop
			shop(character)
		} else if (choice == 1) {
			// Inn
			inn(character)
		} else if (choice == 2) {
			// Wild
			townCheck = false
			wild(character)
		}
	}
}


