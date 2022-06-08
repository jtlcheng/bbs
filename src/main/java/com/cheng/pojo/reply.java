package com.cheng.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class reply {
    int rid;
    int tid;
    int uid;
    String rcontent;
    Date rtime;
    int rstatue;
    int status;

}
