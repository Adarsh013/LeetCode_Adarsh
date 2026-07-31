class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = Integer.MIN_VALUE;

        for(int pile : piles){
            maxi = Math.max(maxi , pile);
        }

        int low = 1;
        int high = maxi;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPossible(piles, h, mid)){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        } 
        return low;
    }

    boolean isPossible(int[] piles, int h, int speed){   
        int hours = 0;

        for(int pile: piles){
            hours += Math.ceil((double)pile/speed);

            if(hours > h) return false;
        }
        return true;
    }
}