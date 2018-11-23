package java3.lesson1Fruit;

import java.io.Serializable;

class Fruit implements Serializable {
   String typeOfFruit;
   float weight;

    String getTypeOfFruit() {
       return typeOfFruit;
   }

   float getWeight() {
       return weight;
   }
}


