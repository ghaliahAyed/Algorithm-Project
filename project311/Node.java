public class Node {
    int id, parentId;
    double score;
    String name;
    boolean canGo;
    Node left;
    Node right;

    Node(int pId, String name, int id, double score) {
        this.parentId=pId;
        this.name=name;
        this.id = id;
        this.score=score;
        canGo=true;
        right = null;
        left = null;
    }
}