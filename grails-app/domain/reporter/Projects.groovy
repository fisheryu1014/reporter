package reporter

import org.hibernate.validator.constraints.Email

import java.time.LocalDateTime

class Projects {

    String projectName
    String describe
    Boolean isActive

    LocalDateTime remindTime

    Email reportSendTo
    Email reportCC

    static hasMany = [members: Members, reports:DailyReport]

    static constraints = {
        projectName(nullable: false, unique: true)
        reportSendTo(nullable: false)
        reportCC(nullable: false)
    }
}
