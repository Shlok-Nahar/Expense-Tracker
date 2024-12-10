package com.expensetracker;


public class ExpenseCategory {
    
    private ExpenseCategory() {
        throw new IllegalStateException("Utility class");
    }

    private static final String[] CATEGORIES = {
        "EDUCATION", 
        "LIVING", 
        "PERSONAL",
        "MISC"
    };

    public static void showCategories() {
        for (String category : ExpenseCategory.CATEGORIES) {
            System.out.println(category);
        }
    }
    
}

