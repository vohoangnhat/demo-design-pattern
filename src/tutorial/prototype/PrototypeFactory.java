package tutorial.prototype;

import java.util.HashMap;
import java.util.Map;

abstract class Computer implements Cloneable {
    public Computer ghost() {
        try {
            return (Computer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Com1 extends Computer {
    private final String os = "Win";

    @Override
    public String toString() {
        return os;
    }
}

class Com2 extends Computer {
    private final String os = "Linux";

    @Override
    public String toString() {
        return os;
    }
}

class Com3 extends Computer {
    private final String os = "MacOS";

    @Override
    public String toString() {
        return os;
    }
}

class Factory {
    private static final Map<String, Computer> prototypes = new HashMap<>();

    static {
        prototypes.put("ComWin", new Com1());
        prototypes.put("ComLinux", new Com2());
        prototypes.put("Mac", new Com3());
    }

    static Computer getPrototype(String type) {
        try {
            return prototypes.get(type).ghost();
        } catch (NullPointerException ex) {
            System.out.println("Prototype with name: " + type + ", doesn't exist");
            return null;
        }
    }
}

public class PrototypeFactory {
    public static void main(String[] args) {
        String[] orders = {"ComWin", "ComLinux", "Mac"};

        for (String type : orders) {
            Computer newComputer = Factory.getPrototype(type);
            if (newComputer != null) {
                System.out.println(newComputer);
            }
        }
    }
}
