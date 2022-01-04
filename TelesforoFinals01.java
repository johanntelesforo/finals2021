
package algorithmfinalexam;
import java.util.*;
import java.util.stream.Collectors;


public class TelesforoFinals01 {
    
    public static String StringToBinary(String input) {

        StringBuilder buildstring = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            buildstring.append(
                    String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0")                             
            );
        }
        return buildstring.toString();
    }
    
    public static String PrintingBinaryOutput(String binary, int blockSize, String separator) {

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }
        return result.stream().collect(Collectors.joining(separator));
    }
    
    private static String XORops(String a, String b, int n){
        String XORstring = "";
        for (int i = 0; i < n; i++){

            if (a.charAt(i) == b.charAt(i))
                XORstring += "0";
            else
                XORstring += "1";
        }
        return XORstring;
    } 

    private static int BinaryToDecimal(String n) {
        String numbers = n;
        int dec_value = 0;
        int base = 1;
        int len = numbers.length();
        for (int i = len - 1; i >= 0; i--) {

            if (numbers.charAt(i) == '1')
                dec_value += base;
            base = base * 2;
        }
        return dec_value;
    }
    
    private static String settleString(String str) {
        int N = (str.length());
        if (N % 8 != 0) {
            return "Cannot Perform Program";
        }
        String string = "";
        for (int i = 0; i < N; i += 8) {
            int decimal_value = BinaryToDecimal((str.substring(i, 8+i)));
            string += (char)(decimal_value);
        }
        return string;
    }
    
    
    public static void main(String[] args) {
        Scanner orange = new Scanner(System.in);
        System.out.print("Enter Word of Choice: ");
        String wordChoice = orange.nextLine(); 
        System.out.print("Enter First Name: ");  
        String firstname = orange.next();

        System.out.println("First Name: " + firstname);

                
        if(firstname.length() > wordChoice.length()){
            String newStr = wordChoice.repeat(wordChoice.length()).substring(0, firstname.length());       
            wordChoice = newStr;
        }    
        String result_TestCase = StringToBinary(wordChoice);  
        if(wordChoice.length() > firstname.length()){
            String newStrFN = firstname.repeat(firstname.length()).substring(0, wordChoice.length());
            firstname = newStrFN;
        }  
        String output = StringToBinary(firstname);     
        String printFname = PrintingBinaryOutput(output, 8, " ");
        String printString = PrintingBinaryOutput(result_TestCase, 8, " ");
        
        System.out.println();
        System.out.println("First Name 8-bit Binary: \n" + printFname);
        System.out.println("Test Case 8-bit Binary: \n" + printString);
       
        int length = output.length();
        
        String result_XOR = XORops(output, result_TestCase, length);
        System.out.println("\nXOR Output: \n" + PrintingBinaryOutput(result_XOR, 8, " "));
    
        System.out.println("\nFinal Output: ");
        System.out.println(settleString(result_XOR));       
    }
}