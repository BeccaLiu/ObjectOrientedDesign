package VisitorPattern;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by rliu on 5/5/17.
 * An important concept in Object-Oriented Programming is the open/closed principle, which means writing code that is open to extension but closed to modification.
 * In other words, new functionality should be added by writing an extension for the existing code rather than modifying it and potentially breaking other code that uses it.
 * This challenge simulates a real-life problem where the open/closed principle can and should be applied.
 * <p>
 * Sample input:
 * <p>
 * 5 (5 nodes)
 * 4 7 2 5 12 (node value)
 * 0 1 0 0 1 (node color, 0 for red, 1 for green)
 * 1 2 (The tree is always rooted at node number 1.)
 * 1 3
 * 3 4
 * 3 5
 * --4R
 * 7G   2R
 * ---5R 12G
 * output getResult:
 * SumInLeavesVisitor:24
 * ProductOfRedNodesVisitor :40
 * FancyVisitor 15
 */
public class VisitorPattern {
    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] nodeValue = new int[cnt];
        int[] nodeColor = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            nodeValue[i] = scanner.nextInt();
        }
        for (int i = 0; i < cnt; i++) {
            nodeColor[i] = scanner.nextInt();
        }
        TreeNode root = new TreeNode(nodeValue[0], nodeColor[0] == 0 ? Color.RED : Color.GREEN, 0);
        HashMap<Integer, Tree> parents = new HashMap<Integer, Tree>();
        ArrayList<int[]> relation = new ArrayList<>();

        for(int index = 0; index < (cnt - 1); index++) {
            int p = scanner.nextInt();
            int c = scanner.nextInt();
            relation.add(new int[]{p, c});
            parents.put(p - 1, null);
        }

        parents.put(0, root);

        for (int i = 0; i < relation.size(); i++) {
            int p = relation.get(i)[0];
            int c = relation.get(i)[1];
            TreeNode parent = (TreeNode) parents.get(p - 1);
            Tree curr;
            if (parents.get(c - 1) == null && parents.containsKey(c - 1)) {
                curr = new TreeNode(nodeValue[c - 1], nodeColor[c - 1] == 0 ? Color.RED : Color.GREEN, parent.getDepth() + 1);
                parents.put(c - 1, curr);
                parent.addChild(curr);
            } else {
                curr = new TreeLeaf(nodeValue[c - 1], nodeColor[c - 1] == 0 ? Color.RED : Color.GREEN, parent.getDepth() + 1);
                parent.addChild(curr);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        //Read the n-node tree, where each node is numbered from  to . The tree is given as a list of node values (), a list of node colors (), and a list of edges. Construct this tree as an instance of the Tree class. The tree is always rooted at node number .
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
