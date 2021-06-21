package vestigium;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    private final int testCaseNumber;
    private int trace;
    private int rowConflicts = 0;
    private int colConflicts = 0;

    private List<List<Integer>> matrix;
    private HashSet<Integer>[] uniqueRows;
    private Set<Integer>[] uniqueColumns;
    private ArrayList<Integer>[] allColumns;

    private Solution(int testCaseNumber) {
        this.testCaseNumber = testCaseNumber;
    }

    public static Solution buildResult(int testCaseNumber, List<String> inputs) {
        Solution result = new Solution(testCaseNumber);
        List<List<Integer>> matrix = new ArrayList<>();
        // create the matrix
        for (String row : inputs) {
            String[] parsed = row.split(" ");
            List<Integer> r = Arrays.stream(parsed).map(Integer::parseInt).collect(Collectors.toList());
            matrix.add(r);
        }
        result.setMatrix(matrix);
        result.computeRowConflicts();
        result.computeColumnConflicts();
        return result;
    }

    public void setMatrix(List<List<Integer>> matrix) {
        this.matrix = matrix;
        this.uniqueRows = new HashSet[matrix.size()];
        this.uniqueColumns = new HashSet[matrix.size()];
        this.allColumns = new ArrayList[matrix.size()];
        for (int i = 0; i < matrix.size(); i ++) {
            List<Integer> row = matrix.get(i);
            uniqueRows[i] = new HashSet<>(row);
            trace += row.get(i);
            for (int j = 0; j < matrix.size(); j++) {
                if (uniqueColumns[j] == null) {
                    uniqueColumns[j] = new HashSet<>();
                    allColumns[j] = new ArrayList<>();
                }
                uniqueColumns[j].add(row.get(j));
                allColumns[j].add(row.get(j));
            }
        }
    }

    public void computeRowConflicts() {
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            HashSet<Integer> uniqueRow = uniqueRows[i];
            if (uniqueRow.size() < row.size()) {
                rowConflicts++;
            }
        }
    }

    public void computeColumnConflicts() {
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> column = allColumns[i];
            Set<Integer> uniqueCol = uniqueColumns[i];
            if (uniqueCol.size() < column.size()) {
                colConflicts++;
            }
        }
    }

    @Override
    public String toString() {
        return "Case #" + this.testCaseNumber + ": " +
                this.trace + " " + this.rowConflicts + " " + this.colConflicts;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTestCases = Integer.parseInt(s.nextLine());
        List<String> outputs = new ArrayList<>();
        for (int i = 1; i <= totalTestCases; i++) {
            int numRows = Integer.parseInt(s.nextLine());
            List<String> rows = new ArrayList<>();
            for (int j = 0; j < numRows; j++) {
                rows.add(s.nextLine());
            }
            Solution r = Solution.buildResult(i, rows);
            outputs.add(r.toString());
        }
        outputs.forEach(System.out::println);
    }
}

