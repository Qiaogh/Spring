package com.qiaogh.util;

public class ArrayUtils {

    public static int size( int[][] results ) {
        int size = 0;
        for ( int i = 0; i < results.length; i++ ) {
            size += results[i].length;
        }
        return size;
    }
}
