package cn.zjf.twoway;


public class Two_Way_LinkedList<E> {
    //链表节点个数
    public int size;
    //头节点
    private Node first;
    //尾结点
    private Node last;

    //节点类
    private class Node<E> {
        private E data;//数据
        private Node<E> prev;
        private Node<E> next;//下一个节点

        Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    //检查索引是否越界
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
    }

    //获取指定位置节点
    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            //从头开始遍历
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            //从尾部开始遍历
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    //根据索引存储数据
    public E set(int index, E e) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.data;
        x.data = e;
        return oldVal;
    }

    //获取指定位置数据方法
    public E get(int index) {
        checkElementIndex(index);
        return node(index).data;
    }

    //添加方法(默认添加至最后)
    public boolean add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        return true;
    }

    //在指定节点前插入数据
    void addBefore(E e, Node<E> succ) {
        Node<E> prev = succ.prev;
        Node<E> newNode = new Node<>(prev, e, succ);
        succ.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    //检查添加时的索引是否正确
    void checkPositionIndex(int index) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
    }

    //根据索引添加数据方法
    public void add(int index, E e) {
        checkPositionIndex(index);

        if (index == size) {
            add(e);
        } else {
            addBefore(e, node(index));
        }
    }

    //删除具体实现 返回被删除的数据
    E beforeRemove(Node<E> x) {
        E e = x.data;
        Node<E> prev = x.prev;
        Node<E> next = x.next;
        if (prev == null)
            first = next;
        else
            prev.next = next;
        if (next == null)
            last = next;
        else
            next.prev = prev;
        size--;
        return e;
    }

    //删除指定位置元素方法
    public E remove(int index) {
        checkElementIndex(index);

        return beforeRemove(node(index));
    }

    //删除指定元素
    public boolean remove(E e) {
        if (e == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.data == null) {
                    beforeRemove(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (e.equals(x.data)) {
                    beforeRemove(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 展示数据
     */
    public void display() {
        if (size > 0) {
            Node<E> node = first;
            int tempSize = size;
            if (tempSize == 1) {
                System.out.println("[" + node.data + "]");
            } else {
                while (tempSize > 0) {
                    if (node.equals(first)) {
                        System.out.print("[" + node.data + ", ");
                    } else if (node.next == null) {
                        System.out.print(node.data + "]");
                    } else {
                        System.out.print(node.data + ", ");
                    }
                    node = node.next;
                    tempSize--;
                }
            }

        } else {
            System.out.println("[]");
        }

    }
}
