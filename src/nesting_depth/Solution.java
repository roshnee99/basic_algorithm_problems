package nesting_depth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    private static final char openingBracket = '(';
    private static final char closingBracket = ')';

    private final int testCaseNumber;
    private final List<Integer> testCase;

    public Solution(int testCaseNumber, String testCase) {
        this.testCaseNumber = testCaseNumber;
        String[] split = testCase.split("");
        this.testCase = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

    public String getResult() {
        String result = generateString();
        return "Case #" + testCaseNumber +  ": " + result;
    }

    private String generateString() {
        StringBuilder builder = new StringBuilder();
        int currentNestingDepth = 0;
        for (Integer digit : this.testCase) {
            while(currentNestingDepth < digit) {
                builder.append(openingBracket);
                currentNestingDepth++;
            }
            while(currentNestingDepth > digit) {
                builder.append(closingBracket);
                currentNestingDepth--;
            }
            builder.append(digit);
        }
        while (currentNestingDepth != 0) {
            builder.append(closingBracket);
            currentNestingDepth--;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTestCases = Integer.parseInt(s.nextLine());
        List<String> outputs = new ArrayList<>();
        for (int i = 1; i <= totalTestCases; i++) {
            String testCase = s.nextLine();
            Solution solution = new Solution(i, testCase);
            String result = solution.getResult();
            outputs.add(result);
        }
        outputs.forEach(System.out::println);
    }
}
