package samuel.inf008.assignment1.abstractions;

import samuel.inf008.assignment1.abstractions.Entity;
import samuel.inf008.assignment1.values.CPF;

public abstract class Participant extends Entity {
    private CPF cpf;

    public Participant(String name, String cpf) {
        super(name);
        this.cpf = new CPF(cpf);
    }

    @Override
    public void printSelf() {
        System.out.print("Name: "); super.printSelf(); System.out.println(".");
        System.out.println("CPF: " + this.cpf.get() + ".\n");
    }
}
