import java.util.ArrayList;
import javax.swing.JComponent;
public class StringUtil {
    private static String alph;
    static {
        for (char c = 'a'; c <= 'z'; c++) {
            alph += c;
        }
        alph += alph.toUpperCase();
        for (int i = 0; i <= 9; i++) {
            alph += i;
        }
        alph += "#./?";
    }
    public static ArrayList<String> split(String str) {
        ArrayList<String> res = new ArrayList<String>();
        int index = 0;
        while (index < str.length()) { 
            if (alph.indexOf(str.charAt(index)) != -1) { //this must be a character
                int i = index + 1;
                while (i < str.length() && str.charAt(i) != ' ') { 
                    i++;
                }
                res.add(str.substring(index, i));
                index = i;
            } else {
                index++;
            }
        }
        return res;
    }
    public static String genRand(int len) {
        String pw = "";
        for (int i = 0; i < len; i++) {
            pw += alph.charAt((int) (Math.random() * alph.length()));
        }
        return pw;
    }
}
