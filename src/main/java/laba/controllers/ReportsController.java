package laba.controllers;

import laba.service.*;
import laba.reports.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.util.Map;

@Controller
public class ReportsController {

    @Autowired
    ServTypeService servTypeService;
    @Autowired
    ServService servService;
    @Autowired
    ProfessionService professionService;
    @Autowired
    DoctorsService doctorsService;
    @Autowired
    PatientService patientService;
    @Autowired
    CompleteServService completeServService;

    @Autowired
    private Map<String, ReportService> reportServiceMap;

    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public String reports() {
        return "reports";
    }

    @RequestMapping(value = "/reports/download", method = RequestMethod.GET)
    public String downloadTXTReport(HttpServletRequest request, HttpServletResponse response, @RequestParam("report_name") String fileName,
                                    @RequestParam("report_type") String reportType) {


        ReportService service = reportServiceMap.get(reportType);
        try {
            File file = service.createReport(fileName);
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            String mimeType = URLConnection.guessContentTypeFromStream(inputStream);
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/reports";
    }
}
