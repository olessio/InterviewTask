package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FindOverlappingNoCycleTest {

    @Test
    public void testIfDifferentSize() {
        //GIVEN
        LinkedList<Integer> left = new LinkedList<>(10, 20, 30, 40, 50);
        LinkedList<Integer> right = new LinkedList<>(15, 25);
        right.getTail().setNext(left.getNode(40));

        //WHEN
        LinkedList.Node<Integer> overlapStart = ListTasks.findOverlappingNoCycle(left, right);

        //THEN
        assertThat(overlapStart.getData(), equalTo(40));

        //WHEN
        overlapStart = ListTasks.findOverlappingNoCycle(right, left);

        //THEN
        assertThat(overlapStart.getData(), equalTo(40));
    }

    @Test
    public void testIfSameSize() {
        //GIVEN
        LinkedList<Integer> left = new LinkedList<>(20, 30, 40, 50);
        LinkedList<Integer> right = new LinkedList<>(15, 25);
        right.getTail().setNext(left.getNode(40));

        //WHEN
        LinkedList.Node<Integer> overlapStart = ListTasks.findOverlappingNoCycle(left, right);

        //THEN
        assertThat(overlapStart.getData(), equalTo(40));

        //WHEN
        overlapStart = ListTasks.findOverlappingNoCycle(right, left);

        //THEN
        assertThat(overlapStart.getData(), equalTo(40));
    }

    @Test
    public void testIfNoOverlap() {
        //GIVEN
        LinkedList<Integer> left = new LinkedList<>(20, 30, 40, 50);
        LinkedList<Integer> right = new LinkedList<>(15, 25, 35);

        //WHEN
        LinkedList.Node<Integer> overlapStart = ListTasks.findOverlappingNoCycle(left, right);

        //THEN
        assertThat(overlapStart, nullValue());
    }
}
