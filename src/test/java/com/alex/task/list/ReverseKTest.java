package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import com.alex.datastructure.ListTestUtils;
import org.junit.Test;

public class ReverseKTest {
//
//    @Test
//    public void testReverse1() {
//        //GIVEN
//        LinkedList<Integer> list = new LinkedList<>(3);
//
//        //WHEN
//        LinkedList<Integer> reversed = ListTasks.reverse(list);
//
//        //THEN
//        ListTestUtils.assertElements(reversed, 3);
//
//    }
//
//    @Test
//    public void testReverse2() {
//        //GIVEN
//        LinkedList<Integer> list = new LinkedList<>(3, 4);
//
//        //WHEN
//        LinkedList<Integer> reversed = ListTasks.reverse(list);
//
//        //THEN
//        ListTestUtils.assertElements(reversed, 4, 3);
//
//    }
//
//    @Test
//    public void testReverse3() {
//        //GIVEN
//        LinkedList<Integer> list = new LinkedList<>(3, 4, 5);
//
//        //WHEN
//        LinkedList<Integer> reversed = ListTasks.reverse(list);
//
//        //THEN
//        ListTestUtils.assertElements(reversed, 5, 4, 3);
//
//    }
//
//    @Test
//    public void testReverse4() {
//        //GIVEN
//        LinkedList<Integer> list = new LinkedList<>(3, 4, 5, 6);
//
//        //WHEN
//        LinkedList<Integer> reversed = ListTasks.reverse(list);
//
//        //THEN
//        ListTestUtils.assertElements(reversed, 6, 5, 4, 3);
//
//    }
//
    @Test
    public void testReverseK5() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(1, 2, 3, 4, 5, 6, 7, 8);

        //WHEN
        LinkedList<Integer> reversed = ListTasks.reverseK(list, 3);

        //THEN
        ListTestUtils.assertElements(reversed, 3, 2, 1, 6, 5, 4, 7, 8);

    }
}
