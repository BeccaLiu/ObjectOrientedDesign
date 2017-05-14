package VisitorPattern;

/**
 * Created by rliu on 5/5/17.
 * The SumInLeavesVisitor implementation must return the sum of the values in the tree's leaves only.
 */
class SumInLeavesVisitor extends TreeVis {
    int res=0;
    public int getResult() {
        //implement this
        return res;
    }

    public void visitNode(TreeNode node) {

    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        res+=leaf.getValue();
    }
}
