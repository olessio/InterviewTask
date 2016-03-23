package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class FindOverlappingTest {
    @Test
    public void testIfOverlapNoCycles() {
        //GIVEN
        LinkedList<Integer> left = new LinkedList<>(10, 20, 30, 40, 50);
        LinkedList<Integer> right = new LinkedList<>(15, 25);
        right.getTail().setNext(left.getNode(40));

        //WHEN
        LinkedList.Node<Integer> overlapStart = ListTasks.findOverlapping(left, right);

        //THEN
        assertThat(overlapStart.getData(), equalTo(40));

        //WHEN
        overlapStart = ListTasks.findOverlapping(right, left);

        //THEN
        assertThat(overlapStart.getData(), equalTo(40));
    }

    @Test
    public void testIfOverlapWithCircle() {
        //GIVEN
        LinkedList<Integer> left = new LinkedList<>(10, 20, 30, 40, 50);
        left.getTail().setNext(left.getNode(30));
        LinkedList<Integer> right = new LinkedList<>(left.getNode(30));

        //WHEN
        LinkedList.Node<Integer> overlapStart = ListTasks.findOverlapping(left, right);

        //THEN
        assertThat(overlapStart.getData(), equalTo(30));

        //WHEN
        overlapStart = ListTasks.findOverlapping(right, left);

        //THEN
        assertThat(overlapStart.getData(), equalTo(30));
    }

    @Test
    public void testIfOverlap() {
        //GIVEN
        LinkedList<Integer> left = new LinkedList<>(10, 20, 30, 40, 50);
        left.getTail().setNext(left.getNode(30));
        LinkedList<Integer> right = new LinkedList<>(5, 15, 25);
        right.getTail().setNext(left.getNode(30));

        //WHEN
        LinkedList.Node<Integer> overlapStart = ListTasks.findOverlapping(left, right);

        //THEN
        assertThat(overlapStart.getData(), equalTo(30));

        //WHEN
        overlapStart = ListTasks.findOverlapping(right, left);

        //THEN
        assertThat(overlapStart.getData(), equalTo(30));
    }

    @Test
    public void testIfSameCircle() {
        //GIVEN
        LinkedList<Integer> left = new LinkedList<>(10, 20, 30, 40, 50);
        left.getTail().setNext(left.getHead());
        LinkedList<Integer> right = new LinkedList<>(left.getHead().getNext());

        //WHEN
        LinkedList.Node<Integer> overlapStart = ListTasks.findOverlapping(left, right);

        //THEN
        assertThat(overlapStart.getData(), notNullValue());

        //WHEN
        overlapStart = ListTasks.findOverlapping(right, left);

        //THEN
        assertThat(overlapStart.getData(), notNullValue());
    }

    @Test
    public void testIfDifferentCycles() {
        //GIVEN
        LinkedList<Integer> left = new LinkedList<>(10, 20, 30, 40, 50);
        left.getTail().setNext(left.getNode(30));
        LinkedList<Integer> right = new LinkedList<>(5, 15, 25, 35);
        right.getTail().setNext(right.getNode(15));

        //WHEN
        LinkedList.Node<Integer> overlapStart = ListTasks.findOverlapping(left, right);

        //THEN
        assertThat(overlapStart, nullValue());

        //WHEN
        overlapStart = ListTasks.findOverlapping(right, left);

        //THEN
        assertThat(overlapStart, nullValue());
    }
}
