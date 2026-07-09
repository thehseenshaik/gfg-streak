class Solution {
    public int countKdivPairs(int[] arr, int k) {
        
        int[] freq = new int[k];
        int count = 0;
        
        for (int num : arr) {
            int rem = num % k;
            int need = (k - rem) % k;
            
            count += freq[need];
            freq[rem]++;
        }
        
        return count;
    }
}