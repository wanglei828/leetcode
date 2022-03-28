/*
Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.

Answers within 10-5 of the actual value will be accepted as correct.

Constraints:

1 <= hour <= 12
0 <= minutes <= 59
*/

class Solution {
    public double angleClock(int hour, int minutes) {
        int oneMinute = 360 / 60;
        int oneHour = 360 / 12;
        double minuteAng = minutes * oneMinute;
        double hourAng = oneHour * (hour % 12) + ((double)minutes / 60) * oneHour;
        double diff = Math.abs(minuteAng - hourAng);
        return Math.min(diff, 360 - diff);
    }
}
