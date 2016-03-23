package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CycleCheckTest {

    @Test
    public void testNoCycleSingleElementList() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>("first");

        //WHEN

        //THEN
        assertThat(ListTasks.containsCycles(list.getNode("first")), equalTo(false));
    }

    @Test
    public void testNoCycle() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>("first", "second", "third", "fourth");

        //WHEN

        //THEN
        assertThat(ListTasks.containsCycles(list.getNode("first")), equalTo(false));
        assertThat(ListTasks.containsCycles(list.getNode("second")), equalTo(false));
        assertThat(ListTasks.containsCycles(list.getNode("third")), equalTo(false));
        assertThat(ListTasks.containsCycles(list.getNode("fourth")), equalTo(false));
    }

    /**
     * Tail has head as 'next' element:
     * first -> second -> third -> fourth -> first
     */
    @Test
    public void testCircle() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>("first", "second", "third", "fourth");

        //WHEN
        list.getTail().setNext(list.getHead());

        //THEN
        assertThat(ListTasks.containsCycles(list.getNode("first")), equalTo(true));
        assertThat(ListTasks.containsCycles(list.getNode("second")), equalTo(true));
        assertThat(ListTasks.containsCycles(list.getNode("third")), equalTo(true));
        assertThat(ListTasks.containsCycles(list.getNode("fourth")), equalTo(true));
    }

    @Test
    public void testCircle2() {
        //GIVEN
        Integer[] data = new Integer[20];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        LinkedList<Integer> list = new LinkedList<>(data);

        //WHEN
        list.getTail().setNext(list.getHead());

        //THEN
        Arrays.stream(data).forEach(i -> {
            assertThat(ListTasks.containsCycles(list.getNode(i)), equalTo(true));
        });
    }

    /**
     * List looks like:
     * 1 -> 2 -> 3 -> 4 -> 5 -> 3
     */
    @Test
    public void testCircle3() {
        //GIVEN
        Integer[] data = new Integer[21];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        LinkedList<Integer> list = new LinkedList<>(data);

        //WHEN
        list.getTail().setNext(list.getNode(10));

        //THEN
        Arrays.stream(data).forEach(i -> {
            assertThat(ListTasks.containsCycles(list.getNode(i)), equalTo(true));
        });
    }
}
