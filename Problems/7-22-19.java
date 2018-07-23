class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> seq1 = new ArrayList<>();
        ArrayList<Integer> seq2 = new ArrayList<>();
        if (root1 != null) {
            leavesToList(root1, seq1);
        }
        if (root2 != null) {
            leavesToList(root2, seq2);
        }
        return listsAreEqual(seq1, seq2);
    }
    public void leavesToList(TreeNode n, List<Integer> leafList) {
        if (n.left == null && n.right == null) {
            leafList.add(n.val);
            return;
        }
        if (n.left != null) leavesToList(n.left, leafList);
        if (n.right != null) leavesToList(n.right, leafList);
    }
    public boolean listsAreEqual(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }
}
