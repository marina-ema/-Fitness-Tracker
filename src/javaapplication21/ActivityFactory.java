/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication21;

public class ActivityFactory {
  
    public static Activity createActivity(String type) {
         switch (type.toLowerCase()) {
        case "cardio":
            return new CardioActivity();
        case "strength":
            return new StrengthActivity();
        case "flexibility":
            return new FlexibilityActivity();
        default:
            return null;
    }
}
}
