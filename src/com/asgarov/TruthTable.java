package com.asgarov;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TruthTable {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    private static final int D = 3;
    private static final int E = 4;

    public static void main(String[] args) {
        List<Boolean[]> truthTable = createTruthTable(4);
        System.out.println(truthTable.stream()
                .filter(row -> row[B] && !row[D])
                .map(Arrays::toString)
                .peek(System.out::println)
                .count());
    }

    private static List<Boolean[]> createTruthTable(int n) {
        return IntStream.range(0, (int) Math.pow(2, n))
                .boxed()
                .map(Integer::toBinaryString)
                .map(value -> padLeftZeros(value, n))
                .map(TruthTable::splitRowToListOfBooleans)
                .collect(Collectors.toList());
    }

    private static Boolean[] splitRowToListOfBooleans(String row) {
        return Arrays.stream(row.split(""))
                .map(value -> value.equals("1") ? Boolean.TRUE : Boolean.FALSE)
                .toArray(Boolean[]::new);
    }

    private static String padLeftZeros(String inputString, int length) {
        return String.format("%1$" + length + "s", inputString).replace(' ', '0');
    }

}

