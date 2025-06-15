package ArrayProblem;

public class MaxElementThanNby2 {

    public static void main(String[] args) {
        int[] arr = {2,2,1,3,1,1};
        System.out.println(majorityElement(arr));
    }
    static int majorityElement(final int[] A) {
        int cur=A[0];
        //store the element in consideration
        int count=1;//store the frequency of current element in consideration
        for(int i=1;i<A.length;i++){
            if(cur==A[i]){
                count++;
            }else{
                if(count==1){
                    cur=A[i];
                }else{
                    count--;
                }
            }
        }
        //in this process, if there is some element with occurances more than n/2, then 
        //it will always survive.
        return cur;
    }
}

