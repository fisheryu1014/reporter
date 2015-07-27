package reporter

import grails.transaction.Transactional

import java.time.LocalDate

@Transactional
class ReporterService {

    def mailService

    def storeReportsAndSendMail(params) {
        // 1: Save the new reports
        saveReport(params.reports)
        // 2: Try to send report mail
        trySendMail(params.project)
    }

    private saveReport(reports) {

    }

    private trySendMail(project) {
        if (!isAllMemberReported(project)) {
            return
        }
        sendReportMail(project)
    }

    private isAllMemberReported(project) {}

    private sendReportMail(project) {
        LocalDate today = LocalDate.now();
        def reportsOfToday = DailyReport.findAllByProjectAndDate(project, today);
        mailSender(project, reportsOfToday)
    }


    private mailSender(Projects project, reports) {
        log.info("Send daily report of " + project.projectName)

        mailService.sendMail{
            to project.reportSendTo
            cc project.reportCC
            subject project.projectName + " Daily Report"
            body (view: "The path of template html", model: [reports: reports])

        }
    }

}
