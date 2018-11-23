package java3.lesson1;

import java.util.ArrayList;

public interface IChangeArrays <E> {

    E[] swapTwoElementsInArray(int firstNumPos, int secondNumPos) throws WrongPositionException;

    ArrayList<E> returnArrayList();
}
