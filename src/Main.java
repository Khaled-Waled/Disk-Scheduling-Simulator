public class main {

    public static void main(String[] args) {
        printArray(new SSTF().SSTF(new int[]{ 176, 79, 34, 60, 92, 11, 41, 114 }, 50));
        printArray(new FCFS().FCFS(new int[]{98, 183, 37, 122, 14, 124, 65, 67}, 53));
    }

    public static void printArray(int res[]){
        int n = res.length;
        System.out.println("===========================");
        for(int i : res){
            System.out.println(i);
        }
        System.out.println("===========================");
    }
}
