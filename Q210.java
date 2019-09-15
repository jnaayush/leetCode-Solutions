class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // if(prerequisites.length == 0){
        //     return new int[numCourses];
        // }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int z = 0; z < numCourses; z++){
            adj.put(z,new ArrayList<>());
        }
        for(int[] l : prerequisites){
            List<Integer> tmp = adj.get(l[1]);
            tmp.add(l[0]);
            adj.put(l[1],tmp);
        }
        Map<Integer,Integer> inDegree = new HashMap<>();
        for(int u : adj.keySet()){
            int degU = inDegree.getOrDefault(u,0);
            inDegree.put(u,degU);
            for(int v : adj.get(u)){
                int deg = inDegree.getOrDefault(v,0);
                inDegree.put(v,deg+1);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int u : inDegree.keySet()){
            if(inDegree.get(u) == 0){
                q.add(u);
            }
        }
        
        while(!q.isEmpty()){
            int u = q.poll();
            res.add(u);
            for(int v : adj.getOrDefault(u,new ArrayList<>())){
                int degV = inDegree.get(v);
                inDegree.put(v,degV-1);
                if(inDegree.get(v) == 0){
                    q.add(v);
                }
            }
        }
        if(res.size() >= inDegree.size()){
            return res.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[0];
        }
    }
}
