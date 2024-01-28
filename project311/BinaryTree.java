public class BinaryTree {

    Node root=null;
    static Node parentNode=null;

    public boolean add(Node newNode){
        if (root==null){
            root=newNode;
            return true;
        }
        if (find(newNode.parentId, root)){
            if (parentNode.left==null)
                parentNode.left=newNode;
            else
                parentNode.right=newNode;
            return true;
        }
        return false;
    }

    public static boolean find(int id, Node root){
        if (root==null)
            return false;
        if (root.id == id){
            parentNode=root;
            return true;
        }
        else if (find(id, root.left) || find(id, root.right))
            return true;
        return false;
    }

    public static void resetCanGo(Node root){
        if (root==null)
            return;
        root.canGo=true;
        resetCanGo(root.left);
        resetCanGo(root.right);
    }
}