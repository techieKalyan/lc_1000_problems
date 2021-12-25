package com.nelluri.arrays;

/*

Compute the rain water that gets trapped between the buildings.


 */
public class RainWaterTrapping {

    public int getTotalWaterTrapped(int[] heights) {

        // If there are only 2 buildings, water will never trapped and they flow over.
        if(heights.length <= 2) {
            return 0;
        }

        int n = heights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Left Max will contain the max height buildings to the left of index i
        leftMax[0] = heights[0];

        // right Max will contain the max height buildings to the right of index i
        rightMax[n-1] = heights[n-1];

        for(int i= 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], heights[i]);
            rightMax[n-i-1] = Math.max(rightMax[n-i], heights[n-i-1]);
        }

        int water = 0;

        for(int i=0;i < n;i++) {
            water += Math.min(leftMax[i],rightMax[i]) - heights[i];
        }
        return water;
    }

    public static void main(String[] args) {
        RainWaterTrapping rainWaterTrapping = new RainWaterTrapping();
        int[] heights = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        int totalWater = rainWaterTrapping.getTotalWaterTrapped(heights);
        System.out.println("Total water trapped is " + totalWater);
    }

}
