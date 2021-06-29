package com.zlx.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//管理员账号类
public class Admin {
    @Id
    @GeneratedValue
    private Integer adminid;
    private String username;
    private String password;
    private String identify;
    //一个收银台有多条记录
    private List<BuyTotal> buyTotalList;
}
