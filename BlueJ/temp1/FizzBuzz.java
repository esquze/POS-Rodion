
public class FizzBuzz
{
    public static void fizzBuzz () {
        for ( int i = 1 ;  true ; i++) {
            String printme = "";
            if (i % 3 == 0) printme += "Fizz";
            if (i % 5 == 0) printme += "Buzz";
            if (i % 7 == 0) printme += "Whizz";
            if (i % 11 == 0) printme += "Bang";
            if (printme.isEmpty()) System.out.println(i);
            else System.out.println(printme);
            if (printme.equals("FizzBuzzWhizzBang")) break;
        }
    }
    
    public static void fizzbuzz(){
        for (int i=0;i<=100;i++){
            if (i % 5 == 0 && i % 11 == 0 && i % 3 == 0 && i % 7 == 0){
                System.out.println("FizzBuzzWhizzBang");
            }
            else if (i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if (i % 3 == 0 && i % 7 == 0){
                System.out.println("FizzWhizz");
            }
            else if (i % 5 == 0 && i % 11 == 0){
                System.out.println("BuzzBang");
            }
            else if (i % 3 == 0){
                System.out.println("Fizz");
            }
            else if (i % 5 == 0){
                System.out.println("Buzz");
            }
            else if (i % 7 == 0){
                System.out.println("Whizz");
            }
            else if (i % 11 == 0){
                System.out.println("Bang");
            }
            else System.out.println(i);
        }
    }
}