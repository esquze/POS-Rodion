public class Christbaum
{
    public static void zeichne(int n) {
        for (int z = 0; z < n; z++) {
            int r = n - 1 - z;
            for (int i = 0; i < r; i++) {
                System.out.print(" ");
            }    
            System.out.print("[");
            
            int st = z * 2 + 1;
            for (int i = 0; i < st; i++) {
                System.out.print("*");  
            }
            System.out.print("]");
            
            System.out.println();
        }
    }
}
