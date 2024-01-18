import java.util.Vector;

public class Tree234 {

    private Node root;

    public Tree234() {
        this.root = new Node();
    }

    public int find(long key) {
        Node curNode = getRoot();
        int childNumber;
        while (true) {
            if ((childNumber = curNode.findItem(key)) != -1) {
                return childNumber;
            } else if (curNode.isLeaf()) {
                return -1;
            } else {
                curNode = getNextChild(curNode, key);
            }
        }
    }

    public void insert(long dValue) {
        Node curNode = getRoot();
        NodeData tempItem = new NodeData(dValue);
        while (true) {
            if (curNode.isFull()) {
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, dValue);
            } else if (curNode.isLeaf()) {
                break;
            } else {
                curNode = getNextChild(curNode, dValue);
            }
        }
        curNode.insertItem(tempItem);
    }

    public void delete(long key) {
        Node curNode = getRoot();
        while (true) {
            int childNumber = curNode.findItem(key);
            if (childNumber != -1) {
                curNode.removeItem();
                break;
            } else if (curNode.isLeaf()) {
                System.out.println("Key not found in the tree.");
                return;
            } else {
                curNode = getNextChild(curNode, key);
            }
        }
    }

    public void printTree() {
        Vector<String> treeV = new Vector<>();
        treeInfoForPrinting(getRoot(), 0, 0, treeV);

        for (int x = 0; x < treeV.size(); x++) {
            System.out.println("Level " + x + ": " + treeV.get(x));
        }
    }

    private void treeInfoForPrinting(Node thisNode, int level, int childN, Vector<String> treeV) {
        try {
            treeV.set(level, treeV.get(level) + ", Child" + childN + " = " + thisNode.displayNode());
        } catch (Exception e) {
            treeV.insertElementAt("Child" + childN + " = " + thisNode.displayNode(), level);
        }

        for (int x = 0; x < thisNode.getNumItems() + 1; x++) {
            Node nextNode = thisNode.getChild(x);

            if (nextNode != null) {
                treeInfoForPrinting(nextNode, level + 1, x, treeV);
            } else {
                return;
            }
        }
    }

    private Node getRoot() {
        return root;
    }

    private Node getNextChild(Node theNode, long theValue) {
        int k;
        for (k = 0; k < theNode.getNumItems(); k++) {
            if (theValue < theNode.getItem(k).getKey()) {
                return theNode.getChild(k);
            }
        }
        return theNode.getChild(k);
    }

    private void split(Node oldNodeForSplit) {
        NodeData bItem;
        NodeData cItem;
        Node parent;
        Node child2;
        Node child3;
        int itemIndex;

        cItem = oldNodeForSplit.removeItem();
        bItem = oldNodeForSplit.removeItem();

        child2 = oldNodeForSplit.disconnectChild(2);
        child3 = oldNodeForSplit.disconnectChild(3);

        Node newNodeForSplit = new Node();

        if (oldNodeForSplit == getRoot()) {
            setRoot(new Node());
            parent = getRoot();
            root.connectChild(0, oldNodeForSplit);
        } else {
            parent = oldNodeForSplit.getParent();
        }

        itemIndex = parent.insertItem(bItem);

        for (int itemN = parent.getNumItems() - 1; itemN > itemIndex; itemN--) {
            Node temp = parent.disconnectChild(itemN);
            parent.connectChild(itemN + 1, temp);
        }

        parent.connectChild(itemIndex + 1, newNodeForSplit);

        newNodeForSplit.insertItem(cItem);
        newNodeForSplit.connectChild(0, child2);
        newNodeForSplit.connectChild(1, child3);
    }

    private void setRoot(Node root) {
        this.root = root;
    }
}
