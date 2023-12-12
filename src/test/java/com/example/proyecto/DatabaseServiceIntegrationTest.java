package com.example.proyecto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE) 
@ActiveProfiles("test")
class DatabaseServiceIntegrationTest {
    @Autowired
    private DatabaseService databaseService;

    @Test
    void testGetAllProductsFromDatabase() {
        
        List<Nota> actualProducts = databaseService.getAllNotas();

        assertTrue(actualProducts.size() >= 2, "Expected at least 2 records in the database, but found: " + actualProducts.size());
    }
    @Test
    void testAuthenticateUserFromDatabase() {
        
        String username = "user1";
        String password = "password1";
        Usuario authenticatedUser = databaseService.authenticateUser(username, password);

        assertNotNull(authenticatedUser, "Authentication successful for user: " + username);
    }
    @Test
    void testFailedAuthenticateUserFromDatabase() {
        
        String username = "user2";
        String password = "password2";
        Usuario authenticatedUser = databaseService.authenticateUser(username, password);

        assertNull(authenticatedUser, "Authentication failed for user: " + username);
    }

}
