package lesson.collection_framework.bai_tap;

class BSTTest {

    public static void main(String[] args) {
        BST<Integer> treeBST = new BST<>();
        treeBST.insert(5);
        treeBST.insert(1);
        treeBST.insert(2);
        treeBST.insert(6);
        treeBST.insert(4);
        treeBST.insert(6);
        treeBST.insert(8);
        treeBST.insert(0);
        treeBST.deleteRec(treeBST.root,1);
        treeBST.print(treeBST.root);

        System.out.println(treeBST.search(treeBST.root,9));
        System.out.println("Size " + treeBST.size);

    }
}
