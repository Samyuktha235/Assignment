import java.util.*;
public class LongestRepeatingCharacterReplacement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String s = sc.nextLine();
        System.out.println("Enter the k value:");
        int k = sc.nextInt();
        int r = repeat(s, k);
        System.out.println(r);
    }

    public static int repeat(String s, int k) {
        int l = 0, r = 0, window = 0, fmax = 0, maxrep = 0;
        HashMap<Character, Integer> hashmap = new HashMap<>();

        while (l < s.length() && r < s.length()) {
            if (hashmap.containsKey(s.charAt(r))) {
                hashmap.put(s.charAt(r), hashmap.get(s.charAt(r)) + 1);
            } else {
                hashmap.put(s.charAt(r), 1);
            }
            maxrep=Collections.max(hashmap.values());
            window=r-l+1;

            if(window-maxrep<=k)
            {
                if(window>fmax)
                {
                    fmax=window;
                }
                    r++;
            }
            else
                {
                    hashmap.put(s.charAt(l),hashmap.get(s.charAt(l))-1);
                   l++;
                   r++;
                }
        }
        return fmax;
    }
}

