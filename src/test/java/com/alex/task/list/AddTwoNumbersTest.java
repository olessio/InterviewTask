package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddTwoNumbersTest {

    @Test
    public void testAddTwoNumbersReversed1() {
        //GIVEN
        LinkedList<Integer> l1 = new LinkedList<>(9, 7, 2);
        LinkedList<Integer> l2 = new LinkedList<>(8, 9, 3);

        //WHEN
        int result = ListTasks.addTwoNumbersReversed(l1, l2);

        //THEN
        assertThat(result, equalTo(279 + 398));
    }

    @Test
    public void testAddTwoNumbersReversed2() {
        //GIVEN
        LinkedList<Integer> l1 = new LinkedList<>(9, 9, 9);
        LinkedList<Integer> l2 = new LinkedList<>(8, 8, 8);

        //WHEN
        int result = ListTasks.addTwoNumbersReversed(l1, l2);

        //THEN
        assertThat(result, equalTo(888 + 999));
    }

    @Test
    public void testAddTwoNumbersReversed3() {
        //GIVEN
        LinkedList<Integer> l1 = new LinkedList<>(9, 9, 9, 9, 9);
        LinkedList<Integer> l2 = new LinkedList<>(8, 8, 8);

        //WHEN
        int result = ListTasks.addTwoNumbersReversed(l1, l2);

        //THEN
        assertThat(result, equalTo(888 + 99999));

        //WHEN
        result = ListTasks.addTwoNumbersReversed(l2, l1);

        //THEN
        assertThat(result, equalTo(888 + 99999));
    }
}
