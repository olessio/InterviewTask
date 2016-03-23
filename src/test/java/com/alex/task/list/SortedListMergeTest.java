package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import com.alex.datastructure.ListTestUtils;
import org.junit.Test;

public class SortedListMergeTest {

    @Test
    public void testMerge1() {
        //GIVEN
        LinkedList<Integer> left = new LinkedList<>(3, 5, 6, 7);
        LinkedList<Integer> right = new LinkedList<>(2, 4, 5, 9, 10, 11);

        //WHEN
        LinkedList<Integer> merged = ListTasks.merge(left, right);

        //THEN
        ListTestUtils.assertElements(merged, 2, 3, 4, 5, 5, 6, 7, 9, 10, 11);
    }

    @Test
    public void testMerge2() {
        //GIVEN
        LinkedList<Integer> left = new LinkedList<>(1, 3, 5, 6, 7, 15);
        LinkedList<Integer> right = new LinkedList<>(2, 4, 5, 9, 10, 11);

        //WHEN
        LinkedList<Integer> merged = ListTasks.merge(left, right);

        //THEN
        ListTestUtils.assertElements(merged, 1, 2, 3, 4, 5, 5, 6, 7, 9, 10, 11, 15);
    }

    @Test
    public void testMerge3() {
        //GIVEN
        LinkedList<Integer> left = new LinkedList<>(1, 3, 5, 6, 7, 15);
        LinkedList<Integer> right = new LinkedList<>(1, 2, 4, 5, 9, 10, 11, 15);

        //WHEN
        LinkedList<Integer> merged = ListTasks.merge(left, right);

        //THEN
        ListTestUtils.assertElements(merged, 1, 1, 2, 3, 4, 5, 5, 6, 7, 9, 10, 11, 15, 15);
    }
}
