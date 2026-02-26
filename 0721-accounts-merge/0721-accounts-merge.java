class Solution {
    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int x) {
            if(parent[x] == x) return x;
            return parent[x] =find(parent[x]);
        }
        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if(pa != pb) {
                parent[pb] = pa;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String, Integer> emailMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for(int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if(emailMap.containsKey(email)) {
                    dsu.union(i, emailMap.get(email));
                } else {
                    emailMap.put(email, i);
                }
            }
        }
        Map<Integer, TreeSet<String>> map = new HashMap<>();

        for(String email : emailMap.keySet()) {
            int parent = dsu.find(emailMap.get(email));
            map.putIfAbsent(parent, new TreeSet<>());
            map.get(parent).add(email);
        }
        List<List<String>> result = new ArrayList<>();

        for(int parent : map.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(parent).get(0));
            list.addAll(map.get(parent));
            result.add(list);
        }

        return result;
    }
}