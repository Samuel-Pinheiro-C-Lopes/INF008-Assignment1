package samuel.inf008.assignment1.implementations.event;

import samuel.inf008.assignment1.abstractions.Event;
import samuel.inf008.assignment1.abstractions.Participant;
import samuel.inf008.assignment1.implementations.participants.StudentParticipant;

import java.util.Date;

public class CourseEvent extends Event {
    private static Integer currentId = 1;

    public CourseEvent(String name, Date date, int vacancies, boolean inPerson) {
        super(name, date, vacancies, inPerson);
        this.currentId++;
    }

    @Override
    protected Integer getCurrentId() {
        return this.currentId;
    }

    @Override
    public boolean registerParticipant(Participant participant) {
        if (!(participant instanceof StudentParticipant))
            return false;
        return super.registerParticipant(participant);
    }
}
