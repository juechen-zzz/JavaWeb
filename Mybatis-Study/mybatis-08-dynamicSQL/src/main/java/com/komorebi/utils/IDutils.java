package com.komorebi.utils;

import org.junit.Test;

import java.util.UUID;

public class IDutils {
    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Test
    public void test() {
        System.out.println(IDutils.getId());
    }
}
