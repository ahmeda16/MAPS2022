import java.util.*;

public class LessVsFewer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        int p = Integer.parseInt(in.next());

        String output = "";
        Hashtable<String, String> table = new Hashtable<String, String>();
        table.put("number of", "c");
        table.put("amount of", "m");
        table.put("most", "cm");
        table.put("fewest", "c");
        table.put("least", "m");
        table.put("more", "cm");
        table.put("fewer", "c");
        table.put("less", "m");
        table.put("many", "c");
        table.put("much", "m");
        table.put("few", "c");
        table.put("little", "m");

        
        for (int i = 0; i < n; i++) {
            String noun = in.next();
            String type = in.next();
            table.put(noun, type);
        }

        in.nextLine();
        for (int i = 0; i < p; i++) {
            String phrase = in.nextLine().trim();
            String[] split = phrase.split(" ");
            String word = split[split.length-1];
            phrase = phrase.replace(word, "").trim();
            
            if ((table.get(phrase)).indexOf((table.get(word))) != -1) {
                output += "Correct!\n";
            }
            else {
                output += "Not on my watch!\n";
            }
        }

        System.out.println(output);
    }  
}
