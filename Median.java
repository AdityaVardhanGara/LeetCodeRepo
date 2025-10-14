class MedianFinder {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;
    int cnt;
    public MedianFinder() {
        this.maxheap=new PriorityQueue<>((a,b)->b-a);
        this.minheap=new PriorityQueue<>();
        this.cnt=0;
    }
    
    public void addNum(int num) {
        cnt++;
        if(cnt==1) maxheap.add(num);
        else if(cnt==2){
            int top=maxheap.poll();
            if(num<=top) {
                maxheap.add(num);minheap.add(top);
            }else{
                maxheap.add(top);minheap.add(num);
            }
        }
        else{
            if(cnt%2==1){
                if(num>minheap.peek()){
                    minheap.add(num);
                    maxheap.add(minheap.poll());
                }else maxheap.add(num);
            }else{
                if(num<maxheap.peek()){
                    maxheap.add(num);
                    minheap.add(maxheap.poll());
                }else minheap.add(num);
            }
        }
    }
    
    public double findMedian() {
        if(cnt%2==1) return maxheap.peek();
        else return (double)(minheap.peek()+maxheap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
