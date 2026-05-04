package at.bal.model;

import java.util.Comparator;

public class AlterComparator implements Comparator<Mitarbeiter> {

    @Override
    public int compare(Mitarbeiter o1, Mitarbeiter o2) {
        return Integer.compare(o1.berechneAlter(), o2.berechneAlter());
    }

//    @Override
//    public int compare(Mitarbeiter o1, Mitarbeiter o2) {
//        if(o1.berechneAlter() > o2.berechneAlter()) {
//            return 1;
//        } else {
//            if (o1.berechneAlter() < o2.berechneAlter()) {
//                return -1;
//            } else {
//                return 0;
//            }
//        }
//    }
}
