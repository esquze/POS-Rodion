import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class AutoTest
{
    @Test
    public void testEinsteigen() {
        Auto BMW = new Auto("Galdon", 1250);
        Person JohnSmith = new Person("JohnSmith", 80f, 175, 'm');
        assertNotNull(JohnSmith);
        BMW.einsteigen(JohnSmith);
        JohnSmith = null;
        assertNull(JohnSmith);
    }
    
    @Test
    public void testGesamtGewicht() {
        Auto BMW = new Auto("Galdon", 1250);
        
        assertEquals(1250, BMW.getEigengewicht());
        BMW.setEigengewicht(5000);
        assertEquals(1300, BMW.getEigengewicht());
        
        BMW.setEigengewicht(400);
        assertEquals(1300, BMW.getEigengewicht());

    }
}