public abstract class Animals {
    private String name;
    private int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void makeSound();
}

public class Domestic extends Animals {
    public Domestic(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow/woof");
    }
}

public class Draught extends Animals {
    public Draught(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Neigh");
    }
}

public class Dogs extends Domestic {
    public Dogs(String name, int age) {
        super(name, age);
    }

    public void bark() {
        System.out.println("Bark");
    }
}

public class Cats extends Domestic {
    public Cats(String name, int age) {
        super(name, age);
    }

    public void meow() {
        System.out.println("Meow");
    }
}

public class Hamsters extends Domestic {
    public Hamsters(String name, int age) {
        super(name, age);
    }

    public void squeak() {
        System.out.println("Squeak");
    }
}

public class Horses extends Draught {
    public Horses(String name, int age) {
        super(name, age);
    }

    public void gallop() {
        System.out.println("Gallop");
    }
}

public class Camels extends Draught {
    public Camels(String name, int age) {
        super(name, age);
    }

    public void walk() {
        System.out.println("Walk");
    }
}

public class Donkeys extends Draught {
    public Donkeys(String name, int age) {
        super(name, age);
    }

    public void bray() {
        System.out.println("Hee-haw");
    }
}