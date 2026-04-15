package at.bal;

import java.util.Objects;

public class EventBoot extends Boot {
    private double preisPauschal;

    public EventBoot(int maxPersonen, String bezeichnung, double preisPauschal) throws BootException {
        super(maxPersonen, bezeichnung);
        this.preisPauschal = preisPauschal;
    }

    public double getPreisPauschal() {
        return preisPauschal;
    }

    public void setPreisPauschal(double preisPauschal) throws BootException {
        if (preisPauschal <= 0.0) {
            throw new BootException("Fehler: muss größer als 0.0 sein");
        }
        this.preisPauschal = preisPauschal;
    }

    @Override
    public double preis() {
        return preisPauschal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EventBoot eventBoot = (EventBoot) o;
        return Double.compare(preisPauschal, eventBoot.preisPauschal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), preisPauschal);
    }

    @Override
    public String toString() {
        return "EventBoot: " + super.toString();
    }
}
