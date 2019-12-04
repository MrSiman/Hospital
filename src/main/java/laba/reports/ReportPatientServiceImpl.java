package laba.reports;

import laba.objects.PatientDTS;
import laba.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service(value = "patients")
public class ReportPatientServiceImpl implements ReportService<PatientDTS> {
    private String directory = "./downloads/txt";

    @Autowired
    PatientService patientService;

    @Override
    public File createReport(String fileName) throws IOException {
        String str = "Номер паспорта\t\tФИО пациента\t\tДата рождения\tДата записи\tПол\t\tФИО врача\r\n";
        List<PatientDTS> patientDTSList = patientService.findAll();
        for (PatientDTS temp : patientDTSList) {
            str += temp.toString();
        }
        File report = new File(directory, fileName + ".txt");
        System.out.println(report.createNewFile());
        System.out.println(report.getAbsolutePath());
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(report));
        bufferedWriter.write(str);
        bufferedWriter.close();
        return report;
    }
}
