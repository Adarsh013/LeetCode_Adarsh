class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int maxi = Integer.MIN_VALUE;

        int sum = 0;
        for(int num : weights){
            sum += num;
            maxi = Math.max(maxi, num);
        }

        int low = maxi;
        int high = sum;

        while(low <= high){
            int mid = low + (high - low ) /2;

            if(canShip(weights,mid,days)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    boolean canShip(int[] weights, int cap, int days){
        int current = 0;
        int usedDays = 1;
    

        for(int weight : weights ){

            if(current + weight <= cap){
                current += weight;
            }
            else{
                usedDays++;
                current = weight;
            }
        }
        return usedDays <= days; 
    }
}