package com.nelluri.arrays;
/*
Find max number of activities that can be done.
https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/quiz/5209728#overview
 */

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static class Activity {
        int start_time;
        int end_time;
        Activity(int start, int end) {
            this.start_time = start;
            this.end_time = end;
        }
    }

    public int computeMaxActivities(Activity[] activities) {

        // Sort the activities based on end time.
        // idea is that to do max activities, pick up the activities
        // which will get finished earlier using greedy approach.
        Arrays.sort(activities, new Comparator<Activity>(){
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.end_time - o2.end_time;
            }
        });

        int i = 0;
        // first activity is always considered
        System.out.println(activities[0].start_time + " " + activities[0].end_time);
        int maxActivities = 1;
        for(int j=1; j < activities.length; j++) {
            if(activities[j].start_time >= activities[i].end_time) {
                System.out.println(activities[j].start_time + " " + activities[j].end_time);
                i=j;
                maxActivities += 1;
            }
        }
        return maxActivities;

    }


    public static void main(String[] args) {
        Activity[] activities = new Activity[]{
                new Activity(5,9),
                new Activity(1,2),
                new Activity(3,4),
                new Activity(0,6),
                new Activity(5,7),
                new Activity(8,9)
        };

        ActivitySelection activitySelection = new ActivitySelection();
        System.out.println("Max activities is " + activitySelection.computeMaxActivities(activities));


    }

}
