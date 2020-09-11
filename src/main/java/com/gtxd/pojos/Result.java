package com.gtxd.pojos;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Result {
    private String result;
    private String url;

    public Result() {
    }

    public Result(String result, String url) {
        this.result = result;
        this.url = url;
    }
}
