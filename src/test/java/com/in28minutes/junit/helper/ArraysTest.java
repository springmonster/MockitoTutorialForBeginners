package com.in28minutes.junit.helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;

public class ArraysTest {
    @Test
    @Timeout(100)
    public void testPerformance() {
        for (int i = 0; i < 1000000; i++) {
            Arrays.sort(new int[]{i, i - 1, i + 1});
        }
    }
}
