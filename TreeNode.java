
public class TreeNode {
    public String data;            //data stored at this node
    public TreeNode  left;    //reference to left subtree
    public TreeNode right;   //reference to right subtree

    // Constructs a leaf node with the given data
    public TreeNode(String data)
    {
        this(data, null, null);
    }

    // Constructs a branch node with the given data and links
    public TreeNode(String data, TreeNode left, TreeNode right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
}
