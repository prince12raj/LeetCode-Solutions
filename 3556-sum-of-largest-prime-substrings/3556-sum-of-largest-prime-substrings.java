class Solution {
    //to keep track of unique primes
    HashSet<Long> set = new HashSet<Long>();
    //to get max three primes
    PriorityQueue<Long> heap = new PriorityQueue<Long>();
    //check if given num is prime
    boolean isPrime(String num){
        long prime = Long.parseLong(num);
        if(prime <=1) return false;
        
        for(long i = 2;i*i<=prime;i++){
            if(prime%i == 0) return false;
        }
        //if the prime is unique then add in heap and set
        if(!set.contains(prime)){
            heap.offer(prime);
            //we need only largest three primes
            if(heap.size()>3) heap.poll();
            set.add(prime);
        }
        return true;

    }
    public long sumOfLargestPrimes(String s) {
        int n = s.length();
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<=n;j++){
                //generate all the substrings
                isPrime(s.substring(i,j));
            }
        }
        long ans = 0;
        //poll all the elements from heap
        while(!heap.isEmpty()){
            ans += heap.poll();
        }
        return ans;
    }
}