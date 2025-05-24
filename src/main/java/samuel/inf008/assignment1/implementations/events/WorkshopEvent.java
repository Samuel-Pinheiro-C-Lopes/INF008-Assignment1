package samuel.inf008.assignment1.implementations.event;

import samuel.inf008.assignment1.abstractions.Event;

import java.util.Date;

public class WorkshopEvent extends Event {
    private static Integer currentId = 1;

    public WorkshopEvent(String name, Date date, int vacancies, boolean inPerson) {
        super(name, date, vacancies, inPerson);
        this.currentId++;
    }

    @Override
    protected Integer getCurrentId() {
        return this.currentId;
    }
}
