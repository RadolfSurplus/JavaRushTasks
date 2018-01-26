package com.javarush.task.task17.task1711;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        SimpleDateFormat simple_input = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat simple_output = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person personality;
        switch (args[0]) {
            case "-c":
                if (args[2].toLowerCase().equals("м"))
                    allPeople.add(Person.createMale(args[1], simple_input.parse(args[3])));
                else
                    allPeople.add(Person.createFemale(args[1], simple_input.parse(args[3])));
                System.out.println(allPeople.size() - 1);
                break;
            case "-u":
                personality = allPeople.get(Integer.parseInt(args[1]));
                personality.setBirthDay(simple_input.parse(args[4]));
                if (args[3].toLowerCase().equals("м"))
                    personality.setSex(Sex.MALE);
                else
                    personality.setSex(Sex.FEMALE);
                personality.setName(args[2]);
                allPeople.set(Integer.parseInt(args[1]), personality);
                break;
            case "-d":
                personality = allPeople.get(Integer.parseInt(args[1]));
                personality.setName(null);
                personality.setSex(null);
                personality.setBirthDay(null);
                allPeople.set(Integer.parseInt(args[1]), personality);
                break;
            case "-i":
                personality = allPeople.get(Integer.parseInt(args[1]));
                String out_sex;
                if (personality.getSex() == Sex.MALE)
                    out_sex = "м";
                else
                    out_sex = "ж";
                System.out.println(personality.getName() + " " + out_sex + " " + simple_output.format(personality.getBirthDay()));
                break;
        }
    }
}
