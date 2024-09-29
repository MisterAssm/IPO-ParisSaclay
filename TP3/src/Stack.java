public class Stack {

    private Cell top;
    private int size;

    public Stack() {
        this.top = new Cell(null, null);
        this.size = 0;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        args = new String[]{"1", "2", "3", "x", "+", "4", "+"};

        for (String s : args) {
            if (s.equals("+")) {
                int a = (int) stack.pop();
                int b = (int) stack.pop();
                stack.push(a + b);
            } else if (s.equals("x")) {
                int a = (int) stack.pop();
                int b = (int) stack.pop();
                stack.push(a * b);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        System.out.println((int) stack.pop());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(Object object) {
        this.top = new Cell(object, top);
    }

    public Object pop() {
        Object temp = this.top.getElement();
        this.top = this.top.getNextCell();
        return temp;
    }
}
