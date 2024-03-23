package com.diosa.tgTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.diosa.tgx.Tg.decomposition;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TgTest {
    @Test
    @DisplayName("Check confidence changing")
    public void compareToOriginal() {
        // domain -PI/2 < x < PI/2
        assertAll(
                () -> {
                    assertEquals(Math.tan(Math.PI/4), decomposition(Math.PI/4, 10), 0.00001);
                },
                () -> {
                    assertEquals(Math.tan(Math.PI/2 - 0.4), decomposition(Math.PI/2 - 0.4, 10), 0.01);
                },
                () -> {
                    assertEquals(Math.tan(Math.PI/2 - 0.3), decomposition(Math.PI/2 - 0.3, 10), 0.1);
                },
                () -> {
                    assertEquals(Math.tan(0), decomposition(0, 10), 0.00001);
                }
        );
    }

    @Test
    @DisplayName("Check confidence changing")
    public void compareCustomToPowerSeries() {
        // domain -PI/2 < x < PI/2
        assertAll(
                () -> {
                    assertEquals(tgPowerSeries(Math.PI/2 - 0.56, 10), decomposition(Math.PI/2 - 0.56, 10), 0.1);
                },
                () -> {
                    assertEquals(tgPowerSeries(0, 10), decomposition(0, 10), 0.00001);
                },
                () -> {
                    assertEquals(tgPowerSeries(Math.PI/4, 10), decomposition(Math.PI/4, 10), 0.1);
                }
        );
    }

    @Test
    @DisplayName("Check confidence changing")
    public void failArg() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            decomposition(Math.PI, 10);
        });
        assertTrue(ex.getMessage().contains("Аргумент не попадаетс в область определения"));
    }

    public double tgPowerSeries(double x, int pow) {
        double[] coeff = new double[] {1, (double) 1/3, (double) 2 /15, 17/315, 62/2835, 1382/155925, 21844/6081075, 929569/638512875, 0.0005900, 0.000239};

        double summ = 0;
        double xCurrPow = 1;
        for (int i = 0; i < pow; i++) {
            summ += coeff[i] * Math.pow(x, xCurrPow);
            xCurrPow += 2;
        }
        return summ;
    }
}
