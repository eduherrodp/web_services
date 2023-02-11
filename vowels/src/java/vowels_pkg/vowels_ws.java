/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package vowels_pkg;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eduhe
 */
@WebService(serviceName = "vowels_ws")
public class vowels_ws {

    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */

    static boolean isVowel(char ch)
    {
        ch = Character.toUpperCase(ch);
        return (ch=='A' || ch=='E' || ch=='I' ||
                           ch=='O' || ch=='U');
    }
    
    static int countVowels(String txt)
    {
        int count = 0;
        for (int i = 0; i < txt.length(); i++)
            if (isVowel(txt.charAt(i))) // Check for vowel
                ++count;
        return count;
    }
    
    @WebMethod(operationName = "vowels")
    public String vowels(@WebParam(name = "string") String txt) {
        // Get a txt
        String reverse = new StringBuilder(txt).reverse().toString();
        return reverse + "\t[Vowels: " + Integer.toString(countVowels(txt)) + "]";
    }
}
