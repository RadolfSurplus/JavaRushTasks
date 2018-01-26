package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class FemaleFactory implements AbstractFactory {
    public <T extends Human> T getPerson(int age) {
        if (age <= KidGirl.MAX_AGE && age > 0)
            return (T) new KidGirl();
        if (age > KidGirl.MAX_AGE && age <= TeenGirl.MAX_AGE)
            return (T) new TeenGirl();
        return (T) new Woman();
    }
}
