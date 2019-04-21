import java.util.*;
import java.util.stream.IntStream;

public class DIscController {
    class Job {
        int start;
        int duration;
    }
    public int solution(int[][] jobs) {
        Queue<Integer> queue = new PriorityQueue<>();
        List<Job> joblist = new ArrayList<>();
        int total_time = 0;
        for (int i = 0; i < jobs.length; i++) {
            Job j = new Job();
            j.start = jobs[i][0];
            j.duration = jobs[i][1];
            joblist.add(j);
            total_time += j.start + j.duration;
        }
        Collections.sort(joblist, (a, b) -> b.duration - a.duration);

        for (int time = 0; time < total_time; time++) {
        }
        return 0;
    }
}
