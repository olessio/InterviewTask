package com.alex.task.list;

import com.alex.datastructure.LinkedList;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CheckPalindromeTest {

    @Test
    public void testCheckPalindromeIfTrue1() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 5, 4, 3);

        //WHEN

        //THEN
        assertThat(ListTasks.isPalindrome(list), equalTo(true));
    }

    @Test
    public void testCheckPalindromeIfTrue2() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 4, 3);

        //WHEN

        //THEN
        assertThat(ListTasks.isPalindrome(list), equalTo(true));
    }

    @Test
    public void testCheckPalindromeIfTrue3() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 3);

        //WHEN

        //THEN
        assertThat(ListTasks.isPalindrome(list), equalTo(true));
    }

    @Test
    public void testCheckPalindromeIfTrue4() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 3);

        //WHEN

        //THEN
        assertThat(ListTasks.isPalindrome(list), equalTo(true));
    }

    @Test
    public void testCheckPalindromeIfTrue5() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3);

        //WHEN

        //THEN
        assertThat(ListTasks.isPalindrome(list), equalTo(true));
    }

    @Test
    public void testCheckPalindromeIfFalse1() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 5, 4, 7);

        //WHEN

        //THEN
        assertThat(ListTasks.isPalindrome(list), equalTo(false));
    }

    @Test
    public void testCheckPalindromeIfFalse2() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 4, 5);

        //WHEN

        //THEN
        assertThat(ListTasks.isPalindrome(list), equalTo(false));
    }

    @Test
    public void testCheckPalindromeIfFalse3() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4, 1);

        //WHEN

        //THEN
        assertThat(ListTasks.isPalindrome(list), equalTo(false));
    }

    @Test
    public void testCheckPalindromeIfFalse4() {
        //GIVEN
        LinkedList<Integer> list = new LinkedList<>(3, 4);

        //WHEN

        //THEN
        assertThat(ListTasks.isPalindrome(list), equalTo(false));
    }
}
