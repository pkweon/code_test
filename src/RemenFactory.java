import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class RemenFactory {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
    int answer = 0;
    int idx=0;
        Queue<Integer> queue=new PriorityQueue<Integer>(dates.length, Collections.reverseOrder());
        while(stock<k){
        for(int i=idx;i<dates.length;i++){
            if (dates[i]<=stock){
                queue.offer(supplies[i]);
            } else{
                idx = i;
                break;
            }
        }
        answer++;
        stock+=queue.poll();
        }
        return answer;
    }

    public int solution2(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> queue=new PriorityQueue<Integer>(dates.length, Collections.reverseOrder());

        int index = 0;
        for (int i = 0; i < k; i++) {
            if(index < dates.length && i == dates[index])
                queue.add(supplies[index++]);

            if(stock == 0) {
                stock += queue.poll();
                answer++;
            }
            stock -= 1;
        }
        return answer;
    }
}
