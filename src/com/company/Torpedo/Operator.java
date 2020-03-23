package com.company.Torpedo;

import java.util.Set;

public class Operator {
    String fuggolegesVagyVizszintes;
    private int sorIndex;
    private int oszlopIndex;
    private int hajoErtek;
    private String operaterNev;

    public Operator(int sorIndex, int oszlopIndex, int hajoErtek, String fuggolegesVagyVizszintes) {
        this.fuggolegesVagyVizszintes = fuggolegesVagyVizszintes;
        this.sorIndex = sorIndex;
        this.oszlopIndex = oszlopIndex;
        this.hajoErtek = hajoErtek;
        this.operaterNev = fuggolegesVagyVizszintes + "_lerak" + sorIndex + "," + oszlopIndex + "," + hajoErtek;
    }

    public boolean elofeltetel(State state) {

        if (!state.getLerakhato().contains(hajoErtek)) {
            return false;
        }

        if (fuggolegesVagyVizszintes == "v") {

            if (sorIndex < 0 || sorIndex > 4) {
                return false;
            }

            if (oszlopIndex < 0 || oszlopIndex > 2) {
                return false;
            }

            if (state.getS()[sorIndex] != -1 && state.getS()[sorIndex] - hajoErtek < 0) {
                return false;
            }
            for (int i = oszlopIndex; i < oszlopIndex + 3; i++) {
                if (state.getO()[i] != -1 && state.getO()[i] - hajoErtek < 0) {
                    return false;
                }
                if (state.getA()[sorIndex][i] != 0) {
                    return false;
                }
            }
        }
        if (fuggolegesVagyVizszintes == "f") {

            if (sorIndex < 0 || sorIndex > 2) {
                return false;
            }

            if (oszlopIndex < 0 || oszlopIndex > 4) {
                return false;
            }

            if (state.getO()[oszlopIndex] != -1 && state.getO()[oszlopIndex] - hajoErtek < 0) {
                return false;
            }

            for (int y = sorIndex; y < sorIndex + 3; y++) {
                if (state.getS()[y] != -1 && state.getS()[y] - hajoErtek < 0) {
                    return false;
                }
                if (state.getA()[y][oszlopIndex] != 0) {
                    return false;
                }
            }

        }
        return true;
    }

    public State lerak(State state) {

        int[][] resultA = state.getA();
        int[] resultS = state.getS();
        int[] resultO = state.getO();
        Set<Integer> resultLerakhato = state.getLerakhato();

        for (int i = 0; i < 5; i++) {
            if(fuggolegesVagyVizszintes =="v"){
                if (i == oszlopIndex && resultO[i] != -1) {
                    resultO[i] = resultO[i] - hajoErtek;
                }
                if (i == oszlopIndex + 1 && resultO[i] != -1) {
                    resultO[i] = resultO[i] - hajoErtek;
                }
                if (i == oszlopIndex + 2 && resultO[i] != -1) {
                    resultO[i] = resultO[i] - hajoErtek;
                }
                if (i == sorIndex && resultS[i] != -1) {
                    resultS[i] = resultS[i] - hajoErtek;
                }
            }
            if(fuggolegesVagyVizszintes == "f"){
                if (i == oszlopIndex && resultO[i] != -1) {
                    resultO[i] = resultO[i] - hajoErtek;
                }
                if (i == sorIndex && resultS[i] != -1) {
                    resultS[i] = resultS[i] - hajoErtek;
                }
                if (i == sorIndex + 1 && resultS[i] != -1) {
                    resultS[i] = resultS[i] - hajoErtek;
                }
                if (i == sorIndex + 2 && resultS[i] != -1) {
                    resultS[i] = resultS[i] - hajoErtek;
                }
            }
            for (int j = 0; j < 5; j++) {
                if (fuggolegesVagyVizszintes == "v") {
                    if (i == sorIndex && j == oszlopIndex) {
                        resultA[i][j] = hajoErtek;
                    }
                    if (i == sorIndex && j == oszlopIndex + 1) {
                        resultA[i][j] = hajoErtek;
                    }
                    if (i == sorIndex && j == oszlopIndex + 2) {
                        resultA[i][j] = hajoErtek;
                    }

                }
                if (fuggolegesVagyVizszintes == "f") {
                    if (i == sorIndex && j == oszlopIndex) {
                        resultA[i][j] = hajoErtek;
                    }
                    if (i == sorIndex + 1 && j == oszlopIndex) {
                        resultA[i][j] = hajoErtek;
                    }
                    if (i == sorIndex + 2 && j == oszlopIndex) {
                        resultA[i][j] = hajoErtek;
                    }
                }
            }
        }
        resultLerakhato.remove(hajoErtek);
        return new State(resultA, resultS, resultO, resultLerakhato);
    }

    public String getOperaterNev() {
        return operaterNev;
    }
}
