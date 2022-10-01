import java.util.Scanner;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//INCOMPLETE
public class YetAnotherDivisorProblem
{
    public static void main(String [] args)
    {   
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        
        int count = 0;
        for (int i = a; i < b; i++)
        {
            if (i % 2 != 0)
            {
                if (check(divisors(i), numOfDiv(numOfDiv((int) Math.pow(i, i))))) 
                {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static int numOfDiv(int n) {
        int count = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n%i==0) {
                count++;
            }
        }
        return ++count;
    }
   
    public static int[] divisors(int n)
    {
        int a1[];
        a1 = new int[n];

        for (int i=1; i <= n/2; i++)

            if (n%i==0) 
            {
                a1[i] = i;
            }
            
        a1[a1.length -1 ] = n;
        return a1;
    }

    public static boolean check(int[] arr, int val) {
        boolean output = false;
        for (int element : arr) {
            if (element == val) {
                output = true;
                break;
            }
        }
        return output;
    }

}