package ArrayProblem;

import java.util.Arrays;

class EliminateMonsters {
    public static void main(String[] args) {
        int[] dis = {4,2,8};
        int[] speed = {2,1,4};
        System.out.println(eliminateMaximum(dis,speed));
    }
    static int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int sum = 0;
        double[] time = new double[n];
        for(int i=0; i<n; i++){
            time[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(time);
        for (int i=0; i<n; i++){
            if(sum<time[i]){
                sum++;
            }else {
                break;
            }
        }
        return sum;
    }
}