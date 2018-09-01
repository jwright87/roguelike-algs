appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger - %msg%n"
    }
}

appender("FILE", FileAppender) {
    file = "is-logs/roguelike-algs.log"
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} %level %logger{35} - %msg%n"
    }
}



root(WARN, ["CONSOLE", "FILE"])

logger("com.intenso", INFO)


