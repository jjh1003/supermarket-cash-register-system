package com.zlx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Goods {
    private Integer gid;
    private String gNo;
    private String gName;

    private String price;
    private String isBargainPrice;
    private String bargainPrice;
    private String unit;
    private String stock;
}
