package org.toyota;

import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String[] ar = {"1", "2"};
        List<Integer> integers = List.of(1, 2);
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
        };

        for (String s : ar) {

        }

    }

    public static void someActions(String text) {
        if (text == null) {
            return;
        }

        System.out.println(text);
        //Действия

    }
}
