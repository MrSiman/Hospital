package laba.reports;

import laba.objects.Doctor;
import laba.service.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service(value = "doctors")
public class ReportDoctorServiceImpl implements ReportService<Doctor> {

    private String directory = "./downloads/txt";

    @Autowired
    DoctorsService doctorsService;

    @Override
    public File createReport(String fileName) throws IOException {
        String str = "Номер паспорта\t\tФИО врача\t\t\tДолжность\tЗаработная плата\tПол\r\n";
        List<Doctor> doctorList = doctorsService.findAll();
        for (Doctor temp : doctorList) {
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
