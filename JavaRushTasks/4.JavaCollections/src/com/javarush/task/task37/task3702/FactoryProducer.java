package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {
    public static enum HumanFactoryType {
        MALE,
        FEMALE
    }

    public static <T extends AbstractFactory> T getFactory(HumanFactoryType factoryType) {
        switch (factoryType) {
            case MALE:
                return (T) new MaleFactory();
            case FEMALE:
                return (T) new FemaleFactory();
            default:
                return null;
        }
    }
}
