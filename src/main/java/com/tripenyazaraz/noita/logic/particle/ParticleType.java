package com.tripenyazaraz.noita.logic.particle;

import com.tripenyazaraz.noita.logic.particle.Gas.Steam;
import com.tripenyazaraz.noita.logic.particle.Liquid.Water;
import com.tripenyazaraz.noita.logic.particle.Solid.Immovable.Stone;
import com.tripenyazaraz.noita.logic.particle.Solid.Movable.Sand;
import com.tripenyazaraz.noita.logic.particle.Special.EmptyCell;

import java.util.*;
import java.util.stream.Collectors;

public enum ParticleType {

    EMPTYCELL(EmptyCell.class, ClassType.EMPTYCELL) {
        @Override
        public Particle createElementByMatrix(int y, int x) {
            return new EmptyCell(y, x);
        }
    },
    STEAM(EmptyCell.class, ClassType.GAS) {
        @Override
        public Particle createElementByMatrix(int y, int x) {
            return new Steam(y, x);
        }
    },
    WATER(EmptyCell.class, ClassType.LIQUID) {
        @Override
        public Particle createElementByMatrix(int y, int x) {
            return new Water(y, x);
        }
    },
    STONE(EmptyCell.class, ClassType.IMMOVABLE_SOLID) {
        @Override
        public Particle createElementByMatrix(int y, int x) {
            return new Stone(y, x);
        }
    },
    SAND(EmptyCell.class, ClassType.MOVABLE_SOLID) {
        @Override
        public Particle createElementByMatrix(int y, int x) {
            return new Sand(y, x);
        }
    };

    public final Class<? extends Particle> clazz;
    public final ClassType classType;
    public static List<ParticleType> IMMOVABLE_SOLIDS;
    public static List<ParticleType> MOVABLE_SOLIDS;
    public static List<ParticleType> SOLIDS;
    public static List<ParticleType> LIQUIDS;
    public static List<ParticleType> GASSES;

    ParticleType(Class<? extends Particle> clazz, ClassType classType) {
        this.clazz = clazz;
        this.classType = classType;
    }

    public abstract Particle createElementByMatrix(int y, int x);

    public static List<ParticleType> getGasses() {
        if (GASSES == null) {
            GASSES = initializeList(ClassType.GAS);
            GASSES.sort(Comparator.comparing(Enum::toString));
        }
        return Collections.unmodifiableList(GASSES);
    }

    public static List<ParticleType> getLiquids() {
        if (LIQUIDS == null) {
            LIQUIDS = initializeList(ClassType.LIQUID);
            LIQUIDS.sort(Comparator.comparing(Enum::toString));
        }
        return Collections.unmodifiableList(LIQUIDS);
    }

    public static List<ParticleType> getSolids() {
        if (SOLIDS == null) {
            List<ParticleType> immovables = new ArrayList<>(getImmovableSolids());
            immovables.addAll(getMovableSolids());
            SOLIDS = immovables;
            immovables.sort(Comparator.comparing(Enum::toString));
        }
        return Collections.unmodifiableList(SOLIDS);
    }
    public static List<ParticleType> getImmovableSolids() {
        if (IMMOVABLE_SOLIDS == null) {
            IMMOVABLE_SOLIDS = initializeList(ClassType.IMMOVABLE_SOLID);
            IMMOVABLE_SOLIDS.sort(Comparator.comparing(Enum::toString));
        }
        return Collections.unmodifiableList(IMMOVABLE_SOLIDS);
    }

    public static List<ParticleType> getMovableSolids() {
        if (MOVABLE_SOLIDS == null) {
            MOVABLE_SOLIDS = initializeList(ClassType.MOVABLE_SOLID);
            MOVABLE_SOLIDS.sort(Comparator.comparing(Enum::toString));
        }
        return Collections.unmodifiableList(MOVABLE_SOLIDS);
    }

    private static List<ParticleType> initializeList(ClassType classType) {
        return Arrays.stream(ParticleType.values()).filter(elementType -> elementType.classType.equals(classType)).collect(Collectors.toList());
    }

    public enum ClassType {
        EMPTYCELL,
        GAS,
        LIQUID,
        IMMOVABLE_SOLID,
        MOVABLE_SOLID
    }
}
