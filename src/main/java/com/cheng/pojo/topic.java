package com.cheng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class topic {
    private int tId;
    private int sId;
    private int uId;
    private String tTitle;
    private String tContent;
    private Date tTime;
    private int tLike;



}
