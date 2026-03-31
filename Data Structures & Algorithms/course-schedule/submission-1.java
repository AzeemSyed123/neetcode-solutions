class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses]; // tracks how many prereqs each course has

        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        // For each prerequisite [course, prereq]: prereq → course (must take prereq first)
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // add edge: prereq points to course
            inDegree[pre[0]]++;            // course has one more incoming dependency
        }

        // Start with courses that have NO prerequisites (inDegree == 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        int count = 0; // tracks how many courses we can complete

        while (!queue.isEmpty()) {
            int curr = queue.poll(); // take this course
            count++;

            // For each course that depends on curr, remove the dependency
            for (int next : graph.get(curr)) {
                inDegree[next]--;              // one less prereq to worry about
                if (inDegree[next] == 0)       // if all prereqs are done
                    queue.offer(next);          // this course is now ready to take
            }
        }

        // If we completed all courses, no cycle exists → return true
        return count == numCourses;
    }
}
// Time:  O(V + E) — V = numCourses, E = number of prerequisites
// Space: O(V + E) — adjacency list + inDegree array + queue