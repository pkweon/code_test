import java.util.PriorityQueue;

public class MakeItHotter {
    public int solution(int[] scoville, int K) {
        for (int n : scoville) {
            add(n);
        }
        while(heap.peek() < K && heap.size() > 1) popandadd();
        if (heap.peek() < K) {
            return -1;
        }
        return count;
    }

    int count = 0;

    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);

    private void add(int n) {
        heap.add(n);
    }

    private void popandadd() {
        int a = heap.poll();
        int b = heap.poll();
        add(a + b*2);
        count++;
    }

}
