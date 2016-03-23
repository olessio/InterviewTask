package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import com.alex.datastructure.ListTestUtils;
import org.junit.Test;

public class ListPivotingTest {
    @Test
    public void testListPivoting1() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(1, 7, 4, 2);

        //WHEN
        LinkedList<Integer> listPivoting = ListTasks.listPivoting(list, 3);

        //THEN
        ListTestUtils.assertElements(listPivoting, 1, 2, 7, 4);
    }

    @Test
    public void testListPivoting2() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(1, 7, 4, 2, 1, 4, 1, 7);

        //WHEN
        LinkedList<Integer> listPivoting = ListTasks.listPivoting(list, 3);

        //THEN
        ListTestUtils.assertElements(listPivoting, 1, 2, 1, 1, 7, 4, 4, 7);
    }

    @Test
    public void testListPivoting3() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(1, 3, 7, 4, 2, 1, 4, 1, 3, 7);

        //WHEN
        LinkedList<Integer> listPivoting = ListTasks.listPivoting(list, 3);

        //THEN
        ListTestUtils.assertElements(listPivoting, 1, 2, 1, 1, 3, 3, 7, 4, 4, 7);
    }

    @Test
    public void testListPivoting4() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(1, 7, 4, 2);

        //WHEN
        LinkedList<Integer> listPivoting = ListTasks.listPivoting(list, 9);

        //THEN
        ListTestUtils.assertElements(listPivoting, 1, 7, 4, 2);

    }

    @Test
    public void testListPivoting5() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(1, 7, 4, 2);

        //WHEN
        LinkedList<Integer> listPivoting = ListTasks.listPivoting(list, -1);

        //THEN
        ListTestUtils.assertElements(listPivoting, 1, 7, 4, 2);

    }

    @Test
    public void testListPivoting6() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(1, 7, 4, 2);

        //WHEN
        LinkedList<Integer> listPivoting = ListTasks.listPivoting(list, 7);

        //THEN
        ListTestUtils.assertElements(listPivoting, 1, 4, 2, 7);

    }

    @Test
    public void testListPivoting7() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(1, 7, 4, 2);

        //WHEN
        LinkedList<Integer> listPivoting = ListTasks.listPivoting(list, 1);

        //THEN
        ListTestUtils.assertElements(listPivoting, 1, 4, 2, 7);

    }
}
