package map;

public class Hashtable {

    private Cell[] t;
    private int size;

    public Hashtable() {
        this.t = new Cell[8];
        this.size = 0;
    }

    public void put(Object key, Object value) {
        int index = getIndex(key);

        if (contains(key)) {
            Cell cell = t[index];

            while (cell != null) {
                if (cell.getKey().equals(key)) {
                    cell.setValue(value);
                    break;
                }

                cell = cell.getNextCell();
            }
        } else {
            if (size == t.length) {
                extend();
            }

            t[index] = new Cell(key, value, t[index]);
            size++;
        }
    }

    public void remove(Object key) {
        Cell before = null;
        Cell cell = t[getIndex(key)];

        while (cell != null) {
            if (cell.getKey().equals(key)) {
                if (before == null) {
                    t[getIndex(key)] = null;
                } else {
                    before.setNextCell(cell.getNextCell());
                }

                // Depuis la question 7, on peut sortir de la boucle while
                break;
            }

            before = cell;
            cell = cell.getNextCell();
        }

        size--;
    }

    public boolean contains(Object key) {
        Cell cell = t[getIndex(key)];
        return cell != null && cell.hasKey(key);
    }

    public Object get(Object key) {
        Cell cell = t[getIndex(key)];

        while (cell != null) {
            if (cell.getKey().equals(key)) {
                return cell.getValue();
            }

            cell = cell.getNextCell();
        }

        return null;
    }

    private void extend() {
        Cell[] temp = new Cell[size];

        for (int i = 0; i < t.length; i++) {
            Cell cell = t[i];

            while (cell != null) {
                Cell tempCell = cell.getNextCell();
                cell.setNextCell(null);
                temp[i] = cell;
                cell = tempCell;
            }
        }

        this.t = new Cell[t.length * 2];

        for (Cell cell : temp) {
            if (cell != null) {
                put(cell.getKey(), cell.getValue());
            }
        }
    }

    private int getIndex(Object key) {
        return Math.abs(key.hashCode()) % t.length;
    }
}
