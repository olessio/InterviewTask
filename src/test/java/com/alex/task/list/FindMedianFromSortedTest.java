package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FindMedianFromSortedTest {

    @Test
    public void testFindMedianMethod1Test1() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 5, 6, 7, 8);

        //WHEN
        Integer median = ListTasks.findMedianFromSorted1(list);

        //THEN
        assertThat(median, equalTo(6));
    }

    @Test
    public void testFindMedianMethod1Test2() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 5, 6, 7);

        //WHEN
        Integer median = ListTasks.findMedianFromSorted1(list);

        //THEN
        assertThat(median, equalTo(5));
    }

    @Test
    public void testFindMedianMethod1Test3() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 5);

        //WHEN
        Integer median = ListTasks.findMedianFromSorted1(list);

        //THEN
        assertThat(median, equalTo(3));
    }

    @Test
    public void testFindMedianMethod1Test4() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3);

        //WHEN
        Integer median = ListTasks.findMedianFromSorted1(list);

        //THEN
        assertThat(median, equalTo(3));
    }

    @Test
    public void testFindMedianMethod2Test1() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 5, 6, 7, 8);

        //WHEN
        Integer median = ListTasks.findMedianFromSorted2(list);

        //THEN
        assertThat(median, equalTo(6));
    }

    @Test
    public void testFindMedianMethod2Test2() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 5, 6, 7);

        //WHEN
        Integer median = ListTasks.findMedianFromSorted2(list);

        //THEN
        assertThat(median, equalTo(5));
    }

    @Test
    public void testFindMedianMethod2Test3() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 5);

        //WHEN
        Integer median = ListTasks.findMedianFromSorted2(list);

        //THEN
        assertThat(median, equalTo(3));
    }

    @Test
    public void testFindMedianMethod2Test4() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3);

        //WHEN
        Integer median = ListTasks.findMedianFromSorted2(list);

        //THEN
        assertThat(median, equalTo(3));
    }
}
