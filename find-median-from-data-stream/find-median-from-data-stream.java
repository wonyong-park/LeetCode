class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int count = 0;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //count가 짝수 -> 최대힙 부터
        if(count%2 == 0){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        count++;

        //넣어주고 난 뒤 값을 비교해서 가장 최대힙 vs 최소힙 최대힙이 더 크면 변경
        int maxHeapValue = (maxHeap.isEmpty()) ? -100000 : maxHeap.peek();
        int minHeapValue = (minHeap.isEmpty()) ? 100000 : minHeap.peek();

        if (maxHeapValue > minHeapValue) {
            maxHeap.poll();
            maxHeap.add(minHeapValue);
            minHeap.poll();
            minHeap.add(maxHeapValue);
        }

    }

    public double findMedian() {
        int maxHeapValue = (maxHeap.isEmpty()) ? 0 : maxHeap.peek();
        int minHeapValue = (minHeap.isEmpty()) ? 0 : minHeap.peek();
        if(count%2 == 0){
            return (double) (maxHeapValue + minHeapValue) / 2;
        }else{
            return (double)maxHeapValue;
        }
    }
}