package at.bal;

import java.util.Comparator;

public class BezeichnungComparator implements Comparator<Boot> {
    @Override
    public int compare(Boot o1, Boot o2) {
        return o1.getBezeichnung().compareTo(o2.getBezeichnung());
    }
}
