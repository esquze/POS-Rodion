public class Student {
    private String name;
    private float kg;
    private int cm;
    private char gender;

    public Student(String name, float kg, int cm, char gender) {
        this.setName(name);
        this.setKg(kg);
        this.setCm(cm);
        this.setGender(gender);
    }

    public void setName(String name) {
        if(name.length() < 3 || name.length() > 50) {
            throw new IllegalArgumentException("Name muss 3-50 Buchstaben haben");
        }
        this.name = name;
    }

    public void setKg(float kg) {
        if(kg < 2.0f || kg > 635.0f) {
            throw new IllegalArgumentException("Gewicht muss 2 - 635 kg sein");
        }
        else {
            this.kg = kg; 
        }
    }

    public void setCm(int cm) {
        if(cm < 50 || cm > 250) {
            throw new IllegalArgumentException("Größe muss 50 - 250 cm sein");
        }
        else {
            this.cm = cm; 
        }
    }

    public void setGender(char gender) {
        gender = Character.toLowerCase(gender);
        if(gender != 'm' && gender != 'w') {
            throw new IllegalArgumentException("Gender darf 'm' oder 'w' sein");
        }
        else {
            this.gender = gender; 
        }
    }

    public float bmi() {
        return this.kg/((this.cm/100.0f)*(this.cm/100.0f));
    }

    public String mannOderFrau() {
        if(this.gender == 'm') return "männlich";
        return "weiblich";
    }

    public String printStudent() {
        return "Name: " + this.name + " (" + this.mannOderFrau() + ")";
    }

    public String setGewicht () {
        if(this.gender == 'm') {
            if(bmi() < 20) {
                return "Untergewicht";
            }
            else if(bmi() > 25) {
                return "Übergewicht";
            }
            else {
                return "Normalgewicht";
            }
        }
        else if(this.gender == 'w') {
            if(bmi() < 19) {
                return "Untergewicht";
            }
            else if(bmi() > 24) {
                return "Übergewicht";
            }
            else {
                return "Normalgewicht";
            }
        }
        else {
            return "Error";
        }
    }
}