class Solution {
    public char nthCharacter(int n) {
        long pos = n;
        long digits = 1;
        long start = 1;

        while (pos > 9 * start * digits) {
            pos -= 9 * start * digits;
            digits++;
            start *= 10;
        }

        long number = start + (pos - 1) / digits;
        int index = (int) ((pos - 1) % digits);

        return String.valueOf(number).charAt(index);
    }
}