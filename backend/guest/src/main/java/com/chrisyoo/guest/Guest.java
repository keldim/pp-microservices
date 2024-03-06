package com.chrisyoo.guest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Guest {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
