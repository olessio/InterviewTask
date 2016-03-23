package com.alex.datastructure;

import org.junit.Test;

import static com.alex.datastructure.ListTestUtils.assertElements;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LinkedListTest {

    @Test
    public void testAdd() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();

        //WHEN
        list.add("first");
        list.add("second");
        list.add("third");

        //THEN
        assertElements(list, "first", "second", "third");
    }

    @Test
    public void testRemoveHeadMultipleRecords() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");

        //WHEN
        boolean removed = list.remove("first");

        //THEN
        assertThat(removed, is(true));
        assertElements(list, "second", "third", "fourth");
    }

    @Test
    public void testRemoveHeadTwoRecords() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");

        //WHEN
        boolean removed = list.remove("first");

        //THEN
        assertThat(removed, is(true));
        assertElements(list, "second");
    }

    @Test
    public void testRemoveHeadOneRecord() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();
        list.add("first");

        //WHEN
        boolean removed = list.remove("first");

        //THEN
        assertThat(removed, is(true));
        assertElements(list);
    }

    @Test
    public void testRemoveTailMultipleRecords() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");

        //WHEN
        boolean removed = list.remove("fourth");

        //THEN
        assertThat(removed, is(true));
        assertElements(list, "first", "second", "third");
    }

    @Test
    public void testRemoveTailTwoRecords() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");

        //WHEN
        boolean removed = list.remove("second");

        //THEN
        assertThat(removed, is(true));
        assertElements(list, "first");
    }

    @Test
    public void testRemoveFormMiddle() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");

        //WHEN
        boolean removed = list.remove("second");

        //THEN
        assertThat(removed, is(true));
        assertElements(list, "first", "third", "fourth");
    }

    @Test
    public void testRemoveIfNotFound() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");

        //WHEN
        boolean removed = list.remove("not found");

        //THEN
        assertThat(removed, is(false));
        assertElements(list, "first", "second", "third", "fourth");
    }

    @Test
    public void testRemoveFromEmpty() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();

        //WHEN
        boolean removed = list.remove("not found");

        //THEN
        assertThat(removed, is(false));
        assertElements(list);
    }

    @Test
    public void testContainsFromEmpty() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();

        //WHEN
        boolean contains = list.contains("not found");

        //THEN
        assertThat(contains, is(false));
    }

    @Test
    public void testContainsIfFalse() {
        //GIVEN
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");

        //WHEN
        boolean contains = list.contains("not found");

        //THEN
        assertThat(contains, is(false));
    }

}