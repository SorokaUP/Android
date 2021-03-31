package com.company;

import java.util.Date;

public class TaskRez extends Tasks {
    public TaskRez() {
        super(Modes.Rez, true, "min", 10, new Date());
    }

    @Override
    public void Execute() {
        super.Execute();
        // Отправка сообщения на склад
        // Запуск бизнеспроцесса
    }
}
