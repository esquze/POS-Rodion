
public class Quadrat
{
    public static void Quadrat() 
    {
        int a = 10;
        for (int i=0; i < a; i++) {
            System.out.print("#");
        }
        System.out.println("");

        for (int z = 0; z < a-2; z++)
        {
            for (int i=0; i < a; i++) {
                if (i == 0 || i == a-1 || i == z)
                    System.out.print("#");
                else 
                    System.out.print(" ");
            }
            System.out.println("");
        }
        //System.out.println("# # #");
        //System.out.println("#  ##");

        for (int i=0; i < a; i++) {
            System.out.print("#");
        }
        System.out.println("");


    }
}