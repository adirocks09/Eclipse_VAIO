package com.arisglobal.msklambda;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LambdaResponse {

    private String uuid;
    private Integer status = 0;
    private Message message ;

}
