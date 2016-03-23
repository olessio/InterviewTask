package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class MthFromTailTest {

    @Test
    public void testFindMthFromTail() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>("first", "second", "third", "fourth");

        //WHEN

        //THEN
        assertThat(ListTasks.findMthFromTail(list, 0).getData(), equalTo("fourth"));
        assertThat(ListTasks.findMthFromTail(list, 1).getData(), equalTo("third"));
        assertThat(ListTasks.findMthFromTail(list, 2).getData(), equalTo("second"));
        assertThat(ListTasks.findMthFromTail(list, 3).getData(), equalTo("first"));
    }

    @Test
    public void testFindMthFromTailIfSingleElementList() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();
        list.add("first");

        //WHEN

        //THEN
        assertThat(ListTasks.findMthFromTail(list, 0).getData(), equalTo("first"));
        assertThat(ListTasks.findMthFromTail(list, 1), nullValue());
    }

    @Test
    public void testFindMthFromTailIfTooBigM() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>("first", "second", "third", "fourth");

        //WHEN

        //THEN
        assertThat(ListTasks.findMthFromTail(list, 5), nullValue());
    }

    @Test
    public void testFindMthFromTailIfEmptyList() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();
        //WHEN

        //THEN
        assertThat(ListTasks.findMthFromTail(list, 0), nullValue());
        assertThat(ListTasks.findMthFromTail(list, 1), nullValue());
    }

}