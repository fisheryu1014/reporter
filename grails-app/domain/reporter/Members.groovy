package reporter

import org.hibernate.validator.constraints.Email

class Members {

    String userName
    Email email

    static hasMany = [projects: Projects, reports: DailyReport]

    static constraints = {
        userName(nullable: false, unique: true)
        email(nullable: false)
    }
}
