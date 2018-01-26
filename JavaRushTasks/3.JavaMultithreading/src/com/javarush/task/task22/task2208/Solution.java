package com.javarush.task.task22.task2208;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        String result = params.entrySet().stream().filter(e-> Objects.nonNull(e.getValue())).map(e->String.format("%s = \'%s\'",e.getKey(),e.getValue())).collect(Collectors.joining(" and "));
        return result;
    }
}
