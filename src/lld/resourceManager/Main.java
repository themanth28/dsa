package lld.resourceManager;

import java.util.HashMap;
import java.util.Map;

// Thread-safe Singleton using Double-Checked Locking
class ResourceManager {
    private static volatile ResourceManager instance; // volatile for safe publication
    private Map<String, String> resources;

    // Private constructor
    private ResourceManager() {
        resources = new HashMap<>();
    }

    // Thread-safe getInstance()
    public static ResourceManager getInstance() {
        if (instance == null) {
            synchronized (ResourceManager.class) {
                if (instance == null) { // double-checked locking
                    instance = new ResourceManager();
                }
            }
        }
        return instance;
    }

    // Add resource
    public synchronized void addResource(String key, String value) {
        resources.put(key, value);
    }

    // Get resource
    public synchronized String getResource(String key) {
        return resources.get(key);
    }

    // Remove resource
    public synchronized void removeResource(String key) {
        resources.remove(key);
    }

    // Show all resources
    public synchronized void showResources() {
        for (Map.Entry<String, String> entry : resources.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}

// Demo
public class Main {
    public static void main(String[] args) {
        ResourceManager rm1 = ResourceManager.getInstance();
        ResourceManager rm2 = ResourceManager.getInstance();

        rm1.addResource("DB", "Connected");
        rm1.addResource("Cache", "Initialized");

        System.out.println(rm2.getResource("DB")); // Connected

        rm2.removeResource("Cache");
        rm1.showResources(); // Only DB remains
    }
}
