package java3.lesson1Fruit;

public class MainBoxes {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>("Яблоки");
        Box<Apple> appleBox2 = new Box<>("Яблоки");
        Box<Orange> orangeBox1 = new Box<>("Апельсины");
        Box<Orange> orangeBox2 = new Box<>("Апельсины");

        toFullBoxes(appleBox1, appleBox2, orangeBox1, orangeBox2);

        printWeight(appleBox1, appleBox2, orangeBox1, orangeBox2);

        System.out.println(orangeBox2.compare(appleBox2));

        appleBox1.toBox(appleBox2);
        printWeight(appleBox1, appleBox2, orangeBox1, orangeBox2);
    }

    private static void printWeight(Box<Apple> appleBox1, Box<Apple> appleBox2, Box<Orange> orangeBox1, Box<Orange> orangeBox2) {
        System.out.printf("Здесь лежат %s их вес %.2f \n",appleBox1.getTypeOfBox(),  appleBox1.getWeight());
        System.out.printf("Здесь лежат %s их вес %.2f \n",appleBox2.getTypeOfBox(), appleBox2.getWeight());
        System.out.printf("Здесь лежат %s их вес %.2f \n",orangeBox1.getTypeOfBox(),orangeBox1.getWeight());
        System.out.printf("Здесь лежат %s их вес %.2f \n",orangeBox2.getTypeOfBox(),orangeBox2.getWeight());
    }

    private static void toFullBoxes(Box<Apple> appleBox1, Box<Apple> appleBox2, Box<Orange> orangeBox1, Box<Orange> orangeBox2) {
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        appleBox2.addGroup(new Apple(),6);
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        orangeBox2.addGroup(new Orange(),4);
    }
}
