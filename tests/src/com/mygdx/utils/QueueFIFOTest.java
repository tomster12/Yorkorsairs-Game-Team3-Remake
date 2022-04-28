package com.mygdx.utils;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueFIFOTest {

    QueueFIFO<Integer> queue;

    @BeforeEach
    void setUp () {
        queue = new QueueFIFO();
    }

    @Test
    void QueueFIFOSizeTest() {
        assertEquals(queue.size(), 0);

        queue.add(30);

        assertEquals(queue.size(), 1);
    }

    @Test
    void QueueFIFOIsEmptyTest() {
        assertTrue(queue.isEmpty());

        queue.add(20);

        assertFalse(queue.isEmpty());
    }

    @Test
    void QueueFIFOContainsTest() {
        assertFalse(queue.contains(20));

        queue.add(20);

        assertTrue(queue.contains(20));
    }

    @Test
    void QueueFIFOIteratorTest() {
        assertTrue(queue.iterator() instanceof Iterator);
    }

    @Test
    void QueueFIFOAddTest() {
        assertFalse(queue.contains(50));

        queue.add(50);

        assertTrue(queue.contains(50));
    }

    @Test
    void QueueFIFORemoveTest() {
        queue.add(50);
        assertTrue(queue.contains(50));

        queue.remove(0);

        assertFalse(queue.contains(50));
    }

    @Test
    void QueueFIFOContainsAllTest() {
        Collection<Integer> list = new LinkedList<Integer>();
        list.add(20);
        list.add(50);

        assertFalse(queue.containsAll(list));

        queue.add(20);
        queue.add(50);

        assertTrue(queue.containsAll(list));
    }

    @Test
    void QueueFIFOAddAllTest() {
        Collection<Integer> list = new LinkedList<Integer>();
        list.add(60);
        list.add(70);

        queue.addAll(list);
        assertTrue(queue.containsAll(list));
    }

    @Test
    void QueueFIFORemoveAllTest() {
        Collection<Integer> list = new LinkedList<Integer>();
        list.add(60);
        list.add(70);

        queue.add(60);
        queue.add(70);

        queue.removeAll(list);

        assertFalse(queue.containsAll(list));
    }

    @Test
    void QueueFIFORetainAllTest() {
        Collection<Integer> list = new LinkedList<Integer>();
        list.add(20);
        list.add(70);

        queue.add(20);
        queue.add(60);
        queue.add(70);

        queue.retainAll(list);

        assertTrue((queue.containsAll(list)) & (queue.size() == 2));
    }

    @Test
    void QueueFIFOClearTest() {
        queue.add(20);
        queue.add(60);
        queue.add(70);

        queue.clear();

        assertEquals(queue.size(), 0);
    }

    @Test
    void QueueFIFOPopTest() {
        queue.add(20);
        queue.add(60);
        queue.add(70);
        assertEquals(queue.size(), 3);
        queue.pop();
        assertEquals(queue.size(), 2);
    }

    @Test
    void QueueFIFOPollTest() {
        queue.add(60);
        queue.add(70);
        assertEquals(queue.poll(), 70);
        assertEquals(queue.poll(), 60);
        assertNull(queue.poll());
    }

    @Test
    void QueueFIFOElementTest() {
        queue.add(60);
        queue.add(70);
        assertEquals(queue.element(), 70);
    }

    @Test
    void QueueFIFOPeekTest() {
        queue.add(60);
        queue.add(70);
        assertEquals(queue.element(), 70);
    }
}
