public class Range {
    private int high, low;

    public void range(int l, int h) {
        this.high = h;
        this.low = l;
    }

    //Test if Range contains an individual int
    public boolean contains(int num) {
        return(num >= low && num <= high);
    }

    //Test if Range contains another Range entirely
    public boolean containsRange(Range r) {
        return(r.getLow() >= low && r.getHigh() <= high);
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }
}