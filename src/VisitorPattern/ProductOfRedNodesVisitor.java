package VisitorPattern;

/**
 * Created by rliu on 5/5/17.
 * The ProductRedNodesVisitor implementation must return the product of values stored in all red nodes, including leaves,
 */
class ProductOfRedNodesVisitor extends TreeVis {
    int res=1;
    public int getResult() {
        //implement this
        return res;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if(node.getColor().equals(Color.RED)){
            res*=node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if(leaf.getColor().equals(Color.RED)){
            res*=leaf.getValue();
        }
    }
}