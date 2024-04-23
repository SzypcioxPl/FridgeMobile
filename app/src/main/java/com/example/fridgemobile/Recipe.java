package com.example.fridgemobile;

import java.io.Serializable;

public class Recipe implements Serializable {
    private String nazwa;
    private String proporcja; // Może być zapisana jako String, jeśli zawiera znaki procentowe

    public Recipe(String nazwa, String proporcja) {
        this.nazwa = nazwa;
        this.proporcja = proporcja;
    }

    // Gettery i Settery
    public String getNazwa() {
        return nazwa;
    }

    public String getProporcja() {
        return proporcja;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setProporcja(String proporcja) {
        this.proporcja = proporcja;
    }
}
