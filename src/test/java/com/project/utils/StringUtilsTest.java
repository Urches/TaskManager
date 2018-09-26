package com.project.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void isNotBlank() {
        Assert.assertFalse(StringUtils.isNotBlank(null));
        Assert.assertFalse(StringUtils.isNotBlank(""));

        Assert.assertTrue(StringUtils.isNotBlank(" "));
        Assert.assertTrue(StringUtils.isNotBlank("."));
        Assert.assertTrue(StringUtils.isNotBlank("Str"));

        String str = "String";
        Assert.assertEquals(StringUtils.isNotBlank(str), !StringUtils.isNotBlank(str));
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(StringUtils.isNotBlank(null));
        Assert.assertTrue(StringUtils.isNotBlank(""));

        Assert.assertFalse(StringUtils.isNotBlank(" "));
        Assert.assertFalse(StringUtils.isNotBlank("."));
        Assert.assertFalse(StringUtils.isNotBlank("Str"));

        String str = "String";
        Assert.assertEquals(!StringUtils.isNotBlank(str), StringUtils.isNotBlank(str));
    }
}