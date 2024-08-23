public class lista {
    private int[] data;
    private int size = 0;
    
    public lista(int capacity) {
        this.data = new int[capacity];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = 0;
        }
        size = 0; 
    }

    public void add(int value) {
        if (isFull()) {
            throw new IllegalStateException("A lista está cheia.");
        }
        data[size++] = value; 
    }

    public void add(int value, int pos) {
        if (isFull()) {
            throw new IllegalStateException("A lista está cheia.");
        }
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        for (int i = size; i > pos; i--) {
            data[i] = data[i - 1];
        }
        data[pos] = value;
        size++;
    }

    public int remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        int removedValue = data[pos];
        for (int i = pos; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removedValue;
    }

    public boolean isFull() {
        return size == data.length;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return size == 0;
    }

    // Define um valor em uma posição específica
    public void setData(int value, int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        data[pos] = value;
    }

    public int getData(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }
        return data[pos];
    }

    public int getSize() {
        return size;
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1; 
    }
}
