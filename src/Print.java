public interface Print {
    default void print() {
        System.out.println(this.toString());
    }
}