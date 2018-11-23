package java3.lesson1Fruit;

import java.util.ArrayList;

class Box<E extends Fruit> {
    private ArrayList<E> arrayList;
    private String typeOfBox;

    Box(String typeOfBox) {
        int initialCapacity = 10;
        this.arrayList = new ArrayList<>(initialCapacity);
        this.typeOfBox = typeOfBox;
    }

    String getTypeOfBox() {
        return typeOfBox;
    }

    //Метод добавления элемента в коробку
    void add(E value) {
        arrayList.add(value);
    }

    //метод удаления элемента из коробки
    E remove() {
        return arrayList.remove(arrayList.size() - 1);
    }

    //метод добавления группы элементов в коробку (в данном случае одна и таже ссылка на объект будет лежать во всех
    //добавленных ячейках, учитывая что все яблоки одинаковые, наверно это нормально в рамках текущей задачи
    void addGroup(E value, int number) {
        for (int i = 0; i < number; i++)
            arrayList.add(value);
    }

    //метод подсчета секущего веса коробки
    float getWeight() {
        float weightAll = 0;
        for (E anArrayList : arrayList) weightAll += anArrayList.getWeight();
        return weightAll;
    }

    //метод сравнения веса двух коробок
    boolean compare(Box box) {
        return box.getWeight() == this.getWeight();
    }

    //метод который пересыпает из одной коробки в другую, но не дас пересыпать апельсины в коробку с яблоками
    void toBox(Box<E> box) {
        while (arrayList.size() > 0)
            box.add(this.remove());

    }
}
