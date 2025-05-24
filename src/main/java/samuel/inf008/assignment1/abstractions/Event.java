package samuel.inf008.assignment1.abstractions;

import samuel.inf008.assignment1.abstractions.Entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;

public abstract class Event extends Entity {
    private HashMap<Integer, Participant> registeredParticipants;
    private Date date;
    private int vacancies;
    private final boolean inPerson;

    protected Event(String name, Date date, int vacancies, boolean inPerson) {
        super(name);
        this.registeredParticipants = new HashMap<Integer, Participant>();
        this.date = date;
        this.vacancies = vacancies;
        this.inPerson = inPerson;
    }

    public boolean registerParticipant(Participant participant) {
        if (!(this.inPerson || this.validateCellphoneNumber()))
            return false;
        if (this.vacancies > 0 &&
        this.registeredParticipants.putIfAbsent(participant.getId(), participant) == null) {
            this.vacancies++;
            return true;
        }
        return false;
    }

    @Override
    public void printSelf() {
        Iterator<Participant> participantIterator =
            this.registeredParticipants.values().iterator();
        System.out.print("Name: "); super.printSelf(); System.out.println(".");
        System.out.println("Date: " + this.date.toString() + ".");
        System.out.println("Participants: ");
        System.out.println("--------------------");
        while (participantIterator.hasNext())
            participantIterator.next().printSelf();
        System.out.println("--------------------\n");
    }

    public boolean validateCellphoneNumber() {
        // validation...
        return true;
    }
}
