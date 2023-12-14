package util;

import model.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class ReadingFileTest {

    @Test
    @DisplayName("파일 입력 확인")
    void createFileReading() throws IOException {

        List<String> be = ReadingFile.readCrewNames(Course.BACKEND);
        List<String> fe = ReadingFile.readCrewNames(Course.FRONTEND);

    }
}