import java.util.HashMap;
import java.util.Objects;

class User {
    public String name;

    public User(String name) { this.name = name; }

    @Override
    public int hashCode() {
        return Objects.hash(name); // Hashcode depends on 'name'
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        return Objects.equals(name, ((User) obj).name);
    }
}

public class Main {
    public static void main(String[] args) {
        HashMap<User, String> map = new HashMap<>();
        User u1 = new User("Alice");

        // 1. Store the user
        map.put(u1, "Admin");

        // 2. Modify the field used in hashCode()
        u1.name = "Bob"; 

        // 3. Try to retrieve it
        System.out.println("Result: " + map.get(u1)); // Prints: null
        System.out.println("Contains: " + map.containsKey(u1)); // Prints: false
    }
}