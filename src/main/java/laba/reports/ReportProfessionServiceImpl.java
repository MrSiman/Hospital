package laba.reports;

import laba.objects.Profession;
import laba.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service("professions")
public class ReportProfessionServiceImpl implements ReportService<Profession> {

    private String directory = "./downloads/txt";

    @Autowired
    ProfessionService professionService;

    @Override
    public File createReport(String fileName) throws IOException {
        String str = "Код должности\t\tНазвание должности\r\n";
        List<Profession> professionsList = professionService.findAll();
        for (Profession temp : professionsList) {
            str += temp.toString();
        }
        File report = new File(directory, fileName + ".txt");
        System.out.println(report.createNewFile());
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(report));
        bufferedWriter.write(str);
        bufferedWriter.close();
        return report;
    }
}
