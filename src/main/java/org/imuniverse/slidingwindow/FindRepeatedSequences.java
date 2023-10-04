package org.imuniverse.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatedSequences{

    public static void main(String[] args) {
        String sequences = "ATATATATATATATAT";
        System.out.println(findRepeatedSequences(sequences, 6));
    }

    public static Set<String> findRepeatedSequences(String sequence, int k) {

        HashSet<Integer> patterns = new HashSet<>();
        HashSet<String> matched = new HashSet<>();
        for (int i = 0; i <= sequence.length() - k; i++) {
            CharSequence charSequence = sequence.subSequence(i, i + k);
            int patternHash = charSequence.hashCode();
            if(!patterns.add(patternHash))
                matched.add(charSequence.toString());

        }
        return matched;
    }
}
