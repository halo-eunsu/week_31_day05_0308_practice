package com.nhnacademy.security.model;

import lombok.Data;

@Data
public class MemberCreateRequest {
    private final String name;
    private final String pwd;
    private final String authority;

}
