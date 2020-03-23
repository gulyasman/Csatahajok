package com.company.Torpedo.kereso;

import com.company.Torpedo.Operator;
import com.company.Torpedo.State;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Melysegi {
    public static Set<Csomopont> nyiltak = new HashSet<>();
    public static Set<Csomopont> zartak = new HashSet<>();

    public static void megoldasKiir(Csomopont csomopont){
        while(csomopont.getSzulo() != null) {
            System.out.println(csomopont.getOperator().getOperaterNev());
            csomopont = csomopont.getSzulo();
        }
    }

    public static State keres(Set<Csomopont> nyiltzart,State state){
        for (Csomopont csomopont:nyiltzart) {
            if(csomopont.getState().equals(state)){
                return state;
            }
        }
        return null;
    }

    public static void kiterjeszt(Csomopont csomopont,List<Operator> operators){
        for (Operator operator:operators) {
            if(operator.elofeltetel(csomopont.getState())){
                State state = operator.lerak(csomopont.getState());
                State ny = keres(nyiltak,state);
                State z = keres(zartak,state);
                if(ny == null && z == null){
                    Csomopont newCsomopont = new Csomopont(state,csomopont,operator,csomopont.getMelyseg()+1);
                    nyiltak.add(newCsomopont);
                }
            }
        }
        nyiltak.remove(csomopont);
        zartak.add(csomopont);
    }

    public static void melysegi(List<Operator> operators, State kezdo){

        Csomopont newCsomopont = new Csomopont(kezdo,null,null,0);
        nyiltak.add(newCsomopont);
        zartak = new HashSet<>();
        Csomopont csomopont = new Csomopont();

        while(true){

            if(nyiltak.isEmpty()){
                break;
            }

            csomopont = nyiltak.stream().max(Comparator.comparing(Csomopont::getMelyseg)).orElseThrow();

            if(csomopont.getState().cel()){
                break;
            }
            kiterjeszt(csomopont,operators);
        }
        if(!nyiltak.isEmpty()){
            megoldasKiir(csomopont);

        }else{
            System.out.println("Nincs megoldas");
        }



    }

}
