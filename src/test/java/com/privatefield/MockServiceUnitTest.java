package com.privatefield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class MockServiceUnitTest {
    private Person mockedPerson;

    @BeforeEach
    void setUp() {
        mockedPerson = mock(Person.class);
    }

    @Test
    void givenNameChangedWithReflectionUtils_whenGetName_thenReturnName() throws Exception {
        MockService mockService = new MockService();
        Field field = ReflectionUtils
                .findFields(MockService.class, f -> f.getName().equals("person"),
                        ReflectionUtils.HierarchyTraversalMode.TOP_DOWN)
                .get(0);

        field.setAccessible(true);
        field.set(mockService, mockedPerson);

        given(mockedPerson.getName()).willReturn("Jane Doe");

        Assertions.assertEquals("Jane Doe", mockService.getName());

        // Reset the mock
        Mockito.reset(mockedPerson);

        given(mockedPerson.getName()).willThrow(new RuntimeException("Error"));

        Assertions.assertThrows(RuntimeException.class, () -> mockService.getName());
    }
}
