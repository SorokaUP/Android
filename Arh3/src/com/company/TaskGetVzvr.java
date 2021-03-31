package com.company;

import java.util.Date;

public class TaskGetVzvr extends Tasks {
    public TaskGetVzvr() {
        super(Modes.Vzvr, true, "min", 22, new Date());
    }

    @Override
    public void Execute() {
        super.Execute();
        // Отправка сообщения клиенту
        // Запуск бизнеспроцесса
    }
}
