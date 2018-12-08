package tlylz.acm;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> counter = new HashMap<>();
        FileReader reader; String str;

        Pattern tagPattern = Pattern.compile("<[/ \\w]+>");
        Pattern symbolPattern = Pattern.compile("[\\?\\=\\-\\_\\+\\|\\/\\\\\\!\\@\\#\\$\\%\\^\\&\\*\\\"\\(\\)\\,\\.\\~\\`\\'\\;\\:\\[\\]\\{\\}]+");
        Pattern transPattern = Pattern.compile("&[a-z#0-9]+;");
        Pattern tailPattern = Pattern.compile("[<>\t]+");

        try {
            reader = new FileReader("C:/inetpub/wwwroot/jojweb/test.html");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            return;
        }

        BufferedReader bufferedReader = new BufferedReader(reader);

        try {
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
                Matcher matcher = transPattern.matcher(str);
                str = matcher.replaceAll(" ");
                matcher = symbolPattern.matcher(str);
                str = matcher.replaceAll(" ");
                matcher = tagPattern.matcher(str);
                str = matcher.replaceAll(" ");
                matcher = tailPattern.matcher(str);
                str = matcher.replaceAll(" ");
                String[] arr = str.split("[ ]+");
                for (String s : arr) {
                    if (s.equals("")) continue;
                    Integer tot = counter.get(s);
                    if (tot == null) tot = 0;
                    counter.put(s, tot + 1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("\n\n\nMatcher result: ");
        counter.forEach((s, i) -> System.out.println("\t" + s + " : " + i));
    }
}
