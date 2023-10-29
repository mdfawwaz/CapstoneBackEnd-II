package com.project.capstone.BusinessTests;

import com.project.capstone.business.UserForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserFormTest {

    private UserForm userForm;

    @BeforeEach
    void setUp() {
        userForm = new UserForm();
    }

    @Test
    void testGetName() {
        userForm.setName("testuser");
        assertEquals("testuser", userForm.getName());
    }

    @Test
    void testSetName() {
        userForm.setName("testuser");
        assertEquals("testuser", userForm.getName());
    }

    @Test
    void testGetPassword() {
        userForm.setPassword("testpassword");
        assertEquals("testpassword", userForm.getPassword());
    }

    @Test
    void testSetPassword() {
        userForm.setPassword("testpassword");
        assertEquals("testpassword", userForm.getPassword());
    }

    @Test
    void testGetPasswordRepeat() {
        userForm.setPasswordRepeat("testpassword");
        assertEquals("testpassword", userForm.getPasswordRepeat());
    }

    @Test
    void testSetPasswordRepeat() {
        userForm.setPasswordRepeat("testpassword");
        assertEquals("testpassword", userForm.getPasswordRepeat());
    }

    @Test
    void testNullName() {
        userForm.setName(null);
        assertNull(userForm.getName());
    }

    @Test
    void testNullPassword() {
        userForm.setPassword(null);
        assertNull(userForm.getPassword());
    }

    @Test
    void testNullPasswordRepeat() {
        userForm.setPasswordRepeat(null);
        assertNull(userForm.getPasswordRepeat());
    }

    @Test
    void testEmptyName() {
        userForm.setName("");
        assertEquals("", userForm.getName());
    }

    @Test
    void testEmptyPassword() {
        userForm.setPassword("");
        assertEquals("", userForm.getPassword());
    }

    @Test
    void testEmptyPasswordRepeat() {
        userForm.setPasswordRepeat("");
        assertEquals("", userForm.getPasswordRepeat());
    }

    @Test
    void testPasswordMismatch() {
        userForm.setPassword("password123");
        userForm.setPasswordRepeat("differentpassword");
        assertNotEquals(userForm.getPassword(), userForm.getPasswordRepeat());
    }
}
