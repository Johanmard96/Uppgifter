package com.example.java26.bibblan;

public class Bibliotek {
    private static final int ANTAL_BOK = 4;

    private Bok[] böcker;
    private int[] lånadAvId;
    private int bokAntal;

    private Medlem[] medlemmar;
    private int medlemAntal;
    private int nextMedlemId = 1;

    public Bibliotek() {
        böcker = new Bok[ANTAL_BOK];
        lånadAvId = new int[ANTAL_BOK];
        medlemmar = new Medlem[ANTAL_BOK];
    }

    public boolean nyBok(Bok bok) {
        if (bokIndexIsbn(bok.isbn()) != -1) {
            return false;
        }

        bokKapacitet();
        böcker[bokAntal] = bok;
        lånadAvId[bokAntal] = -1;
        bokAntal++;
        return true;
    }

    public Medlem registreraMedlem(String namn) {
        medlemKapacitet();
        Medlem medlem = new Medlem(nextMedlemId++, namn);
        medlemmar[medlemAntal++] = medlem;
        return medlem;
    }

    private void bokKapacitet() {
        if (bokAntal == böcker.length) {
            int nyKapacitet = böcker.length * 2;
            Bok[] nyaBöcker = new Bok[nyKapacitet];
            int[] nyttLån = new int[nyKapacitet];
            for (int i = 0; i < böcker.length; i++) {
                nyaBöcker[i] = böcker[i];
                nyttLån[i] = lånadAvId[i];
            }
            böcker = nyaBöcker;
            lånadAvId = nyttLån;
            IO.println("(Bokarrayen var full - växte automatiskt till " + nyKapacitet + ")");
        }
    }

    private void medlemKapacitet() {
        if (medlemAntal == medlemmar.length) {
            int nyKapacitet = medlemmar.length * 2;
            Medlem[] nyaMedlemmar = new Medlem[nyKapacitet];
            for (int i = 0; i < medlemmar.length; i++) {
                nyaMedlemmar[i] = medlemmar[i];
            }
            medlemmar = nyaMedlemmar;
            IO.println("(Medlemsarrayen var full - växte automatiskt till " + nyKapacitet + ")");
        }
    }

    private int bokIndexIsbn(String isbn) {
        for (int i = 0; i < bokAntal; i++) {
            if (böcker[i].isbn().equalsIgnoreCase(isbn)) {
                return i;
            }
        }
        return -1;
    }

    private Medlem hittaMedlemId(int id) {
        for (int i = 0; i < medlemAntal; i++) {
            if (medlemmar[i].getId() == id) {
                return medlemmar[i];
            }
        }
        return null;
    }

    public Bok[] search(String query) {
        Bok[] hits = new Bok[bokAntal];
        int found = 0;
        for (int i = 0; i < bokAntal; i++) {
            if (böcker[i].matches(query)) {
                hits[found++] = böcker[i];
            }
        }
        Bok[] trimmed = new Bok[found];
        for (int i = 0; i < found; i++) {
            trimmed[i] = hits[i];
        }
        return trimmed;
    }

    public String lånadBok(String isbn, int medlemId) {
        int bokIndex = bokIndexIsbn(isbn);
        if (bokIndex == -1) {
            return "Hittade inte ISBN " + isbn + ".";
        }
        if (lånadAvId[bokIndex] != -1) {
            return "Boken \"" + böcker[bokIndex].titel() + "\" är redan utlånad.";
        }
        Medlem medlem = hittaMedlemId(medlemId);
        if (medlem == null) {
            return "Hittade ingen medlem med id " + medlemId + ".";
        }
        if (!medlem.fårLåna()) {
            return medlem.getNamn() + " har redan max antal aktiva lån.";
        }
        lånadAvId[bokIndex] = medlemId;
        medlem.ökaLån();
        return "\"" + böcker[bokIndex].titel() + "\" utlånad till " + medlem.getNamn() + ".";
    }

    public String återlämnaBok(String isbn) {
        int bokIndex = bokIndexIsbn(isbn);
        if (bokIndex == -1) {
            return "Hittade inte ISBN " + isbn + ".";
        }
        int medlemId = lånadAvId[bokIndex];
        if (medlemId == -1) {
            return "Boken \"" + böcker[bokIndex].titel() + "\" är inte utlånad.";
        }
        Medlem medlem = hittaMedlemId(medlemId);
        lånadAvId[bokIndex] = -1;
        if (medlem != null) {
            medlem.minskaLån();
        }
        return "\"" + böcker[bokIndex].titel() + "\" är nu återlämnad.";
    }

    public void visaBöckerEfterTitel() {
        if (bokAntal == 0) {
            IO.println("Inga böcker registrerade ännu.");
            return;
        }
        Bok[] sortera = kopiaBöcker();
        sorteraEfterTitel(sortera);

        IO.println("Böcker efter titel:");
        for (Bok b : sortera) {
            int originalIndex = bokIndexIsbn(b.isbn());
            IO.println(" " + b.titel() + " - " + b.författare() + " " +
                    "(ISBN " + b.isbn() + ") " + statusText(originalIndex));
        }
    }

    private Bok[] kopiaBöcker() {
        Bok[] kopia = new Bok[bokAntal];
        for (int i = 0; i < bokAntal; i++) {
            kopia[i] = böcker[i];
        }
        return kopia;
    }

    private void sorteraEfterTitel(Bok[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].titel().compareToIgnoreCase(arr[minIndex].titel()) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Bok temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    private String statusText(int bokIndex) {
        int medlemId = lånadAvId[bokIndex];
        if (medlemId == -1) {
            return "[Tillgänglig]";
        }
        Medlem m = hittaMedlemId(medlemId);
        String namn = (m != null) ? m.getNamn() : "okänd medlem";
        return "[Utlånad till " + namn + "]";
    }

    public Medlem flestLån() {
        if (medlemAntal == 0) {
            return null;
        }
        Medlem top = medlemmar[0];
        for (int i = 1; i < medlemAntal; i++) {
            if (medlemmar[i].getAktivaLån() > top.getAktivaLån()) {
                top = medlemmar[i];
            }
        }
        return top;
    }
}