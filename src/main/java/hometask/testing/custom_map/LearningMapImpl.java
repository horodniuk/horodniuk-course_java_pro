package hometask.testing.custom_map;

public class LearningMapImpl implements LearningMap {
    private Node<Integer, String>[] array = new Node[4];

    @Override
    public void put(Integer key, String value) {
        int index = key.hashCode() % array.length;
        Node<Integer, String> current = array[index];
        while (current != null && current.next != null) {
            if (current.getKey().equals(key)) {
                String oldValue = current.getValue();
                current.value = value;
                return;
            }
            current = current.next;
        }

        if (current == null) {
            array[index] = new Node<>(key, value);
        } else {
            current.next = new Node<>(key, value);
        }
    }

    @Override
    public String get(Integer key) {
        int index = key.hashCode() % array.length;
        Node<Integer, String> current = array[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.next;
        }
        return null;
    }

    static class Node<Integer, String> {
        private Integer key;
        private String value;
        private Node<Integer, String> next;

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public Node(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
