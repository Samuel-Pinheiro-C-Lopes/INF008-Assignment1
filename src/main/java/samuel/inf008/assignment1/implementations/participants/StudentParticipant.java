package samuel.inf008.assignment1.implementations.participants;

import samuel.inf008.assignment1.abstractions.Participant;

public class StudentParticipant extends Participant {
    private static Integer currentId = 1;

    public StudentParticipant(String name, String cpf) {
        super(name, cpf);
        this.currentId++;
    }

    @Override
    protected Integer getCurrentId() {
        return this.currentId;
    }
}
