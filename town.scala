// Authors: Seb Favela, Matthew Maillet, Bryce Molnar, Emily Weinstein
// File: town.scala (tentative)

import scala.io.StdIn.readLine

def clearscr(): Unit = {
	for (index <- 0 to 100) 
		println()
}



def shop_purchase(shop_choice: String, character: Player): Boolean = {
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

	if (shop_choice == "1") {
		clearscr()
		if (curr_coins >= 200) {
			println("You purchased one potion!")
			character.setPotions(curr_potions + 1)
			character.setCoins(curr_coins - 200)
		} else {
			println("You don't have enough money for a potion.")
		}
		readLine
		return true
	} else if (shop_choice == "2") {
		clearscr()
		if (curr_coins >= 300) {
			println("Max armor increased!")
			character.setMaxArmor(curr_max_armor + 5)
			character.setCoins(curr_coins - 300)
		} else {
			println("You don't have enough money to upgrade your armor.")
		}
		readLine
		return true
	} else if (shop_choice == "3") {
		clearscr()
		if (curr_coins >= 500) {
			println("Max health increase!")
			character.setMaxHealth(curr_max_health + 3)
			character.setCoins(curr_coins - 500)
		} else {
			println("You don't have enough money to upgrade your health.")
		}
		readLine
		return true
	} else if (shop_choice == "4") {
		clearscr()
		if (curr_coins >= 200) {
			println("Attack damage increased!")
			character.setDamage(curr_damage + 1)
			character.setCoins(curr_coins - 200)
		} else {
			println("You don't have enough money to upgrade your attack damage.")
		}
		readLine
		return true
	} else if (shop_choice == "5") {
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
		return true
	} else if (shop_choice == "6") {
		clearscr()
		println("Leaving the shop...")
		readLine
		return false
	} else if (shop_choice == "7") {
		clearscr()
		println(s"Potions: $curr_potions")
		println(s"Max Armor: $curr_max_armor")
		println(s"Max Health: $curr_max_health")
		println(s"Damage: $curr_damage")
		println(s"Coins: $curr_coins")
		readLine
		return true
	} else {
		return true
	}
}

def shop_menu(character: Player): Unit = {
	var choice = ""
	var in_shop = true
	while (in_shop)
		clearscr()
		println("---------- Shop ----------")
		println(" 1) Potion (+1) - 200 coins")
		println(" 2) Upgrade Max Armor (+5) - 300 coins")
		println(" 3) Upgrade Max Health (+3) - 500 coins")
		println(" 4) Upgrade Attack Damage (+1) - 200 coins")
		println(" 5) Full Upgrade - 1500 coins")
		println(" 6) Leave Shop")
		print("What would you like to do here at our fine establishment: ")
		choice = readLine
		in_shop = shop_purchase(choice, character)
}

def inn_purchase(inn_choice: String, character: Player): Boolean = {
	var curr_coins = character.getCoins
	var curr_health = character.getHealth
	if (inn_choice == "1") {
		if (curr_coins >= 5) {
			character.setCoins(curr_coins - 5)
			sleep(character)
		} else {
			clearscr()
			println(s"Looks like you only have $curr_coins coins which isn't enough to sleep at my inn.")
			readLine
			return true
		}
	} else if(inn_choice == "2") {
		if (curr_coins >= 3) {
			character.setCoins(curr_coins - 3)
			drink_beer(character)
		} else {
			clearscr()
			println(s"Looks like you only have $curr_coins coins which isn't enough to drink beer here.")
			readLine
			return true
		}
	} else if(inn_choice == "3") {
		if (curr_coins >= 10) {
			character.setCoins(curr_coins - 10)
			eat_grub(character)
		} else {
			clearscr()
			println(s"Looks like you only have $curr_coins coins which isn't enough to eat here.")
			readLine
			return true
		}
	} else if (inn_choice == "4") {
		return false
	}
	 else {
		return true
	}
}

def sleep(character: Player): Boolean = {
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
	return true
}

def drink_beer(character: Player): Boolean = {
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
	return true
}

def eat_grub(character: Player): Boolean = {
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
	return true

}

def inn_menu(character: Player): Unit = {
	var choice = ""
	var in_shop = true
	while (in_shop)
		clearscr()
		println("---------- Inn ----------")
		println(" 1) Sleep (Regain 100hp) - 5 coins")
		println(" 2) Purchase Beer (Regain 150hp) - 3 coins")
		println(" 3) Purchase Grub (Regain 50hp) - 10 coins")
		println(" 4) Leave inn")
		print("What would you like to do here at our fine establishment: ")
		choice = readLine
		in_shop = inn_purchase(choice, character)
}

def leaving_town(): Boolean = {
	clearscr()
	println("You're about to leave our homie town and lose all progress.")
	println("Are you sure you want to do that?")
	print("(Y/N): ")
	var leaving = readLine()

	if (leaving == "Y" || leaving == "y") {
		clearscr()
		println("We're sorry to see you go! See you later!")
		readLine
		return false
	} else if (leaving == "N" || leaving == "n") {
		clearscr()
		println("Glad you decided to stay!")
		readLine
		return true
	} else {
		clearscr()
		println("I'm not sure what you thought I asked but I'm going to assume you're staying in town...")
		readLine
		return true
	}
}

def enter(town_location: String, character: Player): Boolean = {
	if (town_location == "1") {
		shop_menu(character)
		return true
	} else if (town_location == "2") {
		inn_menu(character)
		return true
	} else if (town_location == "3") {
		return leaving_town()
	} else {
		clearscr()
		println("Im sorry, the only choices you have are the shop or the inn.")
		println("So pick one!!!")
		readLine
		return true
	}
}