package com.zlx.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//表分页需要传给前端接口的数据格式
public class TableData {
    private int code;//前端状态
    private String msg;//状态信息
    private long count;//数据总数
    private Object data;//数据
}
