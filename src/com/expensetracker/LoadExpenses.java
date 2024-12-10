package com.expensetracker;

import java.io.*;
import java.util.*;

public class LoadExpenses {

    private static final String FILE_PATH = "resources/expenses.txt";

    public void loadExpenses(List<Expense> expenses) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    double amount = Double.parseDouble(parts[0].trim());
                    String category = parts[1].trim();
                    String date = parts[2].trim();
                    String description = parts[3].trim();
                    expenses.add(new Expense(amount, category, date, description));
                }
            }
            System.out.println("Expenses loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format in expenses file: " + e.getMessage());
        }
    }

    public void saveExpenses(List<Expense> expenses) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Expense expense : expenses) {
                bw.write(expense.getAmount() + "," +
                         expense.getCategory() + "," +
                         expense.getDate() + "," +
                         expense.getDescription());
                bw.newLine();
            }
            System.out.println("Expenses saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }
}
