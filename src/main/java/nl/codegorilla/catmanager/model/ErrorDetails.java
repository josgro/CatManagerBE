package nl.codegorilla.catmanager.model;

import java.time.LocalDateTime;

public class ErrorDetails {
    private final LocalDateTime timestamp;
    private final String error;

    public ErrorDetails(LocalDateTime timestamp, String error) {
        this.timestamp = timestamp;
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }
}
