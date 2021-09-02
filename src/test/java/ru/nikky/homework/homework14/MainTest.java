package ru.nikky.homework.homework14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void cutArrayAfterFour() {
        assertArrayEquals(new int[]{1, 7}, Main.cutArrayAfterFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
        assertArrayEquals(new int[]{}, Main.cutArrayAfterFour(new int[]{1, 2, 4, 4, 2, 3, 4}));
        assertThrows(RuntimeException.class, () -> Main.cutArrayAfterFour(new int[]{1, 2, 3, 5, 6, 7}));
        assertArrayEquals(new int[]{}, Main.cutArrayAfterFour(new int[]{4}));
    }

    @Test
    void isOnesAndFoursArray() {
        assertTrue(Main.isOnesAndFoursArray(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
        assertFalse(Main.isOnesAndFoursArray(new int[]{1, 1, 1, 1, 1, 1}));
        assertFalse(Main.isOnesAndFoursArray(new int[]{4, 4, 4, 4}));
        assertFalse(Main.isOnesAndFoursArray(new int[]{1, 4, 4, 1, 1, 4, 3}));
        assertFalse(Main.isOnesAndFoursArray(new int[]{}));
    }
}
