package practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xifu.yy
 * @description
 * @date 2021/06/15 15:24
 */
public class CourseSchedule2 {
    /**
     * https://leetcode-cn.com/problems/course-schedule-ii/description/
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(prerequisites, numCourses);
        List<Integer> res = new ArrayList<>();
        boolean[] globalVisit = new boolean[numCourses];
        boolean[] localVisit = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(i, graph, res, globalVisit, localVisit)) {
                return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private boolean canFinish(int curCourse, List<Integer>[] graph, List<Integer> res, boolean[] globalVisit,
        boolean[] localVisit) {
        if (globalVisit[curCourse]) {
            return true;
        }
        if (localVisit[curCourse]) {
            return false;
        }
        globalVisit[curCourse] = true;
        localVisit[curCourse] = true;
        for (Integer course : graph[curCourse]) {
            if (!canFinish(course, graph, res, globalVisit, localVisit)) {
                return false;
            }
        }
        localVisit[curCourse] = false;
        res.add(0, curCourse);
        return true;

    }

    private List<Integer>[] buildGraph(int[][] prerequisites, int numCourses) {
        List<Integer>[] res = new List[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (res[prerequisite[1]] == null) {
                res[prerequisite[1]] = new ArrayList<>();
            }
            res[prerequisite[1]].add(prerequisite[0]);
        }
        return res;
    }
}