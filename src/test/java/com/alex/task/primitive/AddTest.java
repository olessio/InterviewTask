package com.alex.task.primitive;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddTest {
    @Test
    public void testAdd1() throws Exception {
        //GIVEN
        long x = 5;
        long y = 7;

        //WHEN
        long result = PrimitiveTasks.add(x, y);

        //THEN
        assertThat(result, equalTo(x + y));
    }

    @Test
    public void testAdd2() throws Exception {
        //GIVEN
        long x = 7;
        long y = 7;

        //WHEN
        long result = PrimitiveTasks.add(x, y);

        //THEN
        assertThat(result, equalTo(x + y));
    }

    @Test
    public void testAdd3() throws Exception {
        //GIVEN
        long x = 2;
        long y = 5;

        //WHEN
        long result = PrimitiveTasks.add(x, y);

        //THEN
        assertThat(result, equalTo(x + y));
    }

    @Test
    public void testAdd4() throws Exception {
        //GIVEN
        long x = 200;
        long y = 512312;

        //WHEN
        long result = PrimitiveTasks.add(x, y);

        //THEN
        assertThat(result, equalTo(x + y));
    }

    @Test
    public void testAddRandom() throws Exception {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            //GIVEN
            long x = Math.abs(random.nextLong());
            long y = Math.abs(random.nextLong());

            //WHEN
            long result = PrimitiveTasks.add(x, y);

            //THEN
            assertThat("Test " + x + " + " + y, result, equalTo(x + y));
        }
    }
}
