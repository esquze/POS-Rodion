package at.bal;

public class Werkstoffprobe {

    private String id;
    private String bezeichnung;
    private double dichte;
    private double masse;

    public Werkstoffprobe(String id, String bezeichnung, double dichte, double masse) {
        setId(id);
        setBezeichnung(bezeichnung);
        setDichte(dichte);
        setMasse(masse);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Fehler: null oder leer");
        }
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String b) {
        if (b == null || b.isEmpty()) {
            throw new IllegalArgumentException("Fehler: null oder leer");
        }
        this.bezeichnung = b;
    }

    public double getDichte() {
        return dichte;
    }

    public void setDichte(double d) {
        if (d <= 0) {
            throw new IllegalArgumentException("Fehler: 0 oder negativ");
        }
        this.dichte = d;
    }

    public double getMasse() {
        return masse;
    }

    public void setMasse(double m) {
        if (m <= 0) {
            throw new IllegalArgumentException("Fehler: 0 oder negativ");
        }
        this.masse = m;
    }

}
