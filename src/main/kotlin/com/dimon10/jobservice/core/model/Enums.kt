package com.dimon10.jobservice.core.model

import com.fasterxml.jackson.annotation.JsonValue

enum class Role(@JsonValue val role: String) {
    ANALYST("Analyst"),
    BACKEND_DEVELOPER("Backend Developer"),
    WEB_DEVELOPER("Web Developer"),
    MOBILE_DEVELOPER("Mobile Developer"),
    FULLSTACK_DEVELOPER("Backend Developer"),
    QA_MANUAL("QA Manual Engineer"),
    QA_AUTOMATION("QA Automation Engineer"),
    DEVOPS("DevOps Engineer"),
    ML_ENGINEER("ML Engineer"),
    UI_DESIGNER("UI Designer"),
    TEAM_LEAD("Team Lead"),
    TECH_LEAD("Tech Lead"),
    SOFTWARE_ARCHITECT("Software Architect"),
    MANAGER("Manager"),
    PROJECT_MANAGER("Project Manager"),
    CEO("CEO")
}

enum class Field(@JsonValue val field: String) {
    BACKEND("Backend"),
    FRONTEND("Frontend"),
    MOBILE("Mobile"),
    QA("QA"),
    DEVOPS("DevOps"),
    ARCHITECTURE("Architecture"),
    ML("ML"),
    AI("AI"),
    ANALYSIS("Analysis"),
    UI("UI"),
    MANAGEMENT("Management"),
    OTHER("Other")
}

enum class Level(@JsonValue val level: String) {
    SENIOR("Senior"),
    MIDDLE("Middle"),
    JUNIOR("Junior"),
    INTERNSHIP("Internship")
}

enum class Language(@JsonValue val language: String) {
    BULGARIAN("Bulgarian"),
    CROATIAN("Croatian"),
    CZECH("Czech"),
    DANISH("Danish"),
    DUTCH("Dutch"),
    ENGLISH("English"),
    ESTONIAN("Estonian"),
    FINNISH("Finnish"),
    FRENCH("French"),
    GERMAN("German"),
    GREEK("Greek"),
    ITALIAN("Italian"),
    NORWEGIAN("Norwegian"),
    POLISH("Polish"),
    PORTUGUESE("Portuguese"),
    RUSSIAN("Russian"),
    ROMANIAN("Romanian"),
    SLOVAK("Slovak"),
    SLOVENIAN("Slovenian"),
    SPANISH("Spanish"),
    SWEDISH("Swedish"),
}

enum class Country(@JsonValue val country: String) {
    ALBANIA("Albania"),
    ANDORRA("Andorra"),
    ARMENIA("Armenia"),
    AUSTRIA("Austria"),
    BELARUS("Belarus"),
    BELGIUM("Belgium"),
    BOSNIA_AND_HERZEGOVINA("Bosnia and Herzegovina"),
    BULGARIA("Bulgaria"),
    CROATIA("Croatia"),
    CYPRUS("Cyprus"),
    CZECH_REPUBLIC("Czech Republic"),
    DENMARK("Denmark"),
    ESTONIA("Estonia"),
    FINLAND("Finland"),
    FRANCE("France"),
    GEORGIA("Georgia"),
    GERMANY("Germany"),
    GREECE("Greece"),
    HUNGARY("Hungary"),
    ICELAND("Iceland"),
    IRELAND("Ireland"),
    ITALY("Italy"),
    KOSOVO("Kosovo"),
    LATVIA("Latvia"),
    LIECHTENSTEIN("Liechtenstein"),
    LITHUANIA("Lithuania"),
    LUXEMBOURG("Luxembourg"),
    MALTA("Malta"),
    MOLDOVA("Moldova"),
    MONACO("Monaco"),
    MONTENEGRO("Montenegro"),
    NETHERLANDS("Netherlands"),
    NORTH_MACEDONIA("North Macedonia"),
    NORWAY("Norway"),
    POLAND("Poland"),
    PORTUGAL("Portugal"),
    ROMANIA("Romania"),
    RUSSIA("Russia"),
    SAN_MARINO("San Marino"),
    SERBIA("Serbia"),
    SLOVAKIA("Slovakia"),
    SLOVENIA("Slovenia"),
    SPAIN("Spain"),
    SWEDEN("Sweden"),
    SWITZERLAND("Switzerland"),
    UKRAINE("Ukraine"),
    UNITED_KINGDOM("United Kingdom"),

}

enum class JobType(@JsonValue val jobType: String) {
    FULL_TIME("Full-time"),
    PART_TIME("Part-time"),
    CONTRACT("Contract"),
    TEMPORARY("Temporary"),
    VOLUNTEER("Volunteer"),
    INTERNSHIP("Internship"),
    OTHER("Other")
}

enum class SocialResource(@JsonValue val resource: String) {
    SITE("Site"),
    LINKEDIN("LinkedIn"),
    FACEBOOK("Facebook"),
    TWITTER("Twitter"),
    GITHUB("GitHub"),
    STACKOVERFLOW("StackOverflow"),
    TELEGRAM("Telegram"),
    SKYPE("Skype"),
}
