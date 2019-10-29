package com.example.hw733testunitandmockito.model;

import com.example.hw733testunitandmockito.testmodel.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyModelTest {

    private Model model;

    @Before
    public void before() {
        model = new Model();
    }

    @Test
    public void testSumm_whenSome_is_good() {
        int x = 1;
        int y = 2;
        int correctResult = 3;
        int result = model.summ(x, y);
        Assert.assertEquals(result, correctResult);
    }

    @Test
    public void testSumm_when_some_is_not_good() {
        int x = 1;
        int y = 2;
        int incorrectResult = 4;
        int result = model.summ(x, y);
        Assert.assertNotEquals(result, incorrectResult);
    }
}
