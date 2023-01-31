package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionDoesHaveManeTest {

    private final String lionSex;
    @Mock
    Feline feline;
    public LionDoesHaveManeTest(String lionSex) {
        this.lionSex = lionSex;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] setLionSex() {
        return new Object[][]{
                {"Самец"},
                {"Самка"},
                {"Плюшевая игрушка"}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(feline.getKittens()).thenReturn(1);
    }

    @Test
    public void doesHaveManeDependsOnParameters() {
        try {
            Lion lion = new Lion(lionSex, feline);
            if (lionSex.equals("Самец")) {
                assertTrue(lion.doesHaveMane());
            } else if (lionSex.equals("Самка")) {
                assertFalse(lion.doesHaveMane());
            }
        } catch (Exception e) {
            String expected = "Используйте допустимые значения пола животного - Самец или Самка";
            assertEquals(expected, e.getMessage());
        }
    }
}