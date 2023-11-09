public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(new Toy(1, "Doll", 10, 30));
        toyStore.addToy(new Toy(2, "Car", 15, 20));
        toyStore.addToy(new Toy(3, "Teddy bear", 5, 10));
        toyStore.addToy(new Toy(4, "Kremlin tower", 10, 40));

        Toy prizeToy = toyStore.drawToy();
        if (prizeToy != null) {
            toyStore.writeToFile(prizeToy);
            System.out.println("Congratulations! You won a " + prizeToy.getName());
        }
    }
}