package laba.reports;

import laba.objects.CompleteServices;
import laba.objects.CompleteServicesDTS;
import laba.service.CompleteServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service("complete_services")
public class ReportCompleteServServiceImpl implements ReportService<CompleteServices> {

    private String directory = "./downloads/txt";

    @Autowired
    CompleteServService completeServService;

    @Override
    public File createReport(String fileName) throws IOException {
        String str = "ID\tНаименование услуги\t\t\t\tФИО врача\t\tФИО пациента\t\tДата оказания\tВремя начала\tВремя окончания\tСтоимость\r\n";
        List<CompleteServicesDTS> completeServicesList = completeServService.findAll();
        for (CompleteServicesDTS temp : completeServicesList) {
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
