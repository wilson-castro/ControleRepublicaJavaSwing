
package src.utils;

public abstract class RandomString {
    public static String getAlphaNumericString(int n) {
 
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
               + "0123456789"
               + "abcdefghijklmnopqrstuvxyz"
               + "-+/*";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

         int index  = (int)(AlphaNumericString.length() * Math.random());
         
         sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
   }
}
