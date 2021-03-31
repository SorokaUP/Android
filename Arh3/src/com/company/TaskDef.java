package com.company;

import java.util.Date;

public class TaskDef extends Tasks {
    public TaskGetOrder() {
        super(Modes.Def, true, "hour", 4, new Date());
    }

    @Override
    public void Execute() {
        super.Execute();
        // Запуск бизнеспроцесса
    }
}
