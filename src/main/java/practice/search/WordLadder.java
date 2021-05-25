package practice.search;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xifu.yy
 * @description
 * @date 2021/05/24 10:25
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return 0;
        }
        wordList.add(beginWord);

        int start = wordList.size() - 1;
        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        List<Integer>[] graphic = buildGraphic(wordList);
        int distance = 1;
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(start);
        boolean[] marked = new boolean[wordList.size()];
        marked[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            while (size-- > 0) {
                Integer cur = queue.poll();
                if (graphic[cur] != null && graphic[cur].size() > 0) {
                    for (Integer next : graphic[cur]) {
                        if (next == end) {
                            return distance;
                        }
                        if (marked[next]) {
                            continue;
                        }
                        marked[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return 0;
    }

    public List<Integer>[] buildGraphic(List<String> wordList) {
        int n = wordList.size();
        List<Integer>[] res = new List[n];
        for (int i = 0; i < wordList.size(); i++) {
            res[i] = new ArrayList<>();
            for (int j = 0; j < wordList.size(); j++) {
                if (isConnect(wordList.get(i), wordList.get(j))) {
                    res[i].add(j);
                }
            }
        }
        return res;
    }

    public boolean isConnect(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int diffCnt = 0;
        for (int p1 = 0, p2 = 0; p1 < s1.length() && p2 < s2.length(); p1++, p2++) {
            if (s1.charAt(p1) != s2.charAt(p2)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

}