package com.company;

import java.util.Date;

public class TaskGetOrder extends Tasks {
    public TaskGetOrder() {
        super(Modes.GetOrder, true, "min", 22, new Date());
    }

    @Override
    public void Execute() {
        super.Execute();
        // Запуск бизнеспроцесса
    }
}
