package com.example.java26.bibblan;

public class Medlem {
    private static final int MAX_AKTIVA_LÅN = 3;

    private final int id;
    private final String namn;
    private int aktivaLån = 0;

    public Medlem(int id, String namn) {
        this.id = id;
        this.namn = namn;
        this.aktivaLån = 0;
    }

    public int getId() {
        return id;
    }
    public String getNamn() {
        return namn;
    }
    public int getAktivaLån () {
        return aktivaLån;

    }

    //egen metod för att avgöra om medlemmen får låna fler böcker.

    public boolean fårLåna() {
        return aktivaLån < MAX_AKTIVA_LÅN;
    }

    //Paketprivata metoder för att synka lån

    void ökaLån() {
        aktivaLån++;
    }

    void minskaLån() {
        if (aktivaLån > 0) {
            aktivaLån--;
        }

    }

        @Override
                public String toString() {
            return "#" + id + " " + namn + " (aktiva lån: " + aktivaLån + ")";
        }
        }