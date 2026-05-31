class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long cmass = mass;
        for(int a : asteroids){
            if(cmass < a){
                return false;
            }
            cmass+=a;
        }
        return true;
    }
}