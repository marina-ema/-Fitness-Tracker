package javaapplication21;

import javax.swing.*;
import java.awt.*;

public class ActivitySelectionForm extends JFrame {
    private JComboBox<String> activityCombo;  
    private JComboBox<String> goalCombo;      
    private JButton createPlanButton;         
    private JButton showAdviceButton;         
    public ActivitySelectionForm() {
        setTitle("Activity Selection");
        setSize(400, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        getContentPane().setBackground(new Color(173, 216, 230)); 

       
        activityCombo = new JComboBox<>(new String[]{"Cardio", "Strength", "Flexibility"});
        goalCombo = new JComboBox<>(new String[]{"Weight Loss", "Muscle Gain", "Endurance"}); 
        createPlanButton = new JButton("Create Nutrition Plan");
        showAdviceButton = new JButton("Show Activity Advice");

        
        createPlanButton.setBackground(new Color(135, 206, 250)); 
        showAdviceButton.setBackground(new Color(135, 206, 250)); 
        createPlanButton.setForeground(Color.BLACK); 
        showAdviceButton.setForeground(Color.BLACK); 

       
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Select Activity:"), gbc);

        gbc.gridx = 1;
        add(activityCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Select Goal:"), gbc);  

        gbc.gridx = 1;
        add(goalCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;  
        add(createPlanButton, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 2;  
        add(showAdviceButton, gbc);

        
        setVisible(true);

        
        createPlanButton.addActionListener(e -> {
            String selectedActivity = (String) activityCombo.getSelectedItem();  
            String goalType = (String) goalCombo.getSelectedItem(); 

           
            String mealPlan = getMealPlanForActivity(selectedActivity);
            int dailyCalories = getCaloriesForActivity(selectedActivity);

           
            NutritionPlan plan = new NutritionPlan.NutritionPlanBuilder()
                .setGoalType(goalType)  
                .setMealPlan(mealPlan) 
                .setDailyCalories(dailyCalories)  
                .build();

           
            JOptionPane.showMessageDialog(null, plan.getDetails(), "Nutrition Plan Details", JOptionPane.INFORMATION_MESSAGE);
        });

        
        showAdviceButton.addActionListener(e -> {
            String selectedActivity = (String) activityCombo.getSelectedItem();
            String goalType = (String) goalCombo.getSelectedItem();

           
            String mealPlan = getMealPlanForActivity(selectedActivity);
            int dailyCalories = getCaloriesForActivity(selectedActivity);

           
            PlanExporter nutritionPlanAdapter = new NutritionPlanAdapter(
                new NutritionPlan.NutritionPlanBuilder()
                    .setGoalType(goalType)
                    .setMealPlan(mealPlan)  
                    .setDailyCalories(dailyCalories)  
                    .build(),
                selectedActivity
            );

           
            JOptionPane.showMessageDialog(null, nutritionPlanAdapter.exportPlanDetails());
        });
    }

   
    private String getMealPlanForActivity(String activity) {
        switch (activity.toLowerCase()) {
            case "cardio":
                return "Low Carb, High Protein";
            case "strength":
                return "High Carb, High Protein";
            case "flexibility":
                return "Balanced Diet with Good Fiber";
            default:
                return "Standard Meal Plan";
        }
    }

    
    private int getCaloriesForActivity(String activity) {
        switch (activity.toLowerCase()) {
            case "cardio":
                return 2000; 
            case "strength":
                return 2500;
            case "flexibility":
                return 1800; 
            default:
                return 2000; 
        }
    }

   
    private String getAdviceForActivityAndGoal(String activity, String goal) {
     
        if (activity.equalsIgnoreCase("Cardio")) {
            if (goal.equalsIgnoreCase("Weight Loss")) {
                return "For Weight Loss, focus on high-intensity cardio exercises and a low-carb diet.";
            } else if (goal.equalsIgnoreCase("Muscle Gain")) {
                return "For Muscle Gain, include strength training along with cardio.";
            } else {
                return "For Endurance, try long-distance running or cycling with moderate cardio.";
            }
        } else if (activity.equalsIgnoreCase("Strength")) {
            if (goal.equalsIgnoreCase("Weight Loss")) {
                return "For Weight Loss, combine strength training with cardio.";
            } else if (goal.equalsIgnoreCase("Muscle Gain")) {
                return "For Muscle Gain, focus on heavy lifting with high-protein intake.";
            } else {
                return "For Endurance, incorporate strength training with lower weights and higher reps.";
            }
        } else if (activity.equalsIgnoreCase("Flexibility")) {
            if (goal.equalsIgnoreCase("Weight Loss")) {
                return "For Weight Loss, complement flexibility exercises with cardio.";
            } else if (goal.equalsIgnoreCase("Muscle Gain")) {
                return "For Muscle Gain, flexibility exercises can enhance mobility, improving your workouts.";
            } else {
                return "For Endurance, focus on yoga or Pilates for improved flexibility and recovery.";
            }
        }
        return "No advice available for the selected combination.";
    }
}
