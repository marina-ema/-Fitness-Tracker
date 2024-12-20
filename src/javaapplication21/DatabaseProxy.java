/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication21;

import java.sql.Connection;

/**
 *
 * @author CS
 */
class DatabaseProxy implements SecureDatabaseAccess {
    @Override
   public Connection getDatabaseConnection() {
       
        
      
        if (!userHasPermission()) {
            throw new SecurityException("User does not have permission to access the database.");
        }

        return DatabaseConnection.getConnection();
    }

   
    private boolean userHasPermission() {
        
        return true;
    }
}
