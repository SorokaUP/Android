package com.company;

public class Job {
    public  String Mode;
    public Job(String Mode) {
        this.Mode = Mode;
    }

    public void Execute()
    {
        switch (this.Mode)
        {
            case Modes.Rez:
                // Загрузка резервов
                break;

            case Modes.Def:
                // Выгрузка дефектуры
                break;

            case Modes.GetOrder:
                // Загрузить заказы в систему
                break;

            case Modes.Vzvr:
                // Выгрузка возвратов покупателя
                break;

            default:
                return;
        }
    }
}
