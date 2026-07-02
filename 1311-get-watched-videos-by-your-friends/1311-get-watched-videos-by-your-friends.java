class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos,int[][] friends,int id,int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        visited[id] = true;
        int currentLevel = 0;
        // BFS until the required level
        while (!queue.isEmpty() && currentLevel < level) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int person = queue.poll();
                for (int friend : friends[person]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                    }
                }
            }
            currentLevel++;
        }
        // Count video frequencies
        HashMap<String, Integer> freq = new HashMap<>();
        while (!queue.isEmpty()) {
            int person = queue.poll();
            for (String video : watchedVideos.get(person))
                freq.put(video, freq.getOrDefault(video, 0) + 1);
        }
        // Convert keys to list
        List<String> ans = new ArrayList<>(freq.keySet());
        // Sort by frequency, then lexicographical order
        Collections.sort(ans, (a, b) -> {
            if (!freq.get(a).equals(freq.get(b)))
                return freq.get(a) - freq.get(b);
            return a.compareTo(b);
        });
        return ans;
    }
}





// class Solution {
//     private void dfs(List<List<String>> wv, int[][] fs, int p, int level, int curLevel, Set<String> set){
//         if(level == curLevel){
//             for(String s : wv.get(p))
//                 set.add(s);
//             return;
//         }
//         for(int f : fs[p]){
//             if(f != p)
//                 dfs(wv, fs, f, level, curLevel+1, set);
//         }
//     }
//     public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
//         Set<String> set = new HashSet<>();
//         dfs(watchedVideos, friends, id, level, 0, set);
//         return new ArrayList(set);
//     }
// }