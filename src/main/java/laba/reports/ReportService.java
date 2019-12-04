package laba.reports;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ReportService<T> {
    public File createReport(String fileName) throws IOException;
}
