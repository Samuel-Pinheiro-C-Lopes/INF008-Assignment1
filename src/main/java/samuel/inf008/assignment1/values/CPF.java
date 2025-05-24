package samuel.inf008.assignment1.values;

import samuel.inf008.assignment1.values.abstraction.Value;

public class CPF extends Value<String>{
    private static final int cpfLength = 11;
    private static final int lastNonVerificerIndex = 8;

    public CPF(String value) {
        super(value);
    }

    @Override
    protected boolean validateValue(String value) {
        value = value.replace(".", "").replace("-", ""); // occurrences of dots or lashes
        // size
        if (value.length() != CPF.cpfLength)
            return false;

        // only numbers
        // (^ for the start of the line, [0-9] for the 0-9 range,
        // + to look for one or more occurrences and
        // $ to reach the end of the line)
        if (!value.matches("^[0-9]+$"))
            return false;

        // aren't all the same
        if (value.chars().distinct().count() == 1)
            return false;

        // first digit:
        int firstVerifierDigit = CPF.calculateVerifierDigit(value, CPF.lastNonVerificerIndex, 2);
        if ((value.charAt(CPF.lastNonVerificerIndex + 1) - '0') != firstVerifierDigit)
            return false;

        // second digit:
        int secondVerificerDigit = CPF.calculateVerifierDigit(value, CPF.lastNonVerificerIndex + 1, 2);
        if ((value.charAt(CPF.lastNonVerificerIndex + 2) - '0') != secondVerificerDigit)
            return false;

        return true;
    }

    private static int calculateVerifierDigit(String cpf,
    int currentIndex, int currentMultiplier) {
        int sum = 0;
        int remainder;
        for (; currentIndex >= 0; currentIndex--, currentMultiplier++)
            sum += (cpf.charAt(currentIndex) - '0') * currentMultiplier;
        remainder = sum%11;
        if (remainder < 2)
            return 0;
        return 11 - remainder;
    }
}
