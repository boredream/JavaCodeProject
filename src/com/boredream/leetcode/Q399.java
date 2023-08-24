package com.boredream.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 注意：x 是未定义的 => -1.0
 * <p>
 * <p>
 * 提示：
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 *
 * TODO map可以做，但是 a->b b->c b->a 会有key冲突的情况。更适合用有向图做
 * https://leetcode.cn/problems/evaluate-division/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Q399 {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }

    static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 思路：代数题目。x是x的n倍。假设条件特别多时，是在初始化的时候就记录一个数字和所有人关系？还是在分析问题时，才挨个找关系？
        // 感觉后者懒汉时效率更高。且可以在查询过程中暂存
        // map保存关系
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            double value = values[i];
            map.put(first, value + ":" + second);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String first = queries.get(i).get(0);
            String second = queries.get(i).get(1);
            calculateDivision(map, result, i, first, second, 1.0);
        }
        return result;
    }

    private static void calculateDivision(HashMap<String, String> map,
                                          double[] result, int i,
                                          String key, String target,
                                          double totalDivision) {
        boolean reverse = false;
        String firstDivisionSecond = map.get(key);
        if (firstDivisionSecond == null) {
            // 如果直接关系找不到，找反过来的
            firstDivisionSecond = map.get(target);
            reverse = true;
        }

        if (firstDivisionSecond == null) {
            // 不存在定义
            result[i] = -1.0;
        } else if (target.equals(key)) {
            // 存在定义，且相同数字
            result[i] = 1.0;
        } else {
            // 循环first关系一直找到second
            String mapSecond = firstDivisionSecond.split(":")[1];
            String mapSecondNumber = firstDivisionSecond.split(":")[0];
            double division = Double.parseDouble(mapSecondNumber);
            if (reverse) division = 1 / division;
            totalDivision *= division;
            if (mapSecond.equals(target)) {
                // 匹配上对应关系了
                result[i] = totalDivision;
            } else {
                // 未匹配对应关系，把当前找到的second作为key，继续循环找下一个
                calculateDivision(map, result, i, mapSecond, target, totalDivision);
            }
        }
    }

}
