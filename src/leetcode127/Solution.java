package leetcode127;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
   /*1、将beginWord加入wordList，start置为beginWord，end置为0
   * 2、建立一个图：buildGraph，将个字符串之间的边建立起来，关系由List<List<Integer>>来保存
   * 作用是便于查找最短路径时的BFS
   * 3、针对已建立好的图，进行BFS查找*/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        int end = 0;
        while (end < wordList.size() && !wordList.get(end).equals(endWord)) {
            end++;
        }
        if (end == wordList.size()) {
            return 0;
        }
        List<Integer>[] graphic = buildGraph(wordList);
        return getPath(graphic, start, end);
    }
    private List<Integer>[] buildGraph(List<String> wordList) {
        List<Integer>[] graphic = new List[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < wordList.size(); j++) {
                if (isConnect(wordList.get(i), wordList.get(j))){
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    private boolean isConnect(String si, String sj) {
        if (si.length() != sj.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < si.length() && diff <= 1; i++) {
            if (si.charAt(i) != sj.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    private int getPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graphic.length];
        queue.add(start);
        visited[start] = true;
        int res = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();
            res++;
            while (len > 0) {
                int cur = queue.poll();
                for (int next : graphic[cur]) {
                    if (next == end) {
                        return res;
                    }
                    if (visited[next]) {
                        continue;
                    }
                    queue.add(next);
                    visited[next] = true;
                }
                len--;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(s.ladderLength(beginWord, endWord, wordList));

    }
}
