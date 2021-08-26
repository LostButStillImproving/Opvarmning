package FirstOpgave;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Opvarmning {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Double> listOfNumbers = new ArrayList<>();
    String[] exitCharacters = {"q", "Q"};
    String greeting = "Hej med Dig";
    String indtastTalBesked = "Indtast et tal";
    String indtastEndnuEtTalBesked = "indtast endnu et tal";
    String gennemsnitBesked = "Gennemsnittet af de indtastede tal er: ";
    String forkertInputBesked = "This is the wrong kind of input, matey ";
    String weDoneBesked = "We be done";


    public void greetUser() {
        System.out.println(greeting);
    }
    public String askForNumber() throws IOException {
        if (listOfNumbers.isEmpty()) {
            System.out.print(indtastTalBesked);
        } else {
            System.out.print(indtastEndnuEtTalBesked);
        }

        return reader.readLine();
    }

    public boolean isANumber(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isExitInput(String input) {
        return Arrays.asList(exitCharacters).contains(input);
    }

    public double calculateAverage(List<Double> numbers) {
        double total = 0;
        int amountOfNumbers = numbers.size();
        for (Double number:numbers) {
            total += number;
        }

        return total / amountOfNumbers;
    }

    public void averager() throws IOException {
        var calculationOngoing = true;
        greetUser();
        do {
            var input = askForNumber();
            calculationOngoing = !isExitInput(input);
            if (!isANumber(input)) {
                System.out.println(forkertInputBesked);
                continue;
            }
            if (isANumber(input)) {
                listOfNumbers.add(Double.parseDouble(input));
            }
            var average = calculateAverage(listOfNumbers);
            System.out.println(gennemsnitBesked + average);
        } while (calculationOngoing);
        System.out.println(weDoneBesked);
    }


    public static void main(String[] args) throws IOException {
        Opvarmning opvarmning = new Opvarmning();
        opvarmning.averager();
    }
}
