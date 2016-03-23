package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import org.junit.Test;

import static com.alex.datastructure.ListTestUtils.assertElements;

public class FastRemoveFromMiddleTest {

    @Test
    public void testFatsRemoveFromMiddle() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>("first", "second", "third", "fourth");

        //WHEN
        ListTasks.fastRemoveFromMiddle(list.getNode("second"));

        //THEN
        assertElements(list, "first", "third", "fourth");

        //WHEN
        ListTasks.fastRemoveFromMiddle(list.getNode("third"));

        //THEN
        assertElements(list, "first", "fourth");
    }
}
