package com.company.Torpedo.kereso;

import com.company.Torpedo.Operator;
import com.company.Torpedo.State;

public class Csomopont {

    private State state;
    private Csomopont szulo;
    private Operator operator;
    private int melyseg;

    public Csomopont(){

    }

    public Csomopont(State state, Csomopont szulo, Operator operator, int melyseg) {
        this.state = state;
        this.szulo = szulo;
        this.operator = operator;
        this.melyseg = melyseg;
    }

    public State getState() {
        return new State(state);
    }

    public void setState(State state) {
        this.state = state;
    }

    public Csomopont getSzulo() {
        return szulo;
    }

    public void setSzulo(Csomopont szulo) {
        this.szulo = szulo;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public int getMelyseg() {
        return melyseg;
    }

    public void setMelyseg(int melyseg) {
        this.melyseg = melyseg;
    }
}
