package com.company;

import java.util.Date;

public abstract class Tasks {
    /// <summary>
    /// Состояние "Факт выполнения" (по умолчанию true)
    /// </summary>
    private boolean Finished;
    /// <summary>
    /// Дата и время последнего запуска (по умолчанию начало отсчета времени 1869 год)
    /// </summary>
    public Date LastRun;
    /// <summary>
    /// Режим работы
    /// </summary>
    private String Mode;
    /// <summary>
    /// Задача активна
    /// </summary>
    public boolean isActive;
    /// <summary>
    /// Частота выполнения: d,h,m
    /// </summary>
    public String TimeType;
    /// <summary>
    /// Частота выполнения ЗНАЧЕНИЕ
    /// </summary>
    public int TimeValue;

    public Tasks(String Mode, boolean isActive, String TimeType, int TimeValue, Date LastRun)
    {
        this.Finished = true;
        this.LastRun = LastRun;
        this.Mode = Mode;
        this.isActive = isActive;
        this.TimeType = TimeType;
        this.TimeValue = TimeValue;
    }

    public void Execute()
    {
        if (this.Finished)
        {
            try
            {
                this.Finished = false;
                new Job(this.Mode).Execute();
            }
            catch (Exception e)
            {
                System.out.println("<!> Неожиданное исключение: " + e.getMessage() + e.getStackTrace());
            }
            finally
            {
                this.Finished = true;
            }
        }
    }

    public boolean isExecute()
    {
        return this.isActive;
    }
}
