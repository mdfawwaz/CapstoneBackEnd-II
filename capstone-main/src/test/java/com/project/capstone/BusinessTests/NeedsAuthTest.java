package com.project.capstone.BusinessTests;

import com.project.capstone.business.NeedsAuth;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class NeedsAuthTest {

    @NeedsAuth(loginPage = "/custom-login")
    public void annotatedMethod() {
    }

    @Test
     void testNeedsAuthAnnotation() throws NoSuchMethodException {
        Method method = getClass().getMethod("annotatedMethod");

        NeedsAuth needsAuth = method.getAnnotation(NeedsAuth.class);

        assertEquals("/custom-login", needsAuth.loginPage());
    }
}

