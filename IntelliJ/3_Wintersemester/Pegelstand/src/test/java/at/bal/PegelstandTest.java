package at.bal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PegelstandTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    // 2. Aufgabe

    @Test
    void testSetFluss_sollFuntionieren_flussInn_innGesetz() {
        // given
        Pegelstand pegelstand = new Pegelstand(); // "Donau"
        assertEquals("Donau", pegelstand.getFluss());
        assertEquals(0, pegelstand.getAnzahl()); // leeres Array
        pegelstand.ausgebenWert();
        pegelstand.fuelleTestwerte();
        assertEquals(7,pegelstand.getAnzahl()); // volles Array
        pegelstand.ausgebenWert(); // alle Werte sind

        // when
        pegelstand.setFluss("Inn"); // "Inn"

        // then
        System.out.println(pegelstand.getFluss());
        assertNotEquals(null, pegelstand.getFluss());
        assertNotEquals("Donau", pegelstand.getFluss());
        assertEquals("Inn", pegelstand.getFluss());

    }

    @Test
    void testAvgWertFluss_sollNichtFunktionieren_leeresArray_returnMinus99komma0() {
        // given
        Pegelstand pegelstand = new Pegelstand();

        // when
        float actual = pegelstand.avgWert();
        float expected = -99f;

        // then
        assertEquals(expected, actual);

    }

    @Test
    void testAvgWertFluss_sollFunktionieren_vollesArray_returnAvgWert294Komma28() {
        // given
        Pegelstand pegelstand = new Pegelstand();
        pegelstand.fuelleTestwerte();

        // when
        float actual = pegelstand.avgWert();
        float expected = 294.28f;

        // then
        assertEquals(expected, actual, 0.009);
        System.out.println(pegelstand);
        System.out.println();
        pegelstand.printPegelstand();
    }

    @Test
    void testMinWert_MaxIndexWert() {
        // given
        Pegelstand pegelstand = new Pegelstand();

        // when
        pegelstand.fuelleTestwerte();
        float actual = pegelstand.minWert();
        float expected = 250;
        float actual2 = pegelstand.maxWertIndex();
        float expected2 = 2;

        // then
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);


    }


}