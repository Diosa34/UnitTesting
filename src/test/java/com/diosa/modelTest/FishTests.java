package com.diosa.modelTest;

import com.diosa.model.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.diosa.model.InfluencingType.*;
import static com.diosa.model.SubstanceState.GASEOUS;
import static com.diosa.model.SubstanceState.LIQUID;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Enclosed.class)
public class FishTests {
    private Fish fish;
    private Environment space;
    private Environment water;
    private Environment ear;

    @BeforeEach
    public void fishInit() {
        fish = new Fish("Маленькая красненькая", FISH);
    }

    @BeforeEach
    public void envInit() {
        space = new Environment("космическая среда", GASEOUS, null, null);
        water = new Environment("вода", LIQUID, null, null);
        ear = new Environment("ухо", GASEOUS, null, null);
    }

    @Test
    @DisplayName("Check confidence changing")
    public void fishSwim() {
        assertAll(
                () -> {
                    fish.swim(space);
                    assertEquals(0, fish.getSpeed());
                },
                () -> {
                    Integer startSpeed = fish.getSpeed();
                    fish.swim(water);
                    assertEquals(startSpeed + 1000, fish.getSpeed());
                },
                () -> {
                    fish.swim(ear);
                    assertEquals(0, fish.getSpeed());
                }
        );
    }
}
