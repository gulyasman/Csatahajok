package com.company.Torpedo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class State {
    private int[][] a = new int[5][5];
    private int[] s = new int[5];
    private int[] o = new int[5];
    private Set<Integer> lerakhato = new HashSet<Integer>();

    public State() {

    }

    public State(int[][] a, int[] s, int[] o, Set<Integer> lerakhato) {
        this.a = a;
        this.s = s;
        this.o = o;
        this.lerakhato = lerakhato;
    }

    public State(State state) {
        this.a = state.a;
        this.s = state.s;
        this.o = state.o;
        this.lerakhato = state.lerakhato;
    }

    public int[][] getA() {
        return new int[][]{
                {a[0][0], a[0][1], a[0][2], a[0][3], a[0][4]},
                {a[1][0], a[1][1], a[1][2], a[1][3], a[1][4]},
                {a[2][0], a[2][1], a[2][2], a[2][3], a[2][4]},
                {a[3][0], a[3][1], a[3][2], a[3][3], a[3][4]},
                {a[4][0], a[4][1], a[4][2], a[4][3], a[4][4]}
        };
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    public int[] getS() {
        return new int[]{s[0], s[1], s[2], s[3], s[4]};
    }

    public void setS(int[] s) {
        this.s = s;
    }

    public int[] getO() {
        return new int[]{o[0], o[1], o[2], o[3], o[4]};
    }

    public void setO(int[] o) {
        this.o = o;
    }

    public Set<Integer> getLerakhato() {
        return new HashSet<>(lerakhato);

    }

    public void setLerakhato(Set<Integer> lerakhato) {
        this.lerakhato = lerakhato;
    }

    public void writeState() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println(s[i]);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(o[i] + " ");
        }
        System.out.print("\nLerakhato: {");
        for (int i : lerakhato) {
            System.out.print(i + ",");
        }
        System.out.println("}");
    }

    public boolean cel() {
        for (int i = 0; i < 5; i++) {
            if (s[i] != 0 && s[i] != -1){
                return false;
            }
            if(o[i] != 0 && o[i] != -1){
                return false;
            }
        }
        if(!lerakhato.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || getClass() != o1.getClass()) return false;
        State state = (State) o1;
        return Arrays.equals(a, state.a) &&
                Arrays.equals(s, state.s) &&
                Arrays.equals(o, state.o) &&
                Objects.equals(lerakhato, state.lerakhato);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(lerakhato);
        result = 31 * result + Arrays.hashCode(a);
        result = 31 * result + Arrays.hashCode(s);
        result = 31 * result + Arrays.hashCode(o);
        return result;
    }
}
