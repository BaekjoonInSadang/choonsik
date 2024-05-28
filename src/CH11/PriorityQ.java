package CH11;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class PriorityQ {

    public static void main(String[] args) {

//        String[] operation = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operation = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

//        DoublePriorityQueue instance = new DoublePriorityQueue();
        priorityTreeSet instance = new priorityTreeSet();


        for (String operate : operation) {
            String[] split = operate.split(" ");
            String command = split[0];
            int value = Integer.parseInt(split[1]);

            switch (command){
                case "I" :
                    instance.add(value);
                    break;
                case "D" :
                    if(value == -1) {
                        instance.removeMin(value);
                    }
                    if(value == 1) {
                        instance.removeMax(value);
                    }

                    break;
                default:
                    System.out.println(" 난 아무런 이슈가 없슈! ");
                    break;
            }
        }

        System.out.println("[" +  instance.max() + "," +instance.min() + "]");
    }

    static class priorityTreeSet {
        private final TreeSet<Integer> set = new TreeSet<>();

        public void add(int value) {
            set.add(value);
        }

        public void removeMax(int value) {
            if (set.size() != 0) {
                int minValue = set.last();
                set.remove(minValue);
            }
        }

        public void removeMin(int value) {
            if (set.size() != 0) {
                int maxValue = set.first();
                set.remove(maxValue);
            }
        }

        public int max() {
            if (set.size() == 0) {
                return 0;
            } else {
                return set.last();
            }
        }

        public int min() {
            if (set.size() == 0) {
                return 0;
            } else {
                return set.first();
            }
        }
    }
    
    static class DoublePriorityQueue {
        private int size = 0;
        private final PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b) -> b - a);
        private final PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        public void add(int value) {
            minPq.add(value);
            maxPq.add(value);
            size++;
        }

        public void removeMax(int value) {
            if (size == 0) return;
            maxPq.poll();
            if( --size == 0) {
                maxPq.clear();
                minPq.clear();
            }
        }

        public void removeMin(int value) {
            if (size == 0) return;
            minPq.poll();
            if( --size == 0) {
                maxPq.clear();
                minPq.clear();
            }
        }

        public int max() {
            if (size == 0) return 0;
            return maxPq.peek();
        }

        public int min() {
            if (size == 0) return 0;
            return minPq.peek();
        }
    }

}
