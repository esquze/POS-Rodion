import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

/**
 * The test class PersonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonTest
{
    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    // ===== Männer bereich =====
    
    @Test
    public void mannUntergewicht() {
        Person p = new Person("Rodion", 65f, 195, 'm');
        assertEquals(17.1f, p.getBMI(), 0.1f);
        assertTrue(p.gewichtTyp().contains("Untergewicht"));
    }

    @Test
    public void mannNormalgewicht() {
        Person p = new Person("Can", 75f, 185, 'm');
        assertEquals(21.9f, p.getBMI(), 0.1f);
        assertTrue(p.gewichtTyp().contains("Normalgewicht"));
    }

    @Test
    public void mannUebergewicht() {
        Person p = new Person("Michael", 90f, 180, 'm');
        assertEquals(27.8f, p.getBMI(), 0.1f);
        assertTrue(p.gewichtTyp().contains("Übergewicht"));
    }

    // ===== Frauen bereich =====

    @Test
    public void frauUntergewicht() {
        Person p = new Person("Olga", 45f, 170, 'w');
        assertEquals(15.6f, p.getBMI(), 0.1f);
        assertTrue(p.gewichtTyp().contains("Untergewicht"));
    }

    @Test
    public void frauNormalgewicht() {
        Person p = new Person("Arina", 55f, 163, 'w');
        assertEquals(20.7f, p.getBMI(), 0.1f);
        assertTrue(p.gewichtTyp().contains("Normalgewicht"));
    }

    @Test
    public void frauUebergewicht() {
        Person p = new Person("Kate", 70f, 165, 'w');
        assertEquals(25.7f, p.getBMI(), 0.1f);
        assertTrue(p.gewichtTyp().contains("Übergewicht"));
    }

    // ===== Fehler im Konstruktor =====

    @Test
    public void nameZuKurz() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("Ro", 80f, 195, 'm');
        });
    }

    @Test
    public void gewichtZuKlein() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("Rodion", 1f, 195, 'm');
        });
    }
    
    @Test
    public void groesseZuKlein() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("Rodion", 80f, 30, 'm');
        });
    }
    
    @Test
    public void falschesGender() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Person("Rodion", 80f, 195, 'z');
        });
    }
}
