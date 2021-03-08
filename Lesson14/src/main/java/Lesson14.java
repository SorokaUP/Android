/*
    1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
       Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
       идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо
       выбросить RuntimeException.
       Написать набор тестов для этого метода (по 3-4 варианта входных данных).
       Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
       то метод вернет false;
       Написать набор тестов для этого метода (по 3-4 варианта входных данных).
       [ 1 1 1 4 4 1 4 4 ] -> true
       [ 1 1 1 1 1 1 ] -> false
       [ 4 4 4 4 ] -> false
       [ 1 4 4 1 1 4 3 ] -> false
*/

public class Lesson14 {

    //1. извлечение подмассива
    public int[] extract(int[] a, int x) {
        //находим позицию последней четверки
        int p = -1;
        for (int i = 0; i < a.length; i++)
            if (a[i] == x)
                p = i;
        if (p == -1)
            throw new RuntimeException();

        int[] r = new int[a.length - p - 1];
        for (int i = 0; i < r.length; i++)
            r[i] = a[p + 1 + i];

        System.out.println(intArrToStr(a) + ", " + x + " -> " + intArrToStr(r));
        return r;
    }

    //2. провера наличия только двух значений
    public boolean contain(int[] a, int va1, int val2) {
        boolean isFirst = false;
        boolean isSecond = false;
        boolean isAnother = false;
        for (int v: a) {
            if (v == va1)
                isFirst = true;
            else
                if (v == val2)
                    isSecond = true;
                else
                    isAnother = true;
        }
        boolean res = (isFirst && isSecond && (!isAnother));

        System.out.println(intArrToStr(a) + ", " + va1 + ", " + val2 + " -> " + res);
        return res;
    }

    private String intArrToStr(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int v: a)
            sb.append(v).append(" ");
        return "[" + sb.toString().trim() + "]";
    }
}
