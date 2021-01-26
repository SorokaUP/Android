package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rd = new Random();

    public static void main(String[] args) {
        boolean winHuman, winAi, draw;
        int restart;
        do {
            setMapSize();
            setDotsToWin();
            refreshMap();
            printMap();

            System.out.println("Счастливых вам Голодных игр. И пусть удача всегда будет с вами.");
            System.out.println("Вы играете за Х (крестики).");
            winHuman = false;
            winAi = false;
            draw = false;
            do {
                // Ход игрока
                stepHuman();
                printMap();
                System.out.println("");
                // Проверка на победу
                winHuman = checkWin(DOT_X);
                if (winHuman)
                    break;
                // Проверка на ничью
                draw = checkDraw();
                if (draw)
                    break;
                // Ход ИИ
                stepAi();
                printMap();
                // Проверка на победу
                winAi = checkWin(DOT_O);
                if (winAi)
                    break;
                // Проверка на  ничью
                draw = checkDraw();
                if (draw)
                    break;
            } while (true);

            if (winHuman)
                System.out.println("Поздравляем! Вы стали победителем голодных игр!");
            if (winAi)
                System.out.println("Сожалеем, но победа достается компьютеру!");
            if (draw)
                System.out.println("Такого поворота событий не ждал никто! У нас НИЧЬЯ!");

            do {
                System.out.println("Желаете попробовать снова? [1 Да | 0 Нет]");
                restart = sc.nextInt();
            } while (restart < 0 || restart > 1);
        } while (restart == 1);
    }

    private static void stepAi() {
        int qntX = 0;
        int[] coordinates = null;

        for (char[] row : map)
            for (int i = 0; i < row.length; i++)
                qntX += row[i] == DOT_X ? 1 : 0;

        // Был выполнен первый ход
        if (qntX == 1) {
            setO(-1, -1);
            return;
        } else {
            //======================================================================================
            // Анализ на победу Искуственного интелекта

            // Совпадения по строке
            coordinates = checkRow(DOT_O);
            if (coordinates != null)
            {
                setO(coordinates[0], coordinates[1]);
                return;
            }

            // Совпадения по столбцу
            coordinates = checkCol(DOT_O);
            if (coordinates != null)
            {
                setO(coordinates[0], coordinates[1]);
                return;
            }

            // Совпадения по диагоналям
            // Главная диагональ
            coordinates = checkDiagonalMain(DOT_O);
            if (coordinates != null)
            {
                setO(coordinates[0], coordinates[1]);
                return;
            }

            // Побочная диагональ
            coordinates = checkDiagonalSlave(DOT_O);
            if (coordinates != null)
            {
                setO(coordinates[0], coordinates[1]);
                return;
            }


            //======================================================================================
            // Анализ на контратаку

            // Совпадения по строке
            coordinates = checkRow(DOT_X);
            if (coordinates != null)
            {
                setO(coordinates[0], coordinates[1]);
                return;
            }

            // Совпадения по столбцу
            coordinates = checkCol(DOT_X);
            if (coordinates != null)
            {
                setO(coordinates[0], coordinates[1]);
                return;
            }

            // Совпадения по диагоналям
            // Главная диагональ
            coordinates = checkDiagonalMain(DOT_X);
            if (coordinates != null)
            {
                setO(coordinates[0], coordinates[1]);
                return;
            }

            // Побочная диагональ
            coordinates = checkDiagonalSlave(DOT_X);
            if (coordinates != null)
            {
                setO(coordinates[0], coordinates[1]);
                return;
            }

            // Бьем наугад
            setO(-1, -1);
            return;
        }
    }

    private static int[] checkRow(char DOT_CHECKED)
    {
        int[] res = null;
        int qnt = 0;
        int freeId = -1;
        char old = DOT_EMPTY;
        char curr = DOT_EMPTY;
        boolean isFirst = true;

        // Совпадения по строке
        for (int r = 0; r < map.length; r++) {
            qnt = 0;
            freeId = -1;
            old = DOT_EMPTY;
            isFirst = true;

            // Проверяем ячейки на строке
            for (int c = 0; c < map.length; c++) {
                curr = map[r][c];
                qnt = checkIteration(curr, old, DOT_CHECKED, isFirst, qnt)
                        ? qnt + 1
                        : 0;
                old = curr;
                isFirst = false;
                if (curr == DOT_EMPTY)
                    freeId = c;

                // Строка свободна и до победы не хватает 1 элемента (при подряд идущих)
                if (freeId >= 0 && qnt >= DOTS_TO_WIN - 1) {
                    res = new int[2];
                    res[0] = r;
                    res[1] = freeId;
                }
            }
        }

        return res;
    }

    private static int[] checkCol(char DOT_CHECKED)
    {
        int[] res = null;
        int qnt = 0;
        int freeId = -1;
        char old = DOT_EMPTY;
        char curr = DOT_EMPTY;
        boolean isFirst = true;

        // Совпадения по строке столбцу
        for (int c = 0; c < map.length; c++) {
            qnt = 0;
            freeId = -1;
            old = DOT_EMPTY;
            isFirst = true;

            // Проверяем ячейки на столбце
            for (int r = 0; r < map.length; r++) {
                curr = map[r][c];
                qnt = checkIteration(curr, old, DOT_CHECKED, isFirst, qnt)
                        ? qnt + 1
                        : 0;
                old = curr;
                isFirst = false;
                if (curr == DOT_EMPTY)
                    freeId = r;

                // Строка свободна и до победы не хватает 1 элемента (при подряд идущих)
                if (freeId >= 0 && qnt >= DOTS_TO_WIN - 1) {
                    res = new int[2];
                    res[0] = freeId;
                    res[1] = c;
                }
            }
        }

        return res;
    }

    private static int[] checkDiagonalMain(char DOT_CHECKED)
    {
        int[] res = null;
        int qnt = 0;
        int freeIdRow = -1;
        int freeIdCol = -1;
        char old = DOT_EMPTY;
        char curr = DOT_EMPTY;
        int cycleQnt = map.length - DOTS_TO_WIN + 1;
        int x = 0;
        int y = 0;
        boolean isFirst = true;

        // Главная диагональ
        for (int c = 0; c < cycleQnt; c++)
            for (int r = 0; r < cycleQnt; r++) {
                qnt = 0;
                freeIdRow = -1;
                freeIdCol = -1;
                old = DOT_EMPTY;
                isFirst = true;

                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    x = i + r;
                    y = i + c;
                    curr = map[x][y];
                    qnt = checkIteration(curr, old, DOT_CHECKED, isFirst, qnt)
                            ? qnt + 1
                            : 0;
                    old = curr;
                    isFirst = false;
                    if (curr == DOT_EMPTY) {
                        freeIdRow = x;
                        freeIdCol = y;
                    }
                    if (freeIdRow >= 0 && qnt >= DOTS_TO_WIN - 1) {
                        res = new int[2];
                        res[0] = freeIdRow;
                        res[1] = freeIdCol;
                    }
                }
            }

        return res;
    }

    private static int[] checkDiagonalSlave(char DOT_CHECKED)
    {
        int[] res = null;
        int qnt = 0;
        int freeIdRow = -1;
        int freeIdCol = -1;
        char old = DOT_EMPTY;
        char curr = DOT_EMPTY;
        int cycleQnt = map.length - DOTS_TO_WIN + 1;
        int x = 0;
        int y = 0;
        boolean isFirst = true;

        // Побочная диагональ
        for (int c = 0; c < cycleQnt; c++)
            for (int r = 0; r < cycleQnt; r++) {
                qnt = 0;
                freeIdRow = -1;
                freeIdCol = -1;
                old = DOT_EMPTY;
                isFirst = true;

                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    x = i + r;
                    y = DOTS_TO_WIN - 1 - i + c;
                    curr = map[x][y];
                    qnt = checkIteration(curr, old, DOT_CHECKED, isFirst, qnt)
                            ? qnt + 1
                            : 0;
                    old = curr;
                    isFirst = false;
                    if (curr == DOT_EMPTY) {
                        freeIdRow = x;
                        freeIdCol = y;
                    }
                    if (freeIdRow >= 0 && qnt >= DOTS_TO_WIN - 1) {
                        res = new int[2];
                        res[0] = freeIdRow;
                        res[1] = freeIdCol;
                    }
                }
            }

        return res;
    }

    private static boolean checkIteration(char curr, char old, char DOT_CHECKED, boolean isFirst, int qnt)
    {
        return ((curr == DOT_CHECKED) ||

                ((curr == DOT_EMPTY) &&      // Ячейка пуста
                 (old == DOT_CHECKED) &&     // Предыдущая ячейка была искомой
                 !isFirst &&                 // Это не первый цикл
                 (qnt == DOTS_TO_WIN - 1))); // До победы не хватает одного значения
    }






    private static void setO(int ix, int iy)
    {
        int x = 0;
        int y = 0;
        do
        {
            x = (ix >= 0) ? ix : rd.nextInt(map.length);
            y = (iy >= 0) ? iy : rd.nextInt(map.length);
        } while (!checkStep(x,y));

        map[x][y] = DOT_O;
        System.out.println("А я вот так схожу!");
    }

    private static boolean checkWin(char DOT_WINNER)
    {
        int qnt = 0;

        // Совпадения по строке
        for (char[] row : map) {
            qnt = 0;
            for (int i = 0; i < row.length; i++) {
                qnt = row[i] == DOT_WINNER ? qnt + 1 : 0;
                if (qnt == DOTS_TO_WIN)
                    return true;
            }
        }

        // Совпадения по столбцу
        for (int x = 0; x < map.length; x++) {
            qnt = 0;
            for (int y = 0; y < map.length; y++) {
                qnt = map[y][x] == DOT_WINNER ? qnt + 1 : 0;
                if (qnt == DOTS_TO_WIN)
                    return true;
            }
        }

        // Совпадения по диагоналям
        int cycleQnt = map.length - DOTS_TO_WIN + 1;
        // Главная диагональ
        for (int c = 0; c < cycleQnt; c++)
            for (int r = 0; r < cycleQnt; r++) {
                qnt = 0;
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    qnt = map[i + r][i + c] == DOT_WINNER ? qnt + 1 : 0;
                    if (qnt == DOTS_TO_WIN)
                        return true;
                }
            }

        // Побочная диагональ
        for (int c = 0; c < cycleQnt; c++)
            for (int r = 0; r < cycleQnt; r++) {
                qnt = 0;
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    qnt = map[i + r][DOTS_TO_WIN - 1 - i + c] == DOT_WINNER ? qnt + 1 : 0;
                    if (qnt == DOTS_TO_WIN)
                        return true;
                }
            }

        return false;
    }

    private static boolean checkDraw()
    {
        for (char[] row : map)
            for (int i = 0; i < map.length; i++)
                if (row[i] == DOT_EMPTY)
                    return false;

        return true;
    }

    private static void stepHuman()
    {
        int x,y;
        boolean res,isFirst;
        isFirst = true;
        do
        {
            if (!isFirst)
                System.out.println("Координаты введены не верно, или ячейка уже занята!");

            do
            {
                System.out.println("Укажите координату вашего хода (строка) в диапозоне от 1 до " + map.length);
                x = sc.nextInt() - 1;
            } while (x < 0 || x >= map.length);
            do
            {
                System.out.println("Укажите координату вашего хода (столбец) в диапозоне от 1 до " + map.length);
                y = sc.nextInt() - 1;
            } while (y < 0 || y >= map.length);

            res = checkStep(x,y);
            isFirst = false;
        } while (!res);

        map[x][y] = DOT_X;
    }

    private static boolean checkStep(int x, int y)
    {
        return ((x >= 0 && x < map.length) &&
                (y >= 0 && y < map.length) &&
                (map[x][y] == DOT_EMPTY)
                );
    }

    private static void setMapSize()
    {
        int SIZE;
        do
        {
            System.out.println("Введите размер поля, в диапозоне от 3 до 100 включительно: ");
            SIZE = sc.nextInt();
        } while (SIZE < 3 || SIZE > 100);
        System.out.println("Размер поля установлен как " + SIZE);
        map = new char[SIZE][SIZE];
    }

    private static void setDotsToWin()
    {
        do
        {
            System.out.println("Установите кол-во подряд идущих символов до победы, в диапозоне от 3 до " + map.length);
            DOTS_TO_WIN = sc.nextInt();
        } while (DOTS_TO_WIN < 3 || DOTS_TO_WIN > map.length);
        System.out.println("Кол-во подряд идущих символов до победы установлен как " + DOTS_TO_WIN);
    }

    private static void refreshMap()
    {
        for (char[] row : map)
            for (int i = 0; i < row.length; i++)
                row[i] = DOT_EMPTY;

        System.out.println("Поле подготовлено к игре");
    }

    private static void printMap()
    {
        //System.out.println("");
        for (char[] row : map)
        {
            for (int i = 0; i < row.length; i++)
                System.out.print(row[i] + " ");
            System.out.println("");
        }
    }
}
