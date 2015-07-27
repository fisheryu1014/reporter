package reporter

import java.time.LocalDate

class DailyReport {

    String details
    LocalDate date


    static belongsTo = [project: Projects, author: Members ]


    static constraints = {
        details(nullable: false)
    }
}
