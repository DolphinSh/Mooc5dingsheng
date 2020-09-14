package com.bilibili.datasource.vo;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TableData {
    private Integer count;
    private Integer code;
    private String msg;
    private ArrayList data;
}
