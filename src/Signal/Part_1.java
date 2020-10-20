package Signal;

public class Part_1 {

    public static void main(String[] args) {

        int[] arr = {4};
        Part_1.mutateTheArray(1, arr);

        //############################################################//

        int[] a = {-92, -23, 0, 45, 89, 96, 99, 95, 89, 41, -17, -48};
        System.out.println(Part_1.alternatingSort(a));

        //############################################################//

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
}
