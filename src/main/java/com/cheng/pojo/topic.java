package com.cheng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class topic {
    private int tid;
    private int sid;
    private int uid;
    private String ttitle;
    private String tcontent;
    private Date ttime;
    private int tlike;
    section section;




}
