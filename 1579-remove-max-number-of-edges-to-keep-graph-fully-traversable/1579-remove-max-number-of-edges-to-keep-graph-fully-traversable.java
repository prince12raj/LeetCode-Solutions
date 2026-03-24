class Solution {
    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for(int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return false;

            if(rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if(rank[pb] < rank[pa]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int usedEdges = 0;
        for(int[] e : edges) {
            if(e[0] == 3) {
                boolean a = alice.union(e[1], e[2]);
                boolean b = bob.union(e[1], e[2]);

                if(a | b) usedEdges++;
            }
        }
        for(int[] e : edges) {
            if(e[0] == 1) {
                if(alice.union(e[1], e[2])) {
                    usedEdges++;
                }
            }
        }
        for(int[] e : edges) {
            if(e[0] == 2) {
                if(bob.union(e[1], e[2])) {
                    usedEdges++;
                }
            }
        }
        int aliceRoot = alice.find(1);
        int bobRoot = bob.find(1);
        for(int i = 2; i <= n; i++) {
            if(alice.find(i) != aliceRoot || bob.find(i) != bobRoot) {
                return -1;
            }
        }
        return edges.length - usedEdges;
    }
}