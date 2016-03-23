package com.alex.task.primitive;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ParityTest {

    @Test
    public void testParity1() {
        //GIVEN
        String binaryInput = "0000";

        //WHEN
        byte parity = PrimitiveTasks.parity1(Long.parseLong(binaryInput, 2));

        //THEN
        assertThat(parity, equalTo((byte) 0));
    }

    @Test
    public void testParity2() {
        //GIVEN
        String binaryInput = "1101010010";

        //WHEN
        byte parity = PrimitiveTasks.parity1(Long.parseLong(binaryInput, 2));

        //THEN
        assertThat(parity, equalTo((byte) 1));
    }

    @Test
    public void testParity3() {
        //GIVEN
        String binaryInput = "11101010010";

        //WHEN
        byte parity = PrimitiveTasks.parity1(Long.parseLong(binaryInput, 2));

        //THEN
        assertThat(parity, equalTo((byte) 0));
    }

    @Test
    public void testParity4() {
        //GIVEN
        long input = -2;

        //WHEN
        byte parity = PrimitiveTasks.parity1(input);

        //THEN
        assertThat(parity, equalTo((byte) 1));
    }

    @Test
    public void testParity5() {
        //GIVEN
        long input = -1;

        //WHEN
        byte parity = PrimitiveTasks.parity1(input);

        //THEN
        assertThat(parity, equalTo((byte) 0));
    }

    @Test
    public void testParity6() {
        //GIVEN
        long input = Long.MAX_VALUE;

        //WHEN
        byte parity = PrimitiveTasks.parity1(input);

        //THEN
        assertThat(parity, equalTo((byte) 1));
    }

    @Test
    public void testParity7() {
        //GIVEN
        long input = Long.MIN_VALUE;

        //WHEN
        byte parity = PrimitiveTasks.parity1(input);

        //THEN
        assertThat(parity, equalTo((byte) 1));
    }

    @Test
    public void testParity2_1() {
        //GIVEN
        String binaryInput = "0000";

        //WHEN
        byte parity = PrimitiveTasks.parity2(Long.parseLong(binaryInput, 2));

        //THEN
        assertThat(parity, equalTo((byte) 0));
    }

    @Test
    public void testParity2_2() {
        //GIVEN
        String binaryInput = "1101010010";

        //WHEN
        byte parity = PrimitiveTasks.parity2(Long.parseLong(binaryInput, 2));

        //THEN
        assertThat(parity, equalTo((byte) 1));
    }

    @Test
    public void testParity2_3() {
        //GIVEN
        String binaryInput = "11101010010";

        //WHEN
        byte parity = PrimitiveTasks.parity2(Long.parseLong(binaryInput, 2));

        //THEN
        assertThat(parity, equalTo((byte) 0));
    }

    @Test
    public void testParity2_4() {
        //GIVEN
        long input = -2;

        //WHEN
        byte parity = PrimitiveTasks.parity2(input);

        //THEN
        assertThat(parity, equalTo((byte) 1));
    }

    @Test
    public void testParity2_5() {
        //GIVEN
        long input = -1;

        //WHEN
        byte parity = PrimitiveTasks.parity2(input);

        //THEN
        assertThat(parity, equalTo((byte) 0));
    }

    @Test
    public void testParity2_6() {
        //GIVEN
        long input = Long.MAX_VALUE;

        //WHEN
        byte parity = PrimitiveTasks.parity2(input);

        //THEN
        assertThat(parity, equalTo((byte) 1));
    }

    @Test
    public void testParity2_7() {
        //GIVEN
        long input = Long.MIN_VALUE;

        //WHEN
        byte parity = PrimitiveTasks.parity2(input);

        //THEN
        assertThat(parity, equalTo((byte) 1));
    }
}
