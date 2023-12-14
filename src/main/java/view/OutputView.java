package view;

import model.Crew;
import model.Crews;

import java.util.Iterator;
import java.util.List;

public class OutputView {

    public static final String ERROR_FORM = "[ERROR] %s%n";

    public void printErrorMessage(Throwable throwable) {
        System.out.printf(ERROR_FORM, throwable.getMessage());
    }

    public void printMatchingResult(List<Crews> matched) {
        System.out.println("페어 매칭 결과입니다.");
        for (Crews crews : matched) {
            printValues(crews.getIterator());
        }
    }

    private void printValues(Iterator<Crew> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next().getName());
            if (iterator.hasNext()) {
                System.out.print(" : ");
            }
        }
        System.out.println();
    }
}