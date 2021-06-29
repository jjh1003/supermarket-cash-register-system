package com.zlx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BuyRecord {
    private int totalid;
    private int gid;
    private int buyAmount;
    //一条详细记录记录着一个商品
    private Goods goods;
}
