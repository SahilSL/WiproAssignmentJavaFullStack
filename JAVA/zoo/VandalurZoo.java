package zoo;

import org.animals.*;

public class VandalurZoo {
    public static void main(String[] args) {
        Lion lion = new Lion();
        Tiger tiger = new Tiger();
        Deer deer = new Deer();
        Monkey monkey = new Monkey();
        Elephant elephant = new Elephant();
        Giraffe giraffe = new Giraffe();

        System.out.println("Lion -> Vegetarian: " + lion.isVegetarian() + ", Can Climb: " + lion.canClimb() + ", Sound: " + lion.sound());
        System.out.println("Tiger -> Vegetarian: " + tiger.isVegetarian() + ", Can Climb: " + tiger.canClimb() + ", Sound: " + tiger.sound());
        System.out.println("Deer -> Vegetarian: " + deer.isVegetarian() + ", Can Climb: " + deer.canClimb() + ", Sound: " + deer.sound());
        System.out.println("Monkey -> Vegetarian: " + monkey.isVegetarian() + ", Can Climb: " + monkey.canClimb() + ", Sound: " + monkey.sound());
        System.out.println("Elephant -> Vegetarian: " + elephant.isVegetarian() + ", Can Climb: " + elephant.canClimb() + ", Sound: " + elephant.sound());
        System.out.println("Giraffe -> Vegetarian: " + giraffe.isVegetarian() + ", Can Climb: " + giraffe.canClimb() + ", Sound: " + giraffe.sound());
    }
}


/*Lion -> Vegetarian: false, Can Climb: false, Sound: Roar
Tiger -> Vegetarian: false, Can Climb: true, Sound: Growl
Deer -> Vegetarian: true, Can Climb: false, Sound: Bleat
Monkey -> Vegetarian: true, Can Climb: true, Sound: Chatter
Elephant -> Vegetarian: true, Can Climb: false, Sound: Trumpet
Giraffe -> Vegetarian: true, Can Climb: false, Sound: Hum
*/