package reporter

class ReporterController {

    static allowedMethods = [index: "POST"]

    def reporterService

    def index() {
        //1. get params and save()
        saveReport(params)

    }

    private saveReport (params) {
        reporterService.storeReportsAndSendMail(params)
    }
}
