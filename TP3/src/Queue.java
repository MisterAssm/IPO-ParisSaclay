public class Queue {

    private Cell first;
    private Cell last;
    private int size;

    public Queue() {
        this.first = new Cell(null, null);
        this.last = first;
        this.size = 0;
    }

    public static void main(String[] args) {
        int k = 5;

        Queue queue = new Queue();
        queue.enqueue("");

        while (!queue.isEmpty()) {
            String s = (String) queue.dequeue();

            if (s.length() < k) {
                queue.enqueue(s + "0");
                queue.enqueue(s + "1");
            } else {
                System.out.println(s);
            }
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(Object object) {
        Cell nextCell = new Cell(object, null);

        if (isEmpty()) {
            first = nextCell;
        } else {
            last.setNextCell(nextCell);
        }

        last = nextCell;
        size++;
    }

    public Object dequeue() {
        Object element = first.getElement();

        first = first.getNextCell();
        size--;

        return element;
    }
}
