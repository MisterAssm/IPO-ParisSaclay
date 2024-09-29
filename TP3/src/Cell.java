public class Cell {

    private Object element;
    private Cell nextCell;

    public Cell(Object element, Cell nextCell) {
        this.element = element;
        this.nextCell = nextCell;
    }

    public static void main(String[] args) {
        Cell c1 = new Cell("the", null);
        Cell c2 = new Cell("world", new Cell("is", new Cell("square", null)));

        c1.setNextCell(c2);

        for (Cell c = c1; c != null; c = c.getNextCell()) {
            System.out.println(c.getElement());
        }
    }

    public Object getElement() {
        return element;
    }

    public Cell getNextCell() {
        return nextCell;
    }

    public void setNextCell(Cell nextCell) {
        this.nextCell = nextCell;
    }
}