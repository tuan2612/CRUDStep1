package com.leadsgen.project.messenger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Response {
        private HttpStatus httpCode;
        private String message;
        private String detailMessage;

}
