class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
            graph.add(new ArrayList<>());
        for(int i=0; i<prerequisites.length; i++)
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        int[] inDegree = new int[numCourses];
        for(int i=0; i<graph.size(); i++){
            for(int j : graph.get(i))
                inDegree[j]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0)
                q.offer(i);
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int i : graph.get(node)){
                inDegree[i]--;
                if(inDegree[i] == 0)
                    q.offer(i);
            }
        }
       return topo.size() != numCourses
    ? new int[0]
    : topo.stream().mapToInt(Integer::intValue).toArray();     
    }
}