public PetRegistry() {
    animals = new ArrayList<>();
    scanner = new Scanner(System.in);
}

public void start() {
    System.out.println("Добро пожаловать в реестр домашних животных!\n");
    while (true) {
        System.out.println("Выберите операцию:\n" +
                "1. Добавить животное\n" +
                "2. Просмотреть список животных\n" +
                "3. Обучить животное новым командам\n" +
                "4. Выход");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                addAnimal();
                break;
            case "2":
                viewAnimals();
                break;
            case "3":
                teachAnimal();
                break;
            case "4":
                System.out.println("До свидания!");
                return;
            default:
                System.out.println("Неверный выбор операции, попробуйте снова.\n");
                break;
        }
    }
}

private void addAnimal() {
    System.out.println("Введите имя животного:");
    String name = scanner.nextLine();
    System.out.println("Введите тип животного (кошка/собака):");
    String type = scanner.nextLine();
    if (type.equalsIgnoreCase("кошка")) {
        animals.add(new Cat(name));
    } else if (type.equalsIgnoreCase("собака")) {
        animals.add(new Dog(name));
    } else {
        System.out.println("Неверный тип животного, попробуйте снова.\n");
        return;
    }
    System.out.println("Животное успешно добавлено в реестр!\n");
}

private void viewAnimals() {
    if (animals.isEmpty()) {
        System.out.println("Реестр животных пуст!\n");
        return;
    }
    System.out.println("Список животных в реестре:\n");
    for (int i = 0; i < animals.size(); i++) {
        System.out.println(i+1 + ". " + animals.get(i).getName() + " - " + animals.get(i).getType());
    }
    System.out.println();
}

private void teachAnimal() {
    if (animals.isEmpty()) {
        System.out.println("Реестр животных пуст, нельзя обучать командам!\n");
        return;
    }
    viewAnimals();
    System.out.println("Выберите номер животного, которое будете обучать командам:");
    int index;
    while (true) {
        try {
            index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= animals.size()) {
                throw new Exception();
            }
            break;
        } catch (Exception e) {
            System.out.println("Неверный номер животного, попробуйте снова.");
        }
    }
    Animal animal = animals.get(index);
    System.out.println("Выбрано животное " + animal.getName() + " - " + animal.getType() + ".");
    while (true) {
        System.out.println("Выберите операцию для обучения командам:\n" +
                "1. Добавить команду\n" +
                "2. Просмотреть список команд\n" +
                "3. Выход");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                System.out.println("Введите новую команду:");
                String command = scanner.nextLine();
                animal.addCommand(command);
                System.out.println("Команда успешно добавлена!\n");
                break;
            case "2":
                ArrayList<String> commands = animal.getCommands();
                if (commands.isEmpty()) {
                    System.out.println("Список команд пуст!\n");
                } else {
                    System.out.println("Список команд для животного " + animal.getName() + ":\n");
                    for (int i = 0; i < commands.size(); i++) {
                        System.out.println(i+1 + ". " + commands.get(i));
                    }
                    System.out.println();
                }
                break;
            case "3":
                System.out.println("Выход из режима обучения.");
                return;
            default: