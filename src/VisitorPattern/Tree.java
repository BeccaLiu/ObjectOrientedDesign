package VisitorPattern;

/**
 * Created by rliu on 5/5/17.
 */

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    //we treat the internal implementation of the tree as being closed to modification, so we cannot directly modify it;
    //however, as with real-world situations, the implementation is written in such a way that it allows external classes to extend and build upon its functionality.
    //More specifically, it allows objects of the TreeVis class (a Visitor Design Pattern) to visit the tree and traverse the tree structure via the accept method.
    public abstract void accept(TreeVis visitor);
}


