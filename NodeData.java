class NodeData {
    private long key;

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public NodeData(long keyval) {
        this.key = keyval;
    }

    public String displayItem() {
        return ("[" + getKey() + "]");
    }
}