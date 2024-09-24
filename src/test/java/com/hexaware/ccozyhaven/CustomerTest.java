package com.hexaware.ccozyhaven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.hexaware.cozyhaven.model.Customer;

public class CustomerTest {

    @Test
    public void testGettersAndSetters() {
        // Create a new Customer object using the default constructor
        Customer customer = new Customer();

        // Set values using setters
        customer.setCustomerid(1);
        customer.setFirstname("Arjun");
        customer.setLastname("Sharma");
        customer.setEmail("arjun.sharma@gmail.com");
        customer.setPhone(9876543210L);
        customer.setGender("Male");
        customer.setCity("Mumbai");
        customer.setState("Maharashtra");

        // Assert that the getters return the correct values
        assertEquals(1, customer.getCustomerid());
        assertEquals("Arjun", customer.getFirstname());
        assertEquals("Sharma", customer.getLastname());
        assertEquals("arjun.sharma@gmail.com", customer.getEmail());
        assertEquals(9876543210L, customer.getPhone());
        assertEquals("Male", customer.getGender());
        assertEquals("Mumbai", customer.getCity());
        assertEquals("Maharashtra", customer.getState());
    }

    @Test
    public void testDefaultConstructor() {
        // Create a Customer object using the default constructor
        Customer customer = new Customer();

        // Assert that the object was created and is not null
        assertNotNull(customer);
    }

    @Test
    public void testParameterizedConstructor() {
        // Test parameterized constructor (if added)
        Customer customer = new Customer();

        // Set values manually (in this case, just reusing setters for demo)
        customer.setCustomerid(1);
        customer.setFirstname("Arjun");
        customer.setLastname("Sharma");
        customer.setEmail("arjun.sharma@gmail.com");
        customer.setPhone(9876543210L);
        customer.setGender("Male");
        customer.setCity("Mumbai");
        customer.setState("Maharashtra");

        // Assert values through getters
        assertEquals(1, customer.getCustomerid());
        assertEquals("Arjun", customer.getFirstname());
        assertEquals("Sharma", customer.getLastname());
        assertEquals("arjun.sharma@gmail.com", customer.getEmail());
        assertEquals(9876543210L, customer.getPhone());
        assertEquals("Male", customer.getGender());
        assertEquals("Mumbai", customer.getCity());
        assertEquals("Maharashtra", customer.getState());
    }
}

