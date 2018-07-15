package dz3;

import java.util.HashMap;

public class dzOsnova1 {
    public static void main(String[] args) {
        String[] mass=
                {"Vova",
                "Petya",
                "Petya",
                "Vasya",
                "Petr",
                "Verwolf",
                "Constantin",
                "Max",
                "Constantin",
                "Max",
                "Constantin",
                "Ilya",
                "Cornelius",
                "Archer",
                "Vanya"};
        HashMap<String,Integer> hm = new HashMap<>();
        for (int i = 0; i <mass.length; i++) {
            Integer value= hm.get(mass[i]);
            hm.put(mass[i],(value==null) ? 1: value+1);
        }
        System.out.println(hm);

    }
}
