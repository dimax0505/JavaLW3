package java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangeArrays<E> implements IChangeArrays<E> {
    private E[] arr;


    ChangeArrays(E[] arr) {
       this.arr = arr;
   }
    @Override
    public E[] swapTwoElementsInArray(int firstNumPos, int secondNumPos) throws WrongPositionException {
        if (firstNumPos < 0 || firstNumPos > arr.length ||
                secondNumPos < 0 || secondNumPos > arr.length || firstNumPos == secondNumPos) {
            throw new WrongPositionException("Неправильно указаны позиции элементов для замены");
        }
        E temp = arr[firstNumPos];
        arr[firstNumPos] = arr[secondNumPos];
        arr[secondNumPos] = temp;
        return arr;

    }

    @Override
    public ArrayList<E> returnArrayList() {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
