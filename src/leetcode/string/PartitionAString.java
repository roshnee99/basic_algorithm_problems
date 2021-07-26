package leetcode.string;

import java.util.*;

public class PartitionAString {

    public List<Integer> partitionLabels(String s) {
        List<Integer> splits = new ArrayList<>();
        char[] characters = s.toCharArray();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        // populate "cache"
        for (char c : characters) {
            if (frequencyMap.get(c) == null) {
                frequencyMap.put(c, 1);
            } else {
                int oldVal = frequencyMap.get(c);
                frequencyMap.put(c, oldVal + 1);
            }
        }
        // now iterate through the string. If we find that the frequency map depletes to 0 for any character,
        // that means it is no longer present in the string
        // once it is no longer gonna be seen, we can remove from the temp set
        // if the temp set is empty, that means that the characters are only in that partition

        Set<Character> tempSet = new HashSet<>();
        int countOfCurrentPartition = 0;
        for (char c : characters) {
            countOfCurrentPartition++;
            tempSet.add(c);
            decrementFreqMap(frequencyMap, c);
            if (frequencyMap.get(c) == 0) {
                tempSet.remove(c);
            }
            if (tempSet.isEmpty()) {
                splits.add(countOfCurrentPartition);
                countOfCurrentPartition = 0;
            }
        }
        return splits;
    }

    public void decrementFreqMap(Map<Character, Integer> frequencyMap, char c) {
        int oldVal = frequencyMap.get(c);
        frequencyMap.put(c, oldVal - 1);
    }

    public static void main(String[] args) {
        PartitionAString caller = new PartitionAString();
        System.out.println(caller.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
