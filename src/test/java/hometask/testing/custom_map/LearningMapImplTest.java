package hometask.testing.custom_map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LearningMapImplTest {
    private static int capacity = 4;
    LearningMapImpl map;

    @BeforeEach
    void init() {
        map = new LearningMapImpl(capacity);
    }

    @Test
    public void testIsEmpty() {
        assertEquals(0, map.getSize());
    }

    @Test
    public void testIsNotEmpty() {
        map.put(1, "One");
        assertFalse(map.getSize() == 0);
        map.put(2, "Two");
        assertEquals(2, map.getSize());

    }

    @Test
    public void testSizeIsEmpty() {
        assertEquals(0, map.getSize());
    }

    @Test
    public void testSizeWithoutDuplicates() {
        map.put(1, "One");
        map.put(2, "Two");
        assertEquals(2, map.getSize());
    }

    @Test
    public void testSizeWithDuplicates() {
        map.put(1, "One");
        map.put(1, "Two");
        assertEquals(1, map.getSize());
    }

    @Test
    public void testGetKeyReturnNullIfKeyNotPresent() {
        assertEquals(null, map.get(10000000));
    }

    @Test
    public void testGetKeyWithoutDuplicates() {
        map.put(1, "One");
        map.put(2, "Two");
        assertEquals("One", map.get(1));
        assertEquals("Two", map.get(2));
    }

    @Test
    public void testGetKeyWithDuplicates() {
        map.put(1, "One-1");
        map.put(2, "Two-1");
        map.put(3, "Three-1");
        map.put(4, "Four-1");
        map.put(5, "Five-1");
        map.put(1, "One-2");
        map.put(2, "Two-2");
        map.put(3, "Three-2");
        map.put(1, "One-3");

        assertEquals("One-3", map.get(1));
        assertEquals("Two-2", map.get(2));
        assertEquals("Three-2", map.get(3));
    }
}