
package algorithmfinalexam;
import java.util.*;

public class TelesforoFinals02 {
    
     public static String Encode01(String s){
        String encoded01 = "";
        int i = 0;
        
        while (i < s.length()){
            int count = 1;
            
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)){
                count++;
                i++;
            }
            encoded01 = encoded01 + count + s.charAt(i);
            i++;
        }
        return encoded01;
    }
    
    public static String Encode02(String s){
        
        String encoded02 = "";
        int i = 0;
        int count = 0;
        char current = s.charAt(i);
        
        while (i <= s.length()){
            
            if (i == s.length()){
                encoded02 = encoded02 + count + current;
            }
            else if (current != s.charAt(i) && i==1){
                encoded02 = encoded02 + count + current;
                current = s.charAt(i);
                count = 1;
            }
            else if(current != s.charAt(i)){
                encoded02 = encoded02 + (count) + current;
                current = s.charAt(i);
                count = 1;
            }
            else{
                count++;
            }
            
            i++;
        }
        
        return encoded02;
    }
    
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Word: ");
        String inputted = scanner.next();

        
        System.out.println("Encode01 output: ");
        System.out.println(Encode01(inputted));

        
        System.out.println("Encode02 ouutput: ");
        System.out.println(Encode02(inputted));      
        System.out.println("Comparison of both outputs if equal: " + Encode02(inputted).equals(Encode01(inputted)));
        
    }
}
