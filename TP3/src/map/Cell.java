package map;

public class Cell {

    private Object key;
    private Object value;
    private Cell nextCell;

    public Cell(Object key, Object value, Cell nextCell) {
        this.key = key;
        this.value = value;
        this.nextCell = nextCell;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Cell getNextCell() {
        return nextCell;
    }

    public void setNextCell(Cell nextCell) {
        this.nextCell = nextCell;
    }

    public boolean hasKey(Object key) {
        if (this.key.equals(key)) {
            return true;
        }

        return nextCell != null && nextCell.hasKey(key);
    }
}
