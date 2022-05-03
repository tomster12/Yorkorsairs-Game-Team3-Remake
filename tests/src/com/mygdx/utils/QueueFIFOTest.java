package com.mygdx.utils;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.mygdx.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@RunWith(GdxTestRunner.class)
public class QueueFIFOTest {
    @Test
    public void QueueFIFOSizeTest() {
        QueueFIFO queue = new QueueFIFO();
        assertEquals(queue.size(), 0);

        queue.add(30);

        assertEquals(queue.size(), 1);
    }

    @Test
    public void QueueFIFOIsEmptyTest() {
        QueueFIFO queue = new QueueFIFO();
        assertTrue(queue.isEmpty());

        queue.add(20);

        assertFalse(queue.isEmpty());
    }

    @Test
    public void QueueFIFOContainsTest() {
        QueueFIFO queue = new QueueFIFO();
        assertFalse(queue.contains(20));

        queue.add(20);

        assertTrue(queue.contains(20));
    }

    @Test
    public void QueueFIFOIteratorTest() {
        QueueFIFO queue = new QueueFIFO();

        assertTrue(queue.iterator() instanceof Iterator);
    }

    @Test
    public void QueueFIFOAddTest() {
        QueueFIFO queue = new QueueFIFO();

        assertFalse(queue.contains(50));

        queue.add(50);

        assertTrue(queue.contains(50));
    }

    @Test
    public void QueueFIFORemoveTest() {
        QueueFIFO queue = new QueueFIFO();

        queue.add(50);
        assertTrue(queue.contains(50));

        queue.remove(0);

        assertFalse(queue.contains(50));
    }

    @Test
    public void QueueFIFOContainsAllTest() {
        QueueFIFO queue = new QueueFIFO();

        Collection<Integer> list = new LinkedList<Integer>();
        list.add(20);
        list.add(50);

        assertFalse(queue.containsAll(list));

        queue.add(20);
        queue.add(50);

        assertTrue(queue.containsAll(list));
    }

    @Test
     public void QueueFIFOAddAllTest() {
        QueueFIFO queue = new QueueFIFO();

        Collection<Integer> list = new LinkedList<Integer>();
        list.add(60);
        list.add(70);

        queue.addAll(list);
        assertTrue(queue.containsAll(list));
    }

    @Test
    public void QueueFIFORemoveAllTest() {
        QueueFIFO queue = new QueueFIFO();

        Collection<Integer> list = new LinkedList<Integer>();
        list.add(60);
        list.add(70);

        queue.add(60);
        queue.add(70);

        queue.removeAll(list);

        assertFalse(queue.containsAll(list));
    }

    @Test
    public void QueueFIFORetainAllTest() {
        QueueFIFO queue = new QueueFIFO();

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
    public void QueueFIFOClearTest() {
        QueueFIFO queue = new QueueFIFO();

        queue.add(20);
        queue.add(60);
        queue.add(70);

        queue.clear();

        assertEquals(queue.size(), 0);
    }

    @Test
    public void QueueFIFOPopTest() {
        QueueFIFO queue = new QueueFIFO();

        queue.add(20);
        queue.add(60);
        queue.add(70);
        assertEquals(queue.size(), 3);
        queue.pop();
        assertEquals(queue.size(), 2);
    }

    @Test
    public void QueueFIFOPollTest() {
        QueueFIFO queue = new QueueFIFO();

        queue.add(60);
        queue.add(70);
        assertEquals(queue.poll(), 70);
        assertEquals(queue.poll(), 60);
        assertNull(queue.poll());
    }

    @Test
    public void QueueFIFOElementTest() {
        QueueFIFO queue = new QueueFIFO();

        queue.add(60);
        queue.add(70);
        assertEquals(queue.element(), 70);
    }

    @Test
    public void QueueFIFOPeekTest() {
        QueueFIFO queue = new QueueFIFO();

        queue.add(60);
        queue.add(70);
        assertEquals(queue.element(), 70);
    }
}
