package com.mtugo.HMS.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessTokenDTO {

    public String accessToken;

    public String expiresIn;

}
