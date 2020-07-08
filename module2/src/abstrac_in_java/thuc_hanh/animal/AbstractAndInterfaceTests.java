package abstrac_in_java.thuc_hanh.animal;

import abstrac_in_java.edible.Edible;
import abstrac_in_java.thuc_hanh.fuirt.Fruit;
import abstrac_in_java.thuc_hanh.fuirt.Orange;
import abstrac_in_java.thuc_hanh.fuirt.Apple;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
