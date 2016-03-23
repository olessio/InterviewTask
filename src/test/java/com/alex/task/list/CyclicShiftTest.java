package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import com.alex.datastructure.ListTestUtils;
import org.junit.Test;

public class CyclicShiftTest {

    @Test
    public void testCyclicShift1() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 5, 6, 7);

        //WHEN
        LinkedList<Integer> cyclicShift = ListTasks.cyclicShift(list, 0);

        //THEN
        ListTestUtils.assertElements(cyclicShift, 3, 4, 5, 6, 7);

    }

    @Test
    public void testCyclicShift2() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 5, 6, 7);

        //WHEN
        LinkedList<Integer> cyclicShift = ListTasks.cyclicShift(list, 1);

        //THEN
        ListTestUtils.assertElements(cyclicShift, 7, 3, 4, 5, 6);

    }

    @Test
    public void testCyclicShift3() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 5, 6, 7);

        //WHEN
        LinkedList<Integer> cyclicShift = ListTasks.cyclicShift(list, 2);

        //THEN
        ListTestUtils.assertElements(cyclicShift, 6, 7, 3, 4, 5);

    }

    @Test
    public void testCyclicShift4() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 5, 6, 7);

        //WHEN
        LinkedList<Integer> cyclicShift = ListTasks.cyclicShift(list, 3);

        //THEN
        ListTestUtils.assertElements(cyclicShift, 5, 6, 7, 3, 4);

    }

    @Test
    public void testCyclicShift5() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 5, 6, 7);

        //WHEN
        LinkedList<Integer> cyclicShift = ListTasks.cyclicShift(list, 4);

        //THEN
        ListTestUtils.assertElements(cyclicShift, 4, 5, 6, 7, 3);

    }

    @Test
    public void testCyclicShift6() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 5, 6, 7);

        //WHEN
        LinkedList<Integer> cyclicShift = ListTasks.cyclicShift(list, 5);

        //THEN
        ListTestUtils.assertElements(cyclicShift, 3, 4, 5, 6, 7);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCyclicShift7() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 5, 6, 7);

        //WHEN
        ListTasks.cyclicShift(list, 6);

        //THEN
        //exception is expected

    }
}
