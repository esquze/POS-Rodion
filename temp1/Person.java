import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class Person {
    private String name;
    private float kg;
    private int cm;
    private char gender;

    public Person(String name, float kg, int cm, char gender) {
        setName(name);
        setKg(kg);
        setCm(cm);
        setGender(gender);
    }

    public void setName(String name) {
        if (name.length() < 3 || name.length() > 50) {
            throw new IllegalArgumentException("Name muss 3-50 Zeichen haben");
        }
        this.name = name;
    }

    public void setKg(float kg) {
        if (kg < 2 || kg > 635) {
            throw new IllegalArgumentException("Ungültiges Gewicht");
        }
        this.kg = kg;
    }

    public void setCm(int cm) {
        if (cm < 50 || cm > 250) {
            throw new IllegalArgumentException("Ungültige Größe");
        }
        this.cm = cm;
    }

    public void setGender(char gender) {
        gender = Character.toLowerCase(gender);
        if (gender != 'm' && gender != 'w') {
            throw new IllegalArgumentException("Geschlecht muss m oder w sein");
        }
        this.gender = gender;
    }

    public float bmi () {
        return this.kg/((this.cm/100.0f)*(this.cm/100.0f));
    }

    public String mannOderFrau () {
        if (this.gender == 'm') return "männlich";
        return "weiblich";
    }
    
    public String toString () {
        return "Name: " + this.name + " (" + this.mannOderFrau() + ")" + mannOderFrau();
    }
    
    public float getBMI() {
        return bmi();
    }
    
    public String gewichtTyp () {
        float bmi = getBMI();
        if (this.gender == 'm') {
            if (bmi() < 20f) {
                return "Untergewicht";
            } else if (bmi() > 25f) {
                return "Übergewicht";
            } else {
                return "Normalgewicht";
            }
        }
        if (this.gender == 'w') {
            if (bmi() < 19f) {
                return "Untergewicht";
            } else if (bmi() > 24f) {
                return "Übergewicht";
            } else {
                return "Normalgewicht";
            }
        }
        return "Error";
    }    

    public String getName() {
        return name;
    }
    
    public float getKg() {
        return kg;
    }
    
    public int getCm() {
        return cm;
    }
    
    public char getGender() {
        return gender;
    }
}