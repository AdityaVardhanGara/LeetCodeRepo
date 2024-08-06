//{ Driver Code Starts
// Initial Template for JAVA

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


// } Driver Code Ends
// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class qObj {
    Node node;
    int level;

    qObj(Node n, int l) {
        node = n;
        level = l;
    }
}

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        // creating empty queue for level order traversal.
        Queue<qObj> q = new LinkedList<qObj>();
        q.add(new qObj(root, 1));

        // creating a map to store nodes at a particular horizontal distance.
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        while (!q.isEmpty()) {
            qObj popped = q.poll();
            if (!map.containsKey(popped.level)) map.put(popped.level, popped.node.data);

            // if left child of popped.node exists, pushing it in
            // the queue with the horizontal distance.
            if (popped.node.left != null)
                q.add(new qObj(popped.node.left, popped.level - 1));

            // if right child of popped.node exists, pushing it in
            // the queue with the horizontal distance.
            if (popped.node.right != null)
                q.add(new qObj(popped.node.right, popped.level + 1));
        }

        // traversing the map and storing the nodes in list
        // at every horizontal distance.
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            ans.add(e.getValue());
        }

        // returning the output list.
        return ans;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Tree {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();

            ArrayList<Integer> vec = ob.topView(root);
            for (int x : vec) System.out.print(x + " ");
            System.out.println();

            t--;
        }
    }
}
