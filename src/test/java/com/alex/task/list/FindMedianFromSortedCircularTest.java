package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FindMedianFromSortedCircularTest {

    @Test
    public void testFindMedianMethodTest1() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 5, 6, 7, 8);
        list.getTail().setNext(list.getHead());

        LinkedList.Node<Integer> curr = list.getHead();
        do {
            //WHEN
            Integer median = ListTasks.findMedianFromSortedCircular(curr);

            //THEN
            assertThat(median, equalTo(6));

            curr = curr.getNext();
        } while ((curr != list.getHead()));
    }

    @Test
    public void testFindMedianMethod1Test2() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 5, 6, 7);
        list.getTail().setNext(list.getHead());

        LinkedList.Node<Integer> curr = list.getHead();
        do {
            //WHEN
            Integer median = ListTasks.findMedianFromSortedCircular(list.getHead().getNext());

            //THEN
            assertThat(median, equalTo(5));

            curr = curr.getNext();
        } while ((curr != list.getHead()));
    }

    @Test
    public void testFindMedianMethod1Test3() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 5);
        list.getTail().setNext(list.getHead());

        LinkedList.Node<Integer> curr = list.getHead();
        do {
            //WHEN
            Integer median = ListTasks.findMedianFromSortedCircular(list.getHead().getNext());

            //THEN
            assertThat(median, equalTo(3));

            curr = curr.getNext();
        } while ((curr != list.getHead()));
    }

    @Test
    public void testFindMedianMethod1Test4() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3);
        list.getTail().setNext(list.getHead());

        LinkedList.Node<Integer> curr = list.getHead();
        do {
            //WHEN
            Integer median = ListTasks.findMedianFromSortedCircular(list.getHead().getNext());

            //THEN
            assertThat(median, equalTo(3));

            curr = curr.getNext();
        } while ((curr != list.getHead()));
    }
}
