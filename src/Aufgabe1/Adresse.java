package Aufgabe1;

public class Adresse {
    private int myPLZ = 0;
    private int myHnr = 0;
    private String myStrasse = null;
    private String myStadt = null;

    public Adresse(final String strasse, final int hnr, final int PLZ, final String stadt) {
        super();
        this.setPLZ(PLZ).setStadt(stadt).setStrasse(strasse).setHnr(hnr);
    }

    public Adresse() {
    }

    public boolean istStadt(final String stadt) {
        return this.getStadt().equals(stadt);
    }

    public boolean istStrasse(final String strasse) {
        return this.getStrasse().equals(strasse);
    }

    public boolean istPLZ(final int PLZ) {
        return this.getPLZ() == PLZ;
    }

    public boolean istHnr(final int hnr) {
        return this.getHnr() == hnr;
    }

    /**
     * @return the PLZ
     */
    public final int getPLZ() {
        return this.myPLZ;
    }

    /**
     * @param PLZ the PLZ to set
     */
    private final Adresse setPLZ(final int PLZ) {
        this.myPLZ = PLZ;
        return this;
    }

    /**
     * @return the hnr
     */
    public final int getHnr() {
        return this.myHnr;
    }

    /**
     * @param hnr the hnr to set
     */
    private final Adresse setHnr(final int hnr) {
        this.myHnr = hnr;
        return this;
    }

    /**
     * @return the strasse
     */
    public final String getStrasse() {
        return this.myStrasse;
    }

    /**
     * @param strasse the strasse to set
     */
    private final Adresse setStrasse(final String strasse) {
        this.myStrasse = strasse;
        return this;
    }

    /**
     * @return the stadt
     */
    public final String getStadt() {
        return this.myStadt;
    }

    /**
     * @param stadt the stadt to set
     */
    private final Adresse setStadt(final String stadt) {
        this.myStadt = stadt;
        return this;
    }

    public final Adresse ausgabe() {
        System.out.print(this.getStrasse());
        System.out.print(" ");
        System.out.print(this.getHnr());
        System.out.println();
        System.out.print(this.getPLZ());
        System.out.print(" ");
        System.out.print(this.getStadt());
        System.out.println();

        return this;
    }
    public String toString(){
        return "%s %d %d %s".formatted(this.getStrasse(), this.getHnr(), this.getPLZ(), this.getStadt());
    }
    public boolean vergleiche(final Adresse other) {
        if(other == null){
            return false;
        }
        if (this == other) {
            return true;
        } else {
            if (this.istPLZ(other.getPLZ())) {
                if (this.istHnr(other.getHnr())) {
                    if (this.istStadt(other.getStadt())) {
                        return this.istStrasse(other.getStrasse());
                    }
                }
            }

            return false;
        }
    }

    public Adresse kopiere() {
        return new Adresse(this.getStrasse(), this.getHnr(), this.getPLZ(), this.getStadt());
    }
}
