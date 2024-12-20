/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication21;

public class NutritionPlan {
    private String goalType;
    private String mealPlan;
    private int dailyCalories;

  
    private NutritionPlan(NutritionPlanBuilder builder) {
        this.goalType = builder.goalType;
        this.mealPlan = builder.mealPlan;
        this.dailyCalories = builder.dailyCalories;
    }

    public String getDetails() {
        return "Goal: " + goalType + "\nMeal Plan: " + mealPlan + "\nCalories: " + dailyCalories;
    }

    
    public static class NutritionPlanBuilder {
        private String goalType;
        private String mealPlan;
        private int dailyCalories;

        public NutritionPlanBuilder setGoalType(String goalType) {
            this.goalType = goalType;
            return this;
        }

        public NutritionPlanBuilder setMealPlan(String mealPlan) {
            this.mealPlan = mealPlan;
            return this;
        }

        public NutritionPlanBuilder setDailyCalories(int dailyCalories) {
            this.dailyCalories = dailyCalories;
            return this;
        }
        
      
        private String getMealPlanForActivity(String activityType) {
            switch (activityType.toLowerCase()) {
                case "cardio":
                    return "High Carbs, Low Fat, Moderate Protein";  
                case "strength":
                    return "High Protein, Moderate Carbs, Low Fat"; 
                case "flexibility":
                    return "Balanced Diet with Nutrient-Rich Foods";
                default:
                    return "Balanced Diet";  
            }
        } private int getCaloriesForActivity(String activityType) {
            switch (activityType.toLowerCase()) {
                case "cardio":
                    return 2000; 
                case "strength":
                    return 2500; 
                case "flexibility":
                    return 1800; 
                default:
                    return 2200;  
            }
        }


        public NutritionPlan build() {
            return new NutritionPlan(this);
        }
    }
}
