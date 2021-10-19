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
public class MemberDto {

    @NotBlank
    @Size(min = 1, max = 99999, message = "1이상 입력하세요")
    private Integer idx;
    private Date date;
    private String memberName;
    private Integer rateTime;


    /**
     *
     * @author green
     * @version 1.0
     * @see MemberDto
     * */
    @Getter
    @Setter
    public static class Response{
        private String memberName;
        private Integer rateTime;


    }


}
