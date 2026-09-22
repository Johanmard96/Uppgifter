package com.example.java26.bibblan;

/*Vi kan använda record här eftersom till exempel författare eller titel aldrig kommer att förändras
Lånestatusen kan dock komma att ändras, därför kommer vi att förvara denna separat i Biblioteket.
 */


public record Bok (String isbn, String titel, String författare) {




    public boolean matches(String query) {
        String q = query.toLowerCase();
        return titel.toLowerCase().contains(q) || författare.toLowerCase().contains(q);
    }
}
