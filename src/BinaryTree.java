/**
 * Класс, реализующий интерфейс множества
 * с помощью структуры данных бинарного дерева поиска.
 *
 * */
public class BinaryTree<T extends Comparable<T>> {

    /**
     * Класс, реализующий узел дерева. Реализует интерфейс Comparaable<T>
     *
     * Поля:
     *  value -- хранимое в узле значение Comparaable<T> типа T
     *  left -- ссылка на левый дочерний узел
     *  right -- ссылка на правый дочерний узел
     *  parent -- ссылка на родительский узел
     * */
    private class Node<T extends Comparable<T>> implements Comparable<T> {

        private T value;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;

        /**
         * Переопределенный метод интерфейса Comparaable<T>
         * Сравнивает значения типа T.
         * */
        @Override
        public int compareTo(T value) {
            return this.value.compareTo(value);
        }

        public Node() {
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public Node(T value, Node<T> parent) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = parent;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }
    }

    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    /**
     * Метод, возвращающий значение true, если дерево пусто и false в противном случае.
     * */
    public boolean isEmpty() {
        return root == null;
    }

    public void remove(T value) {

    }

    /**
     * Проверка значения на вхождение в дерево.
     *
     * Аргументы:
     * value -- проверяемое значение
     * */
    public boolean contains(T value) {
        return findNode(root, value) != null;
    }

    /**
     * Поиск узла в дереве с указанным значением.
     *
     * Аргументы:
     * value -- искомое значение
     * */
    private Node<T> findNode(Node<T> node, T value) {
        if(node != null) {
            if (node.compareTo(value) > 0) {
                return findNode(node.getLeft(), value);
            } else if (node.compareTo(value) < 0) {
                return findNode(node.getRight(), value);
            }
        }
        return node;
    }

    /**
     * Добавление вершины в дерево.
     *
     * Аргументы:
     * value -- добавляемое значение
     * */
    public void add(T value) {
        addHelper(root, value, null);
    }

    /**
     * Вспомогательный рекурсивный метод для добавления верины.
     *
     * Аргументы:
     * currentNode -- текущий просматриваемый узел
     * value -- добавляемое значение
     * parentNode -- родитель текущего просматриваемого узла
     * */
    private Node<T> addHelper(Node<T> currentNode, T value, Node<T> parentNode) {
        if(currentNode == null) {
            currentNode = new Node<>(value, parentNode);
        }
        else if(currentNode.compareTo(value) > 0) {
            currentNode.setLeft(addHelper(currentNode.getLeft(), value, currentNode));
        }
        else if(currentNode.compareTo(value) < 0) {
            currentNode.setRight(addHelper(currentNode.getRight(), value, currentNode));
        }
        return currentNode;
    }
}
