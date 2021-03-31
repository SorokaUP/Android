package com.company;

public class Main {

    public static void main(String[] args) {
        Tasks[] ts = { new TaskDef(), new TaskRez(), new TaskGetOrder(), new TaskGetVzvr() };
        for (Tasks t : ts)
        {
            if (t instanceof TaskDef)
            {
                // Предподготовка
                t.Execute();
            }
            else
                t.Execute();
        }
    }
}
