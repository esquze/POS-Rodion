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
        this.name = name;
    }
    
    public void setKg(float kilogramm) {
        this.kg = kilogramm;
    }
    
    public void setCm(int cm) {
        this.cm = cm;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
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