package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;
    private Lion lion;

    @Test
    public void getKittensWithoutParametersWillBeSingle() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        lion = new Lion("Самка", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodShouldMeat() throws Exception {
        lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(new Animal().getFood("Хищник"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood());
    }
}
