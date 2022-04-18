package com.tripenyazaraz.noita;

import java.util.List;

public class Const {

    public static final int FIELD_WIDTH = 1080;
    public static final int FIELD_HEIGHT = 1080;
    public static final int SIDEBAR_WIDTH = 340;

    public static final int MOUSE_SUMMON_WIDTH = 10;
    public static final int MOUSE_SUMMON_HEIGHT = 10;

    public static List<String> getParticlesNames() {
        return List.of("Steam", "Sand", "Water", "Stone");
    }

    public static String getClassByName(String className) {
        return switch (className.toLowerCase()) {
            case ("steam") -> "com.tripenyazaraz.noita.particle.gas.Steam";
            case ("sand")  -> "com.tripenyazaraz.noita.particle.powder.Sand";
            case ("water") -> "com.tripenyazaraz.noita.particle.liquid.Water";
            case ("stone") -> "com.tripenyazaraz.noita.particle.solid.Stone";
            case ("void")  -> "com.tripenyazaraz.noita.particle.special.Void";
            default -> "com.tripenyazaraz.noita.particle.special.Void";
        };
    }
}
