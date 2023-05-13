package cn.fengqingyang;

import java.util.ArrayList;
import java.util.List;

public class ArrayOutputChallenge {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Arya");
        list.add("Tyrion");
        list.add("Cersei");
        list.add("Daenervs");
        list.add("Jaime");

        doProcess(list); // ConcurrentModificationException

        System.out.println(list);
    }

    private static void doProcess(List<String> list) {
        for (String character: list) {
            if (character.equals("Cersei")) {
                // list.remove(character);
            }
        }
    }
}
