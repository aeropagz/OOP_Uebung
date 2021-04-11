package Aufgabe1;


public class AdressContainer {
    private Adresse[] myAdressen = new Adresse[25];

    public AdressContainer() {
    }

    public boolean has(final Adresse suche) {
        for (Adresse adresse : this.getAdressen()) {
            if (adresse != null && adresse.vergleiche(suche)) {
                return true;
            }
        }

        return false;
    }

    public AdressContainer insert(final Adresse neueAdresse) {
        if (!this.has(neueAdresse)) {
            for (int adresse = 0; adresse < this.size(); ++adresse) {
                if (this.isInvalidAt(adresse)) {
                    return this.at(adresse, neueAdresse);
                }
            }
        }

        return this;
    }

    public AdressContainer loesche(final Adresse loeschen) {
        for (int adresse = 0; adresse < this.size(); ++adresse) {
            if (this.at(adresse).vergleiche(loeschen)) {
                this.invalidateAt(adresse);
            }
        }

        return this;
    }

    public AdressContainer insert(final String strasse, final int hausnummer, final int PLZ, final String stadt) {
        return this.insert(new Adresse(strasse, hausnummer, PLZ, stadt));
    }

    public final Adresse[] getAdressen() {
        return this.myAdressen;
    }

    private Adresse at(final int index) {
        return this.getAdressen()[index];
    }

    private AdressContainer at(final int index, final Adresse adresse) {
        this.getAdressen()[index] = adresse;
        return this;
    }

    private boolean isInvalidAt(final int index) {
        return this.getAdressen()[index] == null;
    }

    private AdressContainer invalidateAt(final int index) {
        return this.at(index, null);
    }

    private int size() {
        return this.getAdressen().length;
    }

}
