package laba.reports;

import laba.objects.ServiceType;
import laba.service.ServTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service("services_types")
public class ReportServTypeServiceImpl implements ReportService<ServiceType> {

    private String directory = "./downloads/txt";

    @Autowired
    ServTypeService servTypeService;

    @Override
    public File createReport(String fileName) throws IOException {
        String str = "Код типа услуги\tНаименование типа услуги\r\n";
        List<ServiceType> serviceTypeList = servTypeService.findAll();
        for (ServiceType temp : serviceTypeList) {
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
