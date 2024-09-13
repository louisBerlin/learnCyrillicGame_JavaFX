package com.example.learnCyrillicGame;

public class Wort {
    private String wort;
    private String artikel;

    public Wort(String wort, String artikel) {
        this.wort = wort;
        this.artikel = artikel;
    }

    public String getWort() {
        return wort;
    }

    public String getArtikel() {
        return artikel;
    }

    public boolean isArtikel(String artikel) {
        return this.artikel.equals(artikel);
    }
}
