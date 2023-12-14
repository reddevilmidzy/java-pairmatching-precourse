package pairmatching.view;

import pairmatching.model.Crew;
import pairmatching.model.Crews;

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
        System.out.println();
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

    public void printReset() {
        System.out.println("초기화 되었습니다.");
        System.out.println();
    }
}