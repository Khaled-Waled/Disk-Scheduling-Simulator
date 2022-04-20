public class FCFS {
    public static int[] FCFS(int []requests, int start){
        int n = requests.length;
        int []result = new int[n + 1];
        result[0] = start;
        for(int i=0; i<n; i++){
            result[i + 1] = requests[i];
        }
        return result;
    }
}
