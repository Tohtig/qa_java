package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private final Feline feline = new Feline();

    @Test
    public void getFamilyIsFeeline() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeatShouldMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void getKittensWithoutParametersWillBeSingle() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensGivenTwoReturnTwo() {
        assertEquals(2, feline.getKittens(2));
    }
}
