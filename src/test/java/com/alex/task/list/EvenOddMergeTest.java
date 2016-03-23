package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import com.alex.datastructure.ListTestUtils;
import org.junit.Test;

public class EvenOddMergeTest {

    @Test
    public void testEvenOddMerge1() {
        //GIVEN
        LinkedList.Node<Integer> node = new LinkedList<>(10, 20, 30, 40, 50).getHead();

        //WHEN
        node = ListTasks.evenOddMerge(node);

        //THEN
        ListTestUtils.assertElements(new LinkedList<>(node), 10, 30, 50, 20, 40);
    }

    @Test
    public void testEvenOddMerge2() {
        //GIVEN
        LinkedList.Node<Integer> node = new LinkedList<>(10, 20, 30, 40, 50, 60).getHead();

        //WHEN
        node = ListTasks.evenOddMerge(node);

        //THEN
        ListTestUtils.assertElements(new LinkedList<>(node), 10, 30, 50, 20, 40, 60);
    }

    @Test
    public void testEvenOddMerge3() {
        //GIVEN
        LinkedList.Node<Integer> node = new LinkedList<>(10).getHead();

        //WHEN
        node = ListTasks.evenOddMerge(node);

        //THEN
        ListTestUtils.assertElements(new LinkedList<>(node), 10);
    }

    @Test
    public void testEvenOddMerge4() {
        //GIVEN
        LinkedList.Node<Integer> node = new LinkedList<>(10, 20).getHead();

        //WHEN
        node = ListTasks.evenOddMerge(node);

        //THEN
        ListTestUtils.assertElements(new LinkedList<>(node), 10, 20);
    }

    @Test
    public void testEvenOddMerge5() {
        //GIVEN
        LinkedList.Node<Integer> node = new LinkedList<>(10, 20, 30).getHead();

        //WHEN
        node = ListTasks.evenOddMerge(node);

        //THEN
        ListTestUtils.assertElements(new LinkedList<>(node), 10, 30, 20);
    }
}
