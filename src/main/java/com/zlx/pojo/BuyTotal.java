package com.zlx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyTotal {
    @Id
    @GeneratedValue
    private int totalid;
    private int uid;
    private double salesMoney;
    private double payMoney;
    private double changeMoney;
    private int adminid;
    //一条总记录里有多条详细记录
    private List<BuyRecord> buyRecordList;
    //一条总记录里对应着一个用户;
    private User user;
}
