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

class NutritionPlanAdapter implements PlanExporter {
    private final NutritionPlan nutritionPlan;
    private final String activityType;

    public NutritionPlanAdapter(NutritionPlan nutritionPlan, String activityType) {
        this.nutritionPlan = nutritionPlan;
        this.activityType = activityType;
    }

    @Override
    public String exportPlanDetails() {
        return "Exporting Plan Details:\n" 
                + nutritionPlan.getDetails() 
                + "\nAdvice: " + getActivityAdvice();
    }

   
    public String getActivityAdvice() {
        switch (activityType.toLowerCase()) {
            case "cardio":
                return "Stay hydrated and include slow-digesting carbs.";
            case "strength":
                return "Focus on high-protein meals for muscle recovery.";
            case "flexibility":
                return "Eat light meals and stay flexible with nutrient-rich food.";
            default:
                return "Maintain a balanced diet for overall fitness.";
        }
    }
}