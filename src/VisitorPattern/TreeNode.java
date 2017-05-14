package VisitorPattern;

import java.util.ArrayList;

/**
 * Created by rliu on 5/5/17.
 */
class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) { //这里是tree child 说明如果children是TreeLeaf，那么accept的会是TreeLeave的accept，那么就会call对应的visitor.visitLeaf
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}
