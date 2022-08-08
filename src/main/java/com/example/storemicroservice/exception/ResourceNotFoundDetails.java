package com.example.storemicroservice.exception;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResourceNotFoundDetails {
    private String title;
    private int status;
    private String detail;
    private LocalDateTime timestamp;
    private String develperMessage;
}


