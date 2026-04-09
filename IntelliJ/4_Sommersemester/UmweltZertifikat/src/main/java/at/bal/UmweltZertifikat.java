package at.bal;

public abstract class UmweltZertifikat implements Comparable<UmweltZertifikat> {
    private String id;
    private String name;
    private double co2ProJahr;
    private double recyclingQuote;

    public UmweltZertifikat(String id, String name, double co2ProJahr, double recyclingQuote) throws UmweltProjektException {
        setId(id);
        setName(name);
        setCo2ProJahr(co2ProJahr);
        setRecyclingQuote(recyclingQuote);
    }

    public String getId() {
        return id;
    }

    private boolean checkString(String toCheck) {
        return toCheck != null && !toCheck.isEmpty();
    }

    public void setId(String id) throws UmweltProjektException {
        if (!checkString(id)) {
            throw new UmweltProjektException("Fehler: id ist ungültig");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UmweltProjektException {
        if (!checkString(name)) {
            throw new UmweltProjektException("Fehler: id ist ungültig");
        }
        this.name = name;
    }

    public double getCo2ProJahr() {
        return co2ProJahr;
    }

    public void setCo2ProJahr(double co2ProJahr) throws UmweltProjektException {
        if (co2ProJahr < 0.0) {
            throw new UmweltProjektException("Fehler: co2ProJahr ist negativ");
        }
        this.co2ProJahr = co2ProJahr;
    }

    public double getRecyclingQuote() {
        return recyclingQuote;
    }

    public void setRecyclingQuote(double recyclingQuote) throws UmweltProjektException {
        if (recyclingQuote <= 0.0 || recyclingQuote > 100.0) {
            throw new UmweltProjektException("Fehler: recyclingquote muss größer als 0.0 und maximal 100.0 sein");
        }
        this.recyclingQuote = recyclingQuote;
    }

    public abstract double berechneNachhaltigkeitsScore() throws UmweltProjektException;

    public double berechneCO2Effizienz(double maxErlaubterCO2) throws UmweltProjektException {
        if (maxErlaubterCO2 <= 0.0) {
            throw new UmweltProjektException("Fehler: maxErlaubterCO2 muss größer 0.0 sein");
        }
        return ((maxErlaubterCO2 - co2ProJahr) / maxErlaubterCO2) * 100.0;
    }

    @Override
    public int compareTo(UmweltZertifikat o) {
        try {
            return Double.compare(berechneNachhaltigkeitsScore(), o.berechneNachhaltigkeitsScore());
        } catch (UmweltProjektException e) {
            System.out.println("Unerwarteter Fehler bei compareTo()");
            // Fehler-Log in File
            throw new IllegalArgumentException("Unerwarteter Fehler bei compareTo()");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("(ID: ").append(id).append(")\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("CO2/Jahr: ").append(co2ProJahr).
                append(" t, Recyclingquote: ").append(recyclingQuote).append("%\n");
        sb.append("CO2 Effizienz (max erlaubter CO2 von 100): ");
        try {
            sb.append(berechneCO2Effizienz(100)).append("%\n");
        } catch (UmweltProjektException e) {
            sb.append(" *** kann nicht berechnet werden *** \n");
        }
        sb.append("Nachhaltigkeitsscore: ");
        try {
            sb.append(berechneNachhaltigkeitsScore());
        } catch (UmweltProjektException e) {
            sb.append(" *** kann nicht berechnet werden *** \n");
        }
        return sb.toString();
    }
}
