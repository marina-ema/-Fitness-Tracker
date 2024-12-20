/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication21;

/**
 *
 * @author CS
 */

class NutritionPlanPrototype implements Cloneable {
    private String goalType;
    private String mealPlan;
    private int dailyCalories;

    public NutritionPlanPrototype(String goalType, String mealPlan, int dailyCalories) {
        this.goalType = goalType;
        this.mealPlan = mealPlan;
        this.dailyCalories = dailyCalories;
    }

   
    public NutritionPlanPrototype clone() {
        try {
            return (NutritionPlanPrototype) super.clone(); 
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getDetails() {
        return "Goal: " + goalType + "\nMeal Plan: " + mealPlan + "\nDaily Calories: " + dailyCalories;
    }
}

