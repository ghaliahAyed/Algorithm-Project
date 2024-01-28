import java.io.*;

public class Program{
static  ArrayList<Node> queue = new ArrayList<Node>();


    public static void main(String[] args) throws IOException {

        BinaryTree bt = readIntoBTree("ids.txt");
        double tot[]={0};
        double totalScore[]= {0};
        dynamic(bt.root);
        System.out.println("ID Name");
        result(bt.root,totalScore);
        System.out.println("Total score is: "+totalScore[0]);
        BinaryTree.resetCanGo(bt.root);
        System.out.println("BRUTE FORCE");
        System.out.println("ID Name");
        findBestUtilization(bt.root,tot);
        System.out.println("the total score is "+tot[0]);


    }
    
    
     public static void findBestUtilization(Node root,double [] tot) {
    if (root == null) {
        return;
    }
      queue.insert(root);

    while (!queue.empty()) {

        Node currentNode = queue.remove();

      if (currentNode.left != null && currentNode.right != null) {
           if (currentNode.score > (currentNode.right.score + currentNode.left.score)) {
                System.out.println(currentNode.name+" "+currentNode.id );
                tot[0]+=currentNode.score;
               

                  if (currentNode.right.right == null && currentNode.left.left == null) {
                    return ;
                }
                 findBestUtilization(currentNode.right.right,tot);
                findBestUtilization(currentNode.right.left,tot);
                findBestUtilization(currentNode.left.right,tot);
                findBestUtilization(currentNode.left.left,tot);
              } else {
                findBestUtilization(currentNode.right,tot);
                findBestUtilization(currentNode.left,tot);
            }
          } else if (currentNode.left != null) {
            System.out.println(currentNode.left.name+" "+currentNode.left.id );
                            tot[0]+=currentNode.left.score;

        } else if (currentNode.right != null) {
            System.out.println(currentNode.right.name+" "+currentNode.left.name );
                             tot[0]+=currentNode.right.score;
        }
         else {
                    {System.out.println(root.name+" "+currentNode.id );
                                   tot[0]+=currentNode.score;}

        }
       
    
    }
   }
   
   
   


    public static BinaryTree readIntoBTree(String fileName) throws IOException{
        BinaryTree bt= new BinaryTree();
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        int id, parentId;
        double score;
        String name;
        String st;
        Node newNode;
        while ((st = br.readLine()) != null){
            String[] arrOfStr = st.split(":");
            parentId=Integer.parseInt(arrOfStr[0]);
            name=arrOfStr[1];
            id=Integer.parseInt(arrOfStr[2]);
            score=Double.parseDouble(arrOfStr[3]);
            newNode = new Node(parentId, name, id, score);
            bt.add(newNode);
        }
        return bt;
    }

    public static void dynamic(Node root){
        if (root==null)
            return;
        if (root.canGo && root.left==null && root.right==null)
            return;
        if (root.canGo && (root.score>=root.left.score+root.right.score)){
            if (root.left!=null)
                root.left.canGo=false;
            if (root.right!=null)
                root.right.canGo=false;
            dynamic(root.left);
            dynamic(root.right);
            return;
        }
        root.canGo=false;
        dynamic(root.left);
        dynamic(root.right);
        return;
    }

    public static void result(Node root, double[] tScore){
        if (root==null)
            return;
        if (root.canGo){
            tScore[0]+=root.score;
            System.out.println(root.id+" "+root.name);
        }
        result(root.left,tScore);
        result(root.right,tScore);
    }
    


}

 
    
    
    
    
    
