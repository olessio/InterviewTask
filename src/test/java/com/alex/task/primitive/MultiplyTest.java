package com.alex.task.primitive;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MultiplyTest {
    @Test
    public void testMultiplyZero() throws Exception {
        //GIVEN
        long x = 0;
        long y = 7;

        //WHEN
        long result = PrimitiveTasks.multiply(x, y);

        //THEN
        assertThat(result, equalTo(x * y));
    }

    @Test
    public void testMultiply1() throws Exception {
        //GIVEN
        long x = 5;
        long y = 7;

        //WHEN
        long result = PrimitiveTasks.multiply(x, y);

        //THEN
        assertThat(result, equalTo(x * y));
    }

    @Test
    public void testMultiply2() throws Exception {
        //GIVEN
        long x = 7;
        long y = 7;

        //WHEN
        long result = PrimitiveTasks.multiply(x, y);

        //THEN
        assertThat(result, equalTo(x * y));
    }

    @Test
    public void testMultiply3() throws Exception {
        //GIVEN
        long x = 2;
        long y = 5;

        //WHEN
        long result = PrimitiveTasks.multiply(x, y);

        //THEN
        assertThat(result, equalTo(x * y));
    }

    @Test
    public void testMultiply4() throws Exception {
        //GIVEN
        long x = 200;
        long y = 512312;

        //WHEN
        long result = PrimitiveTasks.multiply(x, y);

        //THEN
        assertThat(result, equalTo(x * y));
    }

    @Test
    public void testMultiplyRandom() throws Exception {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            //GIVEN
            long x = Math.abs(random.nextLong());
            long y = Math.abs(random.nextLong());

            //WHEN
            long result = PrimitiveTasks.multiply(x, y);

            //THEN
            assertThat("Test " + x + " + " + y, result, equalTo(x * y));
        }
    }
}
