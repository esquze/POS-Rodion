package at.bal;

import java.util.Comparator;

public class PreisComparator implements Comparator<Maschine> {
    @Override
    public int compare(Maschine o1, Maschine o2) {
        return Double.compare(o2.getPreisEur(), o1.getPreisEur());
    }


}

