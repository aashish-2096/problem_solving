import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import leetcode.pojo.*;

public class RightSideView_199 {
    Map<Integer, Integer> map = new HashMap<>();
    public void traverse(TreeNode root, int level) {
        if (root == null)
            return;
        this.map.put(level, root.val);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> pathList = new ArrayList<>();
        if (root != null) {
            traverse(root, 0);
            this.map.forEach((k, v) -> {
                pathList.add(v);
            });
        }
        return pathList;
    }
}
