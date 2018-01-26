package com.javarush.task.task17.task1710;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        Person p = null;
        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    for (int i = 0, l = args.length - 1; i < l; i += 3) {
                        if ("м".equals(args[2 + i]))
                            allPeople.add(p = Person.createMale(args[1 + i], new SimpleDateFormat("dd/MM/yyyy").parse(args[3 + i])));
                        else if ("ж".equals(args[2 + i]))
                            allPeople.add(p = Person.createFemale(args[1 + i], new SimpleDateFormat("dd/MM/yyyy").parse(args[3 + i])));
                        System.out.println(allPeople.indexOf(p));
                    }
                }
                break;
            }
            case "-u": {
                synchronized (allPeople) {
                    for (int i = 0, l = args.length - 1; i < l; i += 4) {
                        p = allPeople.get(Integer.parseInt(args[1 + i]));
                        p.setName(args[2 + i]);
                        if ("м".equals(args[3 + i])) p.setSex(Sex.MALE);
                        else if ("ж".equals(args[3 + i])) p.setSex(Sex.FEMALE);
                        p.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4 + i]));
                    }
                }
                break;
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1, l = args.length; i < l; ) {
                        p = allPeople.get(Integer.parseInt(args[i++]));
                        p.setName(null);
                        p.setSex(null);
                        p.setBirthDay(null);
                    }
                }
                break;
            }
            case "-i": {
                synchronized (allPeople) {
                    for (int i = 1, l = args.length; i < l; ) {
                        p = allPeople.get(Integer.parseInt(args[i++]));
                        System.out.println(p.getName() + " " + (p.getSex().equals(Sex.MALE) ? "м" : p.getSex().equals(Sex.FEMALE) ? "ж" : null) + new SimpleDateFormat(" dd-MMM-yyyy", Locale.ENGLISH).format(p.getBirthDay()));
                    }
                }
                break;
            }
        }
    }
}


