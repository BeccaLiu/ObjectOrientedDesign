package VisitorPattern;

/**
 * Created by rliu on 5/5/17.
 * The FancyVisitor implementation must return the absolute difference between the sum of values stored in the tree's non-leaf nodes at even depth and the sum of values stored in the tree's green leaf nodes.
 */
class FancyVisitor extends TreeVis {
    int sumEvenNonLeaves = 0;
    int sumGreenLeaves = 0;

    public int getResult() {
        //implement this
        return Math.abs(sumGreenLeaves-sumEvenNonLeaves);
    }

    public void visitNode(TreeNode node) {
        //implement this
        if(node.getDepth()%2==0){
            sumEvenNonLeaves+=node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if(leaf.getColor().equals(Color.GREEN)){
            sumGreenLeaves+=leaf.getValue();
        }
    }
}
