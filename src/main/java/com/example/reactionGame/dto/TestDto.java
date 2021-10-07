package com.example.reactionGame.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@ToString
@Getter
@Setter
public class TestDto {

    @NotBlank
    @Size(min = 10, max = 99999, message = "10이상 입력하세요")
    private Integer idx;
    private Date date;
    private String name;
    private Integer ratetime;


}
