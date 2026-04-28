public class Main {
    public static void main(String[] args) {
        CustomList customList = new CustomList();
        customList.addLast(0);
        customList.addLast(1);
        customList.addLast(2);
        customList.addLast(3);
        customList.addFirst(100);

        System.out.println(customList.getFirst());
        System.out.println(customList.getLast());
        System.out.println("usunięto: " + customList.removeFirst());
        System.out.println("usunięto: " + customList.removeLast());
        System.out.println(customList.getFirst());
        System.out.println(customList.getLast());
    }
}