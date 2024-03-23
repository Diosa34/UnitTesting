package com.diosa;

import com.diosa.model.*;
import com.diosa.sorting.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.diosa.model.InfluencingType.*;
import static com.diosa.model.SubstanceState.GASEOUS;
import static com.diosa.model.SubstanceState.LIQUID;
import static com.diosa.tgx.Tg.*;

public class Main {
    public static void main(String[] args) {
        double x = Math.PI/2 - 0.1;
        int m = 10;
        System.out.println("tg ("+ x + ") = " + decomposition(x, m));
        System.out.println(getFactorial(20));



//        int ELEMENTS_NUMBER = 30;
//        int MAX_VALUE = 999;
//        int BUCKET_DEPTH = 5;
//
//        HashTable hashTable = new HashTable(ELEMENTS_NUMBER, MAX_VALUE, BUCKET_DEPTH);
//        hashTable.bucketSort();



//        domainModel();
    }

    private static void domainModel() {
        HashMap<InfluencingType, Integer> fordConfidence = new HashMap<>();
        fordConfidence.put(FISH, 500);
        fordConfidence.put(DENTRASSI_UNDERWEAR, 0);
        fordConfidence.put(SKVORNSHELSKY_MATTRESSES, 20);
        fordConfidence.put(CORNFLAKES, 0);
        Ford ford = new Ford("Форд", fordConfidence);

        HashMap<InfluencingType, Integer> arturConfidence = new HashMap<>();
        arturConfidence.put(FISH, -200);
        arturConfidence.put(DENTRASSI_UNDERWEAR, -100);
        arturConfidence.put(SKVORNSHELSKY_MATTRESSES, -100);
        arturConfidence.put(CORNFLAKES, 1000);
        Artur artur = new Artur("Артур", arturConfidence);

        Fish fish = new Fish("маленькая желтая рыбка", FISH);
        InteriorItem dentrassiUnderwear = new InteriorItem("нижнее белье дентрасси", DENTRASSI_UNDERWEAR);
        InteriorItem skvornshelMattresses = new InteriorItem("скворншельские матрацы", SKVORNSHELSKY_MATTRESSES);
        InteriorItem cornflakes = new InteriorItem("пакет кукурузных хлопьев", CORNFLAKES);

        ArrayList<InteriorItem> allObjects = new ArrayList<>(List.of(dentrassiUnderwear, skvornshelMattresses));
        Environment space = new Environment("космическая среда", GASEOUS, new ArrayList<>(List.of(ford, artur)), allObjects);
        Environment water = new Environment("вода", LIQUID, null, new ArrayList<>(List.of(fish)));
        Environment ear = new Environment("ухо", GASEOUS, null, new ArrayList<>(List.of(fish)));

        System.out.println(ford.getName() + " и " + artur.getName() + "находятся сейчас в месте под названием" + space.getName());
        System.out.println(ford.getName() + " держит стеклянный флакончик, внутри которого существует уже другая среда обитания — " + water.getName() + ". В этой среде находится" + fish.getName());
        fish.swim(water);
        System.out.println("Когда " + fish.getName() + " в воде, её скорост бесконечно растёт. Сейчас, например, скорость рыбки " + fish.getSpeed());
        fish.swim(space);
        System.out.println("Если рыбку поместить на сушу, её скорость мгновенно станет " + fish.getSpeed());

        System.out.println("До этого состояние Артура было нейтральным, уровень страха и уверенности " + artur.getConfidence());
        artur.see(allObjects);
        System.out.println(artur.getName() + " видит вокруг " + dentrassiUnderwear.getName() + ", " + skvornshelMattresses.getName());
        System.out.println("Эти предметы вокруг влияют на его уверенность: брошенное " + dentrassiUnderwear.getName() + " — " + arturConfidence.get(DENTRASSI_UNDERWEAR) + ", "
        + skvornshelMattresses.getName() + " " + arturConfidence.get(SKVORNSHELSKY_MATTRESSES));
        System.out.println(artur.getName() + " и его уверенность сейчас: " + artur.getConfidence());
        System.out.println("Он чувствовал бы себя увереннее на " + arturConfidence.get(CORNFLAKES) + ", если бы рядом он увидел, к примеру, " + cornflakes.getName());

        System.out.println(ford.getName() + " диаметрально противоположен Артуру.");
        ford.hold(allObjects);
        System.out.println("Его уверенность сейчас " + ford.getConfidence());
        System.out.println("Её определяют: обладание рыбой — " + fordConfidence.get(FISH) + ", брошенное " + dentrassiUnderwear.getName() + " — " + fordConfidence.get(DENTRASSI_UNDERWEAR) + ", "
                + skvornshelMattresses.getName() + " — " + fordConfidence.get(SKVORNSHELSKY_MATTRESSES));

        System.out.println("Если бы " + ford.getName() + " сделал так, что " + fish.getName() + " оказалась в среде под названием " + ear.getName() + ", её скорость неизбежно стала бы " + ford.moveFishToEar(fish));
        System.out.println("При одном виде этой рыбки, уверенность артура становится " + arturConfidence.get(CORNFLAKES));
    }
}

