package com.project.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssertionTest {

    @Test
    public void hasSize() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 11);
        Assert.assertEquals(Assertion.hasSize(list, 5), list);

        list = Arrays.asList(1);
        Assert.assertEquals(Assertion.hasSize(list, 1), list);

        list = new ArrayList<>();
        Assert.assertEquals(Assertion.hasSize(list, 0), list);
    }

    @Test(expected = AssertionException.class)
    public void hasSizeNull() {
        List<Integer> list = null;
        Assertion.hasSize(list, 5);
    }

    @Test(expected = AssertionException.class)
    public void hasSizeNotEq4() {
        List<Integer> list = Arrays.asList(1, 3, 5, 7, 11);
        Assertion.hasSize(list, 4);
    }

    @Test(expected = AssertionException.class)
    public void hasSizeNotEq0() {
        List<Integer> list = Arrays.asList(1, 3);
        Assertion.hasSize(list, 0);
    }

    @Test
    public void sizeNotLess() {
    }

    @Test
    public void sizeNotMore() {
    }

    @Test
    public void sizeLess() {
    }
}