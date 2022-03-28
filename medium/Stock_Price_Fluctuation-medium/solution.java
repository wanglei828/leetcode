/*
You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.

Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records may be incorrect. Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.

Design an algorithm that:

Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
Finds the maximum price the stock has been based on the current records.
Finds the minimum price the stock has been based on the current records.
Implement the StockPrice class:

StockPrice() Initializes the object with no price records.
void update(int timestamp, int price) Updates the price of the stock at the given timestamp.
int current() Returns the latest price of the stock.
int maximum() Returns the maximum price of the stock.
int minimum() Returns the minimum price of the stock.

Constraints:

1 <= timestamp, price <= 109
At most 105 calls will be made in total to update, current, maximum, and minimum.
current, maximum, and minimum will be called only after update has been called at least once.
*/

class StockPrice {
    HashMap<Integer, Integer> map;
    int curTime;
    PriorityQueue<int[]> max, min;
    public StockPrice() {
        map = new HashMap<>();
        curTime = -1;
        max = new PriorityQueue<int[]>((a, b)->b[0] - a[0]);
        min = new PriorityQueue<int[]>((a, b)->a[0] - b[0]);
    }
    
    public void update(int timestamp, int price) {
        map.put(timestamp, price);
        max.add(new int[]{price, timestamp});
        min.add(new int[]{price, timestamp});
        curTime = Math.max(curTime, timestamp);
    }
    
    public int current() {
        return map.get(curTime);
    }
    
    public int maximum() {
        while(!max.isEmpty()) {
            int time = max.peek()[1];
            if(max.peek()[0] != map.get(time)) {
                max.poll();
                continue;
            } else {
                break;
            }
        }
        return max.peek()[0];
    }
    
    public int minimum() {
        while(!min.isEmpty()) {
            int time = min.peek()[1];
            if(min.peek()[0] != map.get(time)) {
                min.poll();
                continue;
            } else {
                break;
            }
        }
        return min.peek()[0];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */

