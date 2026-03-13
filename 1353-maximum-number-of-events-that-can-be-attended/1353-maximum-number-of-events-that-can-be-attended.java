class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day = 0, i = 0, ans = 0, n = events.length;
        while(i < n || !pq.isEmpty()){
            if(pq.isEmpty()){
                day = events[i][0];
            }
            while(i < n && events[i][0] == day){
                pq.add(events[i][1]);
                i++;
            }
            pq.poll();
            ans++;
            day++;
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
        }
        return ans;
    }
}