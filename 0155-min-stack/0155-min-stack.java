class MinStack {
    Stack<Long> st;
    long minElem;

    public MinStack() {
        st = new Stack<>();
        minElem = Long.MAX_VALUE;
    }

    public void push(int val) {
        if (st.isEmpty()) {
            minElem = val;
            st.push((long)val);
        } else if (val >= minElem) {
            st.push((long)val);
        } else {
            st.push(2L * val - minElem);
            minElem = val;
        }
    }

    public void pop() {
        if (st.isEmpty()) return;
        long popElem = st.pop();
        if (popElem < minElem) {
            minElem = 2 * minElem - popElem;
        }
    }

    public int top() {
        if (st.isEmpty()) return -1;
        long x = st.peek();
        if (x >= minElem) return (int)x;
        return (int)minElem;
    }

    public int getMin() {
        if (st.isEmpty()) return -1;
        return (int)minElem;
    }
}