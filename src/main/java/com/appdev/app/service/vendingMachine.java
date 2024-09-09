package com.appdev.app.service;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class vendingMachine {
    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Integer> prices = new HashMap<>();

    public vendingMachine() {
        // Initialize inventory and prices
        inventory.put("Soda", 5);
        inventory.put("Chips", 3);
        inventory.put("Candy", 2);

        prices.put("Soda", 150);  // in cents (1.50 USD)
        prices.put("Chips", 100); // in cents (1.00 USD)
        prices.put("Candy", 75);  // in cents (0.75 USD)
    }

    // Method to display items
    public void displayItems() {
        System.out.println("Available items:");
        for (String item : inventory.keySet()) {
            System.out.println(item + ": $" + (prices.get(item) / 100.0) + " (" + inventory.get(item) + " left)");
        }
    }

    // Method to process item selection and payment
    public void selectItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the item you want to buy: ");
        String item = scanner.nextLine();

        if (!inventory.containsKey(item) || inventory.get(item) <= 0) {
            System.out.println("Sorry, the item is unavailable.");
            return;
        }

        System.out.println("The price of " + item + " is $" + (prices.get(item) / 100.0));
        System.out.print("Please enter your money (in cents): ");
        int moneyInserted = scanner.nextInt();

        if (moneyInserted >= prices.get(item)) {
            int change = moneyInserted - prices.get(item);
            System.out.println("Thank you for your purchase! Here is your " + item);
            if (change > 0) {
                System.out.println("Your change is: " + change + " cents");
            }
            inventory.put(item, inventory.get(item) - 1); // Decrease inventory
        } else {
            System.out.println("Insufficient money. Please insert at least " + (prices.get(item) - moneyInserted) + " more cents.");
        }
    }

    public static void main(String[] args) {
        vendingMachine vm = new vendingMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            vm.displayItems();
            vm.selectItem();

            System.out.print("Would you like to buy another item? (yes/no): ");
            String continueBuying = scanner.next();
            if (!continueBuying.equalsIgnoreCase("yes")) {
                System.out.println("Thank you for using the vending machine!");
                break;
            }
        }
    }
}

