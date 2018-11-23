package java3.lesson1;


import java.util.ArrayList;
import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {

        Integer[] iArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0};
        String[] sArray = {" one ", " two ", " three ", " four ", " five ", " six ", " seven "};

        IChangeArrays changeArraysI = new ChangeArrays<>(iArray);
        IChangeArrays changeArraysD = new ChangeArrays<>(dArray);
        IChangeArrays changeArraysS = new ChangeArrays<>(sArray);

        try {
            System.out.println(Arrays.toString(changeArraysI.swapTwoElementsInArray(3, 6)));
            System.out.println(Arrays.toString(changeArraysD.swapTwoElementsInArray(3, 6)));
            System.out.println(Arrays.toString(changeArraysS.swapTwoElementsInArray(3, 6)));
        } catch (WrongPositionException e) {
            e.printStackTrace();
        }

        ArrayList arrayList;
        arrayList = changeArraysD.returnArrayList();
        System.out.println(Arrays.toString(arrayList.toArray()));
        System.out.println(Arrays.toString(changeArraysI.returnArrayList().toArray()));

    }
}
