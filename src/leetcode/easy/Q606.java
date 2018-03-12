package leetcode.easy;

public class Q606 {
}

class Q606Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if (t.left != null) {
            String left = tree2str(t.left);
            sb.append("(" + left + ")");
            if (t.right != null) {
                String right = tree2str(t.right);
                sb.append("(" + right + ")");
            }
        } else {
            if (t.right == null) {
                return sb.toString();
            } else {
                String right = tree2str(t.right);
                sb.append("()(" + right + ")");
            }
        }
        return sb.toString();
    }

    public String tree2strIteration(TreeNode t) {

    }
}