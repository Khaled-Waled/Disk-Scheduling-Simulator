public class Process {

    private int id;
    private static int nextId = 0;

    public Process(){
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

}
