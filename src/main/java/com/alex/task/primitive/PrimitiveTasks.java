package com.alex.task.primitive;

public class PrimitiveTasks {

    private static long[] REVERSE_CACHE = new long[(int) Math.pow(2, 16)];
    static {
        for (int i = 0, n = (int) Math.pow(2, 16); i < n; i++) {
            long l = i;
            for (byte j = 0; j < 8; j++) {
                l = swapBits(l, j, (byte) (15 - j));
            }

            REVERSE_CACHE[i] = l;
        }
    }

    public static void main(String[] args) {
        System.out.println(divide(20, 3));
        System.out.println(123 * 45689);
    }

    /**
     * 0 - number of '1' is even
     * 1 - number of '1' is odd
     */
    public static byte parity1(long l) {
        byte result = 0;

        while (l != 0) {
            result ^= 1;

            //drops off lowest bit
            l = dropOffLowestBit(l);
        }

        return result;
    }

    public static byte parity2(long l) {
        l ^= l >>> 32;
        l ^= l >>> 16;
        l ^= l >>> 8;
        l ^= l >>> 4;
        l ^= l >>> 2;
        l ^= l >>> 1;
        return (byte) (l & 1);
    }

    public static long swapBits(long l, byte b1, byte b2) {
        long mask1 = (l >>> b1) & 1L;
        long mask2 = (l >>> b2) & 1L;

        if (mask1 == mask2) {
            return l;
        }

        long mask = (1L << b1) | (1L << b2);
        return l ^ mask;
    }

    /**
     * same power - same number of '1'
     */
    public static long findClosestSamePower(long l) {
        for (int i = 0; i < 63; i++) {
            //check if 2 bits are of different values
            if (((l >>> i) & 1L) != ((l >>> i + 1) & 1L)) {
                return l ^ ((1L << i) | (1L << i + 1));
            }
        }

        throw new IllegalArgumentException("all 0 or 1");
    }

    public static long reverseBits(long l) {
        for (byte i = 0; i < 32; i++) {
            l = swapBits(l, i, (byte) (63 - i));
        }
        return l;
    }

    public static long reverseBitsWithCache(long l) {
        int wordSize = 16;
        long bitMask = 0xFFFF;
        long part1 = REVERSE_CACHE[(int) (l & bitMask)] << (wordSize * 3);
        long part2 = REVERSE_CACHE[(int) ((l >>> wordSize) & bitMask)] << (wordSize * 2);
        long part3 = REVERSE_CACHE[(int) ((l >>> wordSize * 2) & bitMask)] << wordSize;
        long part4 = REVERSE_CACHE[(int) ((l >>> wordSize * 3) & bitMask)];

        return part1 | part2 | part3 | part4;
    }

    public static long add(long x, long y) {
        long tmpX = x;
        long tmpY = y;

        long res = 0L;
        long mask = 1L;

        long carryOver = 0;

        while (tmpX != 0 || tmpY != 0) {
            long bitX = x & mask;
            long bitY = y & mask;

            long v = bitX ^ bitY ^ carryOver;
            carryOver = ((bitX & bitY) > 0 || (bitX & carryOver) > 0 || (bitY & carryOver) > 0) ? mask << 1 : 0;
            res |= v;

            tmpX >>>= 1;
            tmpY >>>= 1;
            mask <<= 1;
        }

        res |= carryOver;

        return res;
    }

    public static long multiply(long x, long y) {
        long res = 0;

        while (x != 0) {
            if ((x & 1) == 1) {
                res = add(res, y);
            }
            y <<= 1;
            x >>= 1;
        }

        return res;
    }

    public static long divide(long x, long y) {
        long result = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }

            result += 1L << power;
            x -= yPower;
        }
        return result;
    }

    public static double power(double x, int y) {
        double result = 1.0;
        long power = y;
        if (y < 0) {
            power = -power;
            x = 1.0 / x;
        }
        while (power != 0) {
            if ((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return result;
    }

    public static long dropOffLowestBit(long l) {
        return l & (l - 1);
    }
}
