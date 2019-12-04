package laba.reports;

import laba.objects.Service;
import laba.service.ServService;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Service("services")
public class ReportServServiceImpl implements ReportService<Service> {

    private String directory = "./downloads/txt";

    @Autowired
    ServService servService;

    @Override
    public File createReport(String fileName) throws IOException {
        String str = "Код услуги\tНаименование услуги\t\t\tНаименование типа услуги\tСтоимость\r\n";
        List<Service> servicesList = servService.findAll();
        for (Service temp : servicesList) {
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
