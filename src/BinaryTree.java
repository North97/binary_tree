/**
 * Класс, реализующий интерфейс множества
 * с помощью структуры данных бинарного дерева поиска.
 *
 * */
public class BinaryTree<T extends Comparable> {

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
}
