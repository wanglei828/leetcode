class MedianFinder {
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2 - i1;
        };
    });
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(maxHeap.size() == 0 || num < maxHeap.peek()) {
            if(maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
            maxHeap.add(num);
        } else if(minHeap.size() == 0 || num > minHeap.peek()) {
            if(minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            minHeap.add(num);
        } else {
            if(minHeap.size() >= maxHeap.size()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) {
            return (double)(minHeap.peek());
        } else if (minHeap.size() < maxHeap.size()) {
            return (double)(maxHeap.peek());
        } else if (minHeap.size() == 0 && maxHeap.size()==0) {
            return 0;
        }else {
            return ((double)(minHeap.peek()) + (double)(maxHeap.peek()))/2;
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
