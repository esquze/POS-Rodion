package at.bal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class PersonalbueroTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testMitarbeiter() {
        Mitarbeiter mitarbeiter = new Mitarbeiter("Anna", Year.of(2001), Year.now());
        System.out.println(mitarbeiter);
    }

    @Test
    void testKuendigenAlle_SollFunktionieren_dreiMA_zweiHubert_returns2 () {
        //given
        Personalbuero personalbuero = new Personalbuero();
        Mitarbeiter ma1 = new Mitarbeiter("Hubert", Year.of(2000), Year.now());
        Mitarbeiter ma3 = new Mitarbeiter("Hubert", Year.of(2001), Year.now());
        Mitarbeiter ma2 = new Mitarbeiter("Anna", Year.of(2000), Year.now());
        personalbuero.aufnehmen(ma1);
        personalbuero.aufnehmen(ma2);
        personalbuero.aufnehmen(ma3);
        System.out.println(personalbuero);
        System.out.println();
        assertEquals(3, personalbuero.zaehleMitarbeiter());
        // when
        int ergebnis = personalbuero.kuendigenAlle("Hubert"); // 2
        // then
        assertEquals(2, ergebnis);
        assertEquals(1, personalbuero.zaehleMitarbeiter());
        System.out.println(personalbuero);
        System.out.println();
    }

    @Test
    void testKuendigenAlle_sollFunktionieren_einMA_einHubert_returns1() {
        // given
        Personalbuero personalbuero = new Personalbuero();
        Mitarbeiter ma1 = new Mitarbeiter("Hubert", Year.of(2000), Year.now());
        personalbuero.aufnehmen(ma1);
        System.out.println(personalbuero);
        System.out.println();
        // when
        int ergebnis = personalbuero.kuendigenAlle("Hubert");
        // then
        assertEquals(1, ergebnis);
        assertEquals(0, personalbuero.zaehleMitarbeiter());
        System.out.println(personalbuero);
        System.out.println();
    }

    @Test
    void testAngestellter() {
        Angestellter angestellter = new Angestellter("Anna", Year.of(2001), Year.now());
        System.out.println(angestellter);
    }

    @Test
    void testPersonalbuero_aufnehmenAngestellter_returnsTrue() {
        Angestellter angestellter = new Angestellter("Anna", Year.of(2001), Year.now());
        System.out.println(angestellter);
        Personalbuero personalbuero = new Personalbuero();
        assertTrue(personalbuero.aufnehmen(angestellter));
        System.out.println(personalbuero);
    }

    @Test
    void testPersonalbuero_aufnehmenFreelancer_returnsTrue() {
        Freelancer freelancer = new Freelancer();
        System.out.println(freelancer);
        Personalbuero personalbuero = new Personalbuero();
        assertTrue(personalbuero.aufnehmen(freelancer));
        System.out.println(personalbuero);
    }

}