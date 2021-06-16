package practice.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/11 15:02
 */
public class CourseSchedule {
    /**
     * https://leetcode-cn.com/problems/course-schedule/description/
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(prerequisites, numCourses);
        boolean[] globalVisit = new boolean[numCourses];
        boolean[] localVisit = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(graph, i, globalVisit, localVisit)) {
                return false;
            }
        }
        return true;
    }

    public boolean canFinish(List<Integer>[] graph, int cur, boolean[] globalVisit, boolean[] localVisit) {
        if (globalVisit[cur]) {
            return true;
        }
        if (localVisit[cur]) {
            return false;
        }
        globalVisit[cur] = true;
        localVisit[cur] = true;
        for (Integer node : graph[cur]) {
            if (!canFinish(graph, node, globalVisit, localVisit)) {
                return false;
            }
        }
        localVisit[cur] = false;
        return true;
    }

    private List<Integer>[] buildGraph(int[][] prerequisites, int numCourses) {
        List<Integer>[] graph = new List[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (graph[prerequisite[1]] == null) {
                graph[prerequisite[1]] = new ArrayList<>();
            }
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        return graph;
    }
}