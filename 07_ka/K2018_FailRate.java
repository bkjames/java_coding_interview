package real;

import java.util.*;

public class K2018_FailRate {

	public static void main(String[] args) {
		int n =5;
		int[] nums = {2, 1, 2, 6, 2, 4, 3, 3};
		K2018_FailRate a = new K2018_FailRate();
		int[] result = a.solution(n, nums);
		a.print(result);
	}
	
	public void print(int[] result) {
		for(int r : result) {
			System.out.print(r+"\t");
		}
	}
    class Fail {
        int stage;
        double rate;
        Fail(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }
    }

    Comparator<Fail> comp = new Comparator<Fail>() {
        public int compare(Fail a, Fail b) {
            if (a.rate < b.rate)
                return 1;
            else if (a.rate > b.rate)
                return -1;
            else {
                if (a.stage > b.stage)
                    return 1;
                else if (a.stage < b.stage)
                    return -1;
                else 
                    return 0;
            }
        }
    };

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Fail> fails = new ArrayList<Fail>();
        int total = stages.length;

        int[] users = new int[N+1];
        for (int s : stages)
            users[s-1]++;

        for (int i=0; i<N; ++i) {
            if (users[i] == 0)
                fails.add(new Fail(i+1, 0));
            else {
                fails.add(new Fail(i+1, (double)users[i]/total));
                total -= users[i];
            }
        }

        Collections.sort(fails, comp);        
        for (int i=0; i < N; ++i)
            answer[i] = fails.get(i).stage;

        return answer;
    }
}
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//class Solution {
//    public int[] solution(int N, int[] lastStages) {
//        int nPlayers = lastStages.length;
//        int[] nStagePlayers = new int[N + 2];
//        for (int stage : lastStages) {
//            nStagePlayers[stage] += 1;
//        }
//
//        int remainingPlayers = nPlayers;
//        List<Stage> stages = new ArrayList<>();
//        for (int id = 1 ; id <= N; id++) {
//            double failure = (double) nStagePlayers[id] / remainingPlayers;
//            remainingPlayers -= nStagePlayers[id];
//
//            Stage s = new Stage(id, failure);
//            stages.add(s);
//        }
//        Collections.sort(stages, Collections.reverseOrder());
//
//        int[] answer = new int[N];
//        for (int i = 0; i < N; i++) {
//            answer[i] = stages.get(i).id;
//        }
//        return answer;
//    }
//
//    class Stage implements Comparable<Stage> {
//        public int id;
//        public double failure;
//
//        public Stage(int id_, double failure_) {
//            id = id_;
//            failure = failure_;
//        }
//
//        @Override
//        public int compareTo(Stage o) {
//            if (failure < o.failure ) {
//                return -1;
//            }
//            if (failure > o.failure ) {
//                return 1;
//            }
//            return 0;
//        }
//    }
//}

