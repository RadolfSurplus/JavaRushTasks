package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {
    public <T extends Human> T getPerson(int age) {
        if (age <= KidBoy.MAX_AGE && age > 0)
            return (T) new KidBoy();
        if (age > KidBoy.MAX_AGE && age <= TeenBoy.MAX_AGE)
            return (T) new TeenBoy();
        return (T) new Man();
    }
}
