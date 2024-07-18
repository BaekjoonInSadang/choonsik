package CH11;

import java.util.*;

public class diskController {

    public static void main(String[] args) {

        int[][] rowJobs = {{0,10},{2,7},{9,3}};

        Job[] jobs = new Job[rowJobs.length];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(rowJobs[i][0], rowJobs[i][1]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(job -> job.sTime));

        Queue<Job> queue = new LinkedList<>(Arrays.asList(jobs));
        TreeSet<Job> treeSet = new TreeSet<>(Comparator.comparingInt(job -> job.duration));

        System.out.println("queue = " + queue);
        System.out.println("treeSet = " + treeSet);

        int exec = 0;
        int time = 0;

        while (!queue.isEmpty() || !treeSet.isEmpty()) {
            while (!queue.isEmpty() && queue.peek().sTime <= time) {
                treeSet.add(queue.poll());
            }

            if(treeSet.isEmpty()) {
                time = queue.peek().sTime;
                continue;
            }

            Job job = treeSet.first();
            treeSet.remove(job);
            exec += time + job.duration - job.sTime;
            time += job.duration;

            System.out.println("treeSet = " + treeSet);
        }

        System.out.println("exec = " + exec / jobs.length);
    }

    public static class Job {
        private final int sTime;
        private final int duration;

        public Job(int sTime, int duration) {
            this.sTime = sTime;
            this.duration = duration;
        }

    }
}
