package collection_framework.bai_tap;

class BST<Integer extends Comparable<Integer>> {
    TreeNode<Integer> root;
    int size;

    public void insert(Integer e) {

        if (this.root == null) {
            this.root = new TreeNode<>(e);
        } else {
            TreeNode<Integer> rootTmp = this.root;
            TreeNode<Integer> parent = null;

            while (rootTmp != null) {
                if (e.compareTo(rootTmp.e) < 0) {
                    parent = rootTmp;
                    rootTmp = rootTmp.left;
                } else if (e.compareTo(rootTmp.e) > 0) {
                    parent = rootTmp;
                    rootTmp = rootTmp.right;
                } else {
                    return;
                }
            }

            if (e.compareTo(parent.e) < 0) {
                parent.left = new TreeNode(e);
            } else {
                parent.right = new TreeNode(e);
            }
        }
        size++;
    }

    public void print(TreeNode<Integer> root) {
        if (root != null) {
            System.out.println(root.e);
            print(root.left);
            print(root.right);
        }

    }

    public boolean search(TreeNode<Integer> root, Integer e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.e) < 0) {
            return search(root.left, e);
        } else if (e.compareTo(root.e) > 0) {
            return search(root.right, e);
        }
        return true;
    }

    public TreeNode<Integer> deleteRec(TreeNode<Integer> root, Integer e) {
        if (root == null) {
            return null;
        }
        if (e.compareTo(root.e) < 0) {
            root.left = deleteRec(root.left, e);
        } else if (e.compareTo(root.e) > 0) {
            root.right = deleteRec(root.right, e);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }else
            root.e = min(root.right);
            root.right = deleteRec(root.right, root.e);
        }
        return root;
    }

    public Integer min(TreeNode<Integer> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.e;
    }

}

