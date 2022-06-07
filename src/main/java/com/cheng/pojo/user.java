package com.cheng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
    private Integer uid;
    private String uname;
    private String upwd;
    private String uemail;
    private char usex;
    private Date uregDate;
    private String Perms;
}
