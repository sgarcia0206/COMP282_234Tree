//final
class Node {
    private static final int MAX_CHILDREN = 4;
    private static final int MAX_ITEMS_PER_NODE = MAX_CHILDREN - 1;
    private Node parent;
    private Node childArray[] = new Node[MAX_CHILDREN];
    private NodeData itemArray[] = new NodeData[MAX_ITEMS_PER_NODE];
    private int numItems;

    public int getNumItems() {
        return numItems;
    }

    public void increaseItemNum() {
        numItems++;
    }

    public void decreaseItemNum() {
        numItems--;
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public void setChild(int childNum, Node child) {
        childArray[childNum] = child;
    }

    public NodeData getItem(int index) {
        return itemArray[index];
    }

    public void setItem(int index, NodeData item) {
        itemArray[index] = item;
    }

    public boolean isItemNull(int index) {
        return (itemArray[index] == null) ? true : false;
    }

    public Node getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return (getChild(0) == null) ? true : false;
    }

    public boolean isFull() {
        return (getNumItems() == MAX_ITEMS_PER_NODE) ? true : false;
    }

    public void connectChild(int childNum, Node child) {
        setChild(childNum, child);
        if (child != null) {
            child.parent = this;
        }
    }

    public Node disconnectChild(int childNum) {
        Node tempNode = getChild(childNum);
        setChild(childNum, null);
        return tempNode;
    }

    public int findItem(long key) {
        for (int x = 0; x < MAX_ITEMS_PER_NODE; x++) {
            if (isItemNull(x)) {
                break;
            } else if (getItem(x).getKey() == key) {
                return x;
            }
        }
        return -1;
    }

    public int insertItem(NodeData newItem) {
        increaseItemNum();
        for (int x = MAX_ITEMS_PER_NODE - 1; x >= 0; x--) {
            if (isItemNull(x)) {
                continue;
            } else {
                if (newItem.getKey() < getItem(x).getKey()) {
                    setItem(x + 1, getItem(x));
                } else {
                    setItem(x + 1, newItem);
                    return x + 1;
                }
            }
        }
        setItem(0, newItem);
        return 0;
    }

    public NodeData removeItem() {
        NodeData temp = getItem(getNumItems() - 1);
        setItem(getNumItems() - 1, null);
        decreaseItemNum();
        return temp;
    }

    public String displayNode() {
        String x = new String("");
        for (int node = 0; node < getNumItems(); node++) {
            x = x + getItem(node).displayItem();
        }
        return x;
    }
}