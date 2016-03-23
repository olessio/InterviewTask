package com.alex.task.primitive;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class ReverseBitsTest {

    @Test
    public void testReverse1_1() throws Exception {
        //GIVEN
        long l = 1234567;

        //WHEN
        long reversed = PrimitiveTasks.reverseBits(l);

        //THEN
        assertReversed(l, reversed);
    }

    @Test
    public void testReverse1_2() throws Exception {
        //GIVEN
        long l = Long.MIN_VALUE;

        //WHEN
        long reversed = PrimitiveTasks.reverseBits(l);

        //THEN
        assertReversed(l, reversed);
    }

    @Test
    public void testReverse1_3() throws Exception {
        //GIVEN
        long l = Long.MAX_VALUE;

        //WHEN
        long reversed = PrimitiveTasks.reverseBits(l);

        //THEN
        assertReversed(l, reversed);
    }

    @Test
    public void testReverse1_4() throws Exception {
        //GIVEN
        long l = -1234567890123L;

        //WHEN
        long reversed = PrimitiveTasks.reverseBits(l);

        //THEN
        assertReversed(l, reversed);
    }

    @Test
    public void testReverse2_1() throws Exception {
        //GIVEN2
        long l = 1234567;

        //WHEN
        long reversed = PrimitiveTasks.reverseBitsWithCache(l);

        //THEN
        assertReversed(l, reversed);
    }

    @Test
    public void testReverse2_2() throws Exception {
        //GIVEN
        long l = Long.MIN_VALUE;

        //WHEN
        long reversed = PrimitiveTasks.reverseBitsWithCache(l);

        //THEN
        assertReversed(l, reversed);
    }

    @Test
    public void testReverse2_3() throws Exception {
        //GIVEN
        long l = Long.MAX_VALUE;

        //WHEN
        long reversed = PrimitiveTasks.reverseBitsWithCache(l);

        //THEN
        assertReversed(l, reversed);
    }

    @Test
    public void testReverse2_4() throws Exception {
        //GIVEN
        long l = -1234567890123L;

        //WHEN
        long reversed = PrimitiveTasks.reverseBitsWithCache(l);

        //THEN
        assertReversed(l, reversed);
    }

    private void assertReversed(long original, long reversed) {
        String originalString = leftPadTo64(Long.toBinaryString(original));
        String reversedString = leftPadTo64(Long.toBinaryString(reversed));

        for (int i = 0; i < 64; i++) {
            assertThat("Wrong bit at position " + i, originalString.charAt(i), equalTo(reversedString.charAt(63 - i)));
        }
    }

    private static String leftPadTo64(String s) {
        while (s.length() != 64) {
            s = "0" + s;
        }

        return s;
    }
}
