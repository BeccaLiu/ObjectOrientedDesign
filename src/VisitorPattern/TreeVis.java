package VisitorPattern;

/**
 * Created by rliu on 5/5/17.
 */
abstract class TreeVis
{
    //1.The SumInLeavesVisitor implementation must return the sum of the values in the tree's leaves only.
    //2.The ProductRedNodesVisitor implementation must return the product of values stored in all red nodes, including leaves, computed modulo . Note that the product of zero values is equal to .
    //3.The FancyVisitor implementation must return the absolute difference between the sum of values stored in the tree's non-leaf nodes at even depth and the sum of values stored in the tree's green leaf nodes. Recall that zero is an even number.
    public abstract int getResult();

    //implement the logic responsible for visiting the tree's non-leaf nodes such that the getResult method returns the correct for the implementing class' visitor.
    public abstract void visitNode(TreeNode node);

    //Implement the logic responsible for visiting the tree's leaf nodes such that the getResult method returns the correct  for the implementing class' visitor
    public abstract void visitLeaf(TreeLeaf leaf);

}
