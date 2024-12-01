package dev.ofiucoder.jpkatadni.models;


public class DniModel {
    private static final char[] LETTERS = {
            'T', 'R', 'W',
            'A', 'G', 'M', 
            'Y', 'F', 'P', 
            'D', 'X', 'B',
            'N', 'J', 'Z', 
            'S', 'Q', 'V', 
            'H', 'L', 'C', 
            'K', 'E'
    };

    public char calculateVerifyLetter(int dniNumber) {
        if (dniNumber < 0) {
            throw new IllegalArgumentException("Invalid input or data missmach. Please enter a valid numeric value.");
        }
        if (dniNumber < 10000000 || dniNumber > 99999999) {
            throw new IllegalArgumentException("DNI number must have eight (8) digits.");
        }
        return LETTERS[dniNumber % 23];
    }
}
