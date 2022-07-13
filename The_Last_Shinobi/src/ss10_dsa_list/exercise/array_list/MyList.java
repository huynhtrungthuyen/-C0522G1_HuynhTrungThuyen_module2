package ss10_dsa_list.exercise.array_list;

import java.util.Arrays;

public class MyList<E> {
    /**
     * size: Kích thước mảng
     * DEFAULT_CAPACITY: Kích thước mặc định
     * elements[]: Mảng ban đầu
     */
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    public Object[] elements;

    /**
     * Khởi tạo mảng ban đầu với chiều dài mặc định
     */
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Khởi tạo mảng với chiều dài truyền vào
     *
     * @param capacity: chiều dài truyền vào
     */
    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Illegal capacity: " + size);
        }
    }

    /**
     * Tăng kích thước của mảng lên gấp đôi
     */
    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    /**
     * Thêm phần tử mới vào mảng với vị trí index
     *
     * @param index:   vị trí cần thêm
     * @param element: phần tử cần thêm
     */
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Illegal index + " + index);
        } else if (size == elements.length) {
            ensureCapacity();
        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    /**
     * Xóa phần tử của mảng tại vị trí index
     * @param index: vị trí cần xóa
     * @return phần tử ở vị trí index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return (E) elements[index];
    }

    /**
     * @return Trả về tổng số phần tử có trong mảng
     */
    public int size() {
        return this.size;
    }

    /**
     * Kiểm tra phần tử có tồn tại trong mảng hay không
     * @param element: phần tử cần kiểm tra
     * @return boolean
     */
    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    /**
     * Trả về vị trí xuất hiện đầu tiên của phần tử cần tìm
     * @param element: phần tử cần tìm
     * @return vị trí xuất hiện đầu tiên
     */
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Trả về phần tử ở vị trí index
     * @return phần tử cần truy xuất
     */
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }

        return (E) elements[index];
    }

    /**
     * Thêm phần tử vào cuối mảng
     * @param element: phần tử cần thêm
     * @return true khi đã thêm xong
     */
    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity();
        }
        elements[size] = element;
        size++;
        return true;
    }

    /**
     * Sao chép mảng ra 1 mảng mới
     * @return mảng mới sau khi sao chép
     */
    public MyList<E> clone() {
        MyList<E> newArrayClone = new MyList<>();
        newArrayClone.elements = Arrays.copyOf(this.elements, this.size);
        newArrayClone.size = this.size;
        return newArrayClone;
    }

    /**
     * Xóa mảng
     */
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
}
