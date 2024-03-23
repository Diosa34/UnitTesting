package com.diosa.modelTest;

import com.diosa.model.Artur;
import com.diosa.model.Ford;
import com.diosa.model.InfluencingType;
import com.diosa.model.InteriorItem;
import org.junit.experimental.runners.Enclosed;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.diosa.model.InfluencingType.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Enclosed.class)
public class HumanTests {
    private ArrayList<InteriorItem> allObjects;

    @BeforeEach
    public void interiorObjectsInit() {
        InteriorItem dentrassiUnderwear = new InteriorItem("нижнее белье дентрасси", DENTRASSI_UNDERWEAR);
        InteriorItem skvornshelMattresses = new InteriorItem("скворншельские матрацы", SKVORNSHELSKY_MATTRESSES);

        allObjects = new ArrayList<>(List.of(dentrassiUnderwear, skvornshelMattresses));
    }

    @Nested
    public class ArturTest {
        HashMap<InfluencingType, Integer> arturConfidence;
        Artur artur;

        @BeforeEach
        public void arturInit() {
            arturConfidence = new HashMap<>();
            arturConfidence.put(FISH, -200);
            arturConfidence.put(DENTRASSI_UNDERWEAR, -100);
            arturConfidence.put(SKVORNSHELSKY_MATTRESSES, -100);
            arturConfidence.put(CORNFLAKES, 1000);

            artur = new Artur("Артур", arturConfidence);
        }

        @Test
        @DisplayName("Check confidence changing")
        public void checkConfidenceChange() {
            assertAll(
                    () -> {
                        artur.setConfidence(1000);
                        assertEquals(1000, artur.getConfidence());
                    },
                    () -> {

                        artur.setConfidence(-20);
                        assertEquals(-20, artur.getConfidence());
                    },
                    () -> {
                        artur.setConfidence(-0);
                        assertEquals(-0, artur.getConfidence());
                    }
            );
        }

        @Test
        @DisplayName("Check confidence changing")
        public void checkArturSee() {
            assertAll(
                    () -> {
                        Integer startConfidence = artur.getConfidence();
                        arturConfidence.put(DENTRASSI_UNDERWEAR, -100);
                        arturConfidence.put(SKVORNSHELSKY_MATTRESSES, -100);
                        artur.see(allObjects);
                        assertEquals(startConfidence-200, artur.getConfidence());
                    },
                    () -> {
                        Integer startConfidence = artur.getConfidence();
                        arturConfidence.put(DENTRASSI_UNDERWEAR, -1000);
                        arturConfidence.put(SKVORNSHELSKY_MATTRESSES, 500);
                        artur.see(allObjects);
                        assertEquals(startConfidence-500, artur.getConfidence());
                    },
                    () -> {
                        Integer startConfidence = artur.getConfidence();
                        arturConfidence.put(DENTRASSI_UNDERWEAR, 0);
                        arturConfidence.put(SKVORNSHELSKY_MATTRESSES, 0);
                        artur.see(allObjects);
                        assertEquals(startConfidence, artur.getConfidence());
                    }
            );
        }
    }

    @Nested
    public class FordTest {
        HashMap<InfluencingType, Integer> fordConfidence = new HashMap<>();
        Ford ford;

        @BeforeEach
        public void fordInit() {
            fordConfidence = new HashMap<>();
            fordConfidence.put(FISH, 500);
            fordConfidence.put(DENTRASSI_UNDERWEAR, 0);
            fordConfidence.put(SKVORNSHELSKY_MATTRESSES, 20);
            fordConfidence.put(CORNFLAKES, 0);

            ford = new Ford("Форд", fordConfidence);
        }

        @Test
        @DisplayName("Check confidence changing")
        public void checkFordHold() {
            assertAll(
                    () -> {
                        fordConfidence.put(DENTRASSI_UNDERWEAR, -100);
                        fordConfidence.put(SKVORNSHELSKY_MATTRESSES, -100);
                        ford.hold(allObjects);
                        assertEquals(-200, ford.getConfidence());
                    },
                    () -> {
                        fordConfidence.put(DENTRASSI_UNDERWEAR, -1000);
                        fordConfidence.put(SKVORNSHELSKY_MATTRESSES, 500);
                        ford.hold(allObjects);
                        assertEquals(-500, ford.getConfidence());
                    },
                    () -> {
                        fordConfidence.put(DENTRASSI_UNDERWEAR, 0);
                        fordConfidence.put(SKVORNSHELSKY_MATTRESSES, 0);
                        ford.hold(allObjects);
                        assertEquals(0, ford.getConfidence());
                    }
            );
        }
    }
}

