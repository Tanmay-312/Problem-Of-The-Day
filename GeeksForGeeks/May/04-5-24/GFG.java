//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG 
{
    private static int findPos(int[] in, int inStart, int inEnd, int elem) 
    {
        for (int i = inStart; i <= inEnd; i++) 
        {
            if (in[i] == elem) 
            {
                return i;
            }
        }
        return -1;
    }

    private static Node solve(int[] in, int[] post, int[] postIdx, int inStart, int inEnd, int n) 
    {
        if (postIdx[0] < 0 || inStart > inEnd) 
        {
            return null;
        }

        int elem = post[postIdx[0]--];
        Node root = new Node(elem);
        int pos = findPos(in, inStart, inEnd, elem);

        root.right = solve(in, post, postIdx, pos + 1, inEnd, n);
        root.left = solve(in, post, postIdx, inStart, pos - 1, n);

        return root;
    }

    // Function to return a tree created from postorder and inorder traversals.
    Node buildTree(int in[], int post[], int n) 
    {
        int[] postIdx = new int[]{n - 1};
        return solve(in, post, postIdx, 0, n - 1, n);
    }
}
