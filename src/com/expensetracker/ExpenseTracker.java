package com.expensetracker;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    private ArrayList<Expense> expenses;
    private Scanner scanner;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Remove Expense");
            System.out.println("4. View Total Expenses");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    removeExpense();
                    break;
                case 4:
                    viewTotalExpenses();
                    break;
                case 5:
                    System.out.println("Exiting application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private void addExpense() {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Categories: ");
        ExpenseCategory.showCategories();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        expenses.add(new Expense(amount, category, date, description));
        System.out.println("Expense added successfully!");
    }

    private void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    private void removeExpense() {
        System.out.print("Enter expense index to remove: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            System.out.println("Expense removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private void viewTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        System.out.println("Total Expenses: " + total);
    }
}
