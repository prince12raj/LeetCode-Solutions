class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            adj.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            order[index++] = current;

            for (int it : adj.get(current)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }
}