import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, int newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public Toy drawToy() {
        int totalWeight = toys.stream().mapToInt(Toy::getWeight).sum();
        int randomNumber = new Random().nextInt(totalWeight);

        int currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomNumber < currentWeight) {
                toy.decreaseQuantity();
                return toy;
            }
        }

        return null;
    }

    public void writeToFile(Toy toy) {
        try (FileWriter writer = new FileWriter("prize_toys.txt", true)) {
            writer.write(toy.getName() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
