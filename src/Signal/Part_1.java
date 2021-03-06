package Signal;

import java.util.HashSet;
import java.util.Set;

public class Part_1 {

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 1};
        int[] result = Part_1.mutateTheArray(2, arr);
        System.out.println("\nMutate Array:");
        for (int val : result) {
            System.out.print(val + " ");
        }
        //############################################################//

        int[] a = {-92, -23, 0, 45, 89, 96, 99, 95, 89, 41, -17, -48};
        System.out.println("\nAlternative Sort:");
        System.out.println(Part_1.alternatingSort(a));

        //############################################################//

        System.out.println("\nCount numbers: ");
        System.out.println(Part_1.countOccurrences(10));

        //############################################################//

        System.out.println("\nCentury: ");
        System.out.println(Part_1.century(1707));

        //############################################################//

        System.out.println("\nShape Area:");
        System.out.println(Part_1.shapeArea(4));


    }

    //==========================================================================//


    static int[] mutateTheArray(int n, int[] a) {
        int[] b = new int[n];

        if (n == 1)
            return new int[]{a[0]};

        for(int i = 0; i < n; i++){
            if(i-1 < 0)
                b[i] = a[i] + a[i+1];
            else if(i+1 > n-1)
                b[i] = a[i-1] + a[i];
            else
                b[i] = a[i-1] + a[i] + a[i+1];
        }

        return b;
    }

    /*******************************************************************/

    static boolean alternatingSort(int[] a) {
        int size = a.length, s = 1, e = size -1;
        int[] b = new int[size];
        b[0] = a[0];
        for(int i = 1; i < size; i++){
            if(i % 2 != 0){
                b[i] = a[e];
                e--;
            } else {
                b[i] = a[s];
                s++;
            }
        }
        for(int i = 1; i < size; i++){
            if(b[i] <= b[i-1])
                return false;
        }
        return true;
    }

    /*******************************************************************/

    public static int countOccurrences(int n){
        int count = 0;
        for(int i=0; i<=n; i++){
            int a =i;
            do{
                int b= a%10;
                if(b==0 || b==2 || b==4) count++;
                a=a/10;
            }while(a>0);
        }
        return count;
    }

    /*******************************************************************/

    static int century(int year){
        int result;
        result = year / 100;
        if(year%100 > 0)
            result++;

        return result;
    }

    /*******************************************************************/

    // A 1-interesting polygon is just a square with a side of length 1. An n-interesting polygon is obtained by taking
    // the n - 1-interesting polygon and appending 1-interesting polygons to its rim, side by side.
    static int shapeArea(int n){
        int area = 1, add = 4;
        if(n == 1)
            return area;

        for(int i = 1; i<n; i++){
            area += add;
            add += 4;
        }

        return area;
    }

    /*******************************************************************/
}
