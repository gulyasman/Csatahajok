package com.company;

import com.company.Torpedo.Operator;
import com.company.Torpedo.State;
import com.company.Torpedo.kereso.Melysegi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Operator> operators = new ArrayList<>();
        int[][] a = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int[] s = {-1, -1, -1, -1, 9};
        int[] o = {-1, 0, 7, 3, 6};
        Set<Integer> lerakhato = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        State kezdo = new State(a, s, o, lerakhato);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int t = 1; t <= 5; t++) {
                    operators.add(new Operator(i, j, t, "v"));

                    operators.add(new Operator(i, j, t, "f"));
                }
            }
        }

        Melysegi.melysegi(operators,kezdo);
        //System.out.println(-4 != -1 && -4 - 5 < 0);

        /*
        List<State> states = new ArrayList<>();
        states.add(kezdo);
        kezdo = operators.get(22).lerak(kezdo);
        states.add(kezdo);

        kezdo = operators.get(23).lerak(kezdo);
        states.add(kezdo);

        for (State stater:states) {
            stater.writeState();
        }*/



        /*
        int i = 0;
        for (Operator operator:operators) {
            System.out.println(i+": "+operator.getOperaterNev());
            i++;
        }

         */

        /*
        List<State> states = new ArrayList<>();

        System.out.println(operators.get(22).elofeltetelint(kezdo));
        State state1 = operators.get(22).lerak(kezdo);

        System.out.println(operators.get(97).elofeltetelint(state1));
        State state2 = operators.get(97).lerak(state1);

        System.out.println(operators.get(131).elofeltetelint(state2));
        State state3 = operators.get(131).lerak(state2);

        System.out.println(operators.get(129).elofeltetelint(state3));
        State state4 = operators.get(129).lerak(state3);

        System.out.println(operators.get(105).elofeltetelint(state4));
        State state5 = operators.get(105).lerak(state4);


        states.add(kezdo);
        states.add(state1);
        states.add(state2);
        states.add(state3);
        states.add(state4);
        states.add(state5);

        for (State state:states) {
            state.writeState();
        }

        System.out.println(state5.isCel());
        */
    }
}
