import java.util.HashMap;

public class Interview_1 {

    public static void main(String[] args) {
        // Pangram
        System.out.println("Pangram String: " + Interview_1.pangram("abcdefghijklmnopqrstuvwxyz"));

        //############################################################//


    }

//==========================================================================//

    // this method check that text in parameter has all the alphabet or not.
    static boolean pangram(String text){
        HashMap<Character, Integer> alpha = new HashMap<>();
        for (int i = 0; i < 26 ; i++) {
            alpha.put( (char) (97 + i), 0);
        }

        String temp = text.toLowerCase();
        for (int i = 0; i < temp.length(); i++) {
            if(alpha.containsKey(temp.charAt(i))){
                alpha.put(temp.charAt(i), 1);
            }
        }

        if (alpha.containsValue(0)){
            return false;
        }
        return true;
    }

    /*******************************************************************/


}

