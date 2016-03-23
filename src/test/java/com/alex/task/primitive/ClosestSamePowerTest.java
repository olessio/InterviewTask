package com.alex.task.primitive;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ClosestSamePowerTest {

    @Test(expected = IllegalArgumentException.class)
    public void testFindClosestSamePowerIfAllZero() throws Exception {
        //GIVEN
        long value = 0;

        //WHEN
        PrimitiveTasks.findClosestSamePower(value);

        //THEN
        //exception is expected
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindClosestSamePowerIfAllOne() throws Exception {
        //GIVEN
        long value = -1;

        //WHEN
        PrimitiveTasks.findClosestSamePower(value);

        //THEN
        //exception is expected
    }

    @Test
    public void testFindClosestSamePower1() throws Exception {
        //GIVEN
        long value = Long.parseLong("111", 2);

        //WHEN
        long result = PrimitiveTasks.findClosestSamePower(value);

        //THEN
        assertThat(result, equalTo(Long.parseLong("1011", 2)));
    }

    @Test
    public void testFindClosestSamePower2() throws Exception {
        //GIVEN
        long value = Long.parseLong("1110", 2);

        //WHEN
        long result = PrimitiveTasks.findClosestSamePower(value);

        //THEN
        assertThat(result, equalTo(Long.parseLong("1101", 2)));
    }

    @Test
    public void testFindClosestSamePower3() throws Exception {
        //GIVEN
        long value = Long.parseLong("1101", 2);

        //WHEN
        long result = PrimitiveTasks.findClosestSamePower(value);

        //THEN
        assertThat(result, equalTo(Long.parseLong("1110", 2)));
    }
}
