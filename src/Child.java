public class Child extends Parent {
    static void display() {
        System.out.println("Static method in Parent");
    }


    final int add(int a, int b){
        return a+b;
    }
}

