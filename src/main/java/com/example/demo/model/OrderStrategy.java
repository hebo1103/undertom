package com.example.demo.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author HB
 * @data 2020/10/14 13:41
 * @Description: 控制层
 */
@Data
public class OrderStrategy {
    /**
     * 订单来源
     */
    private String source;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 订单编号
     */
    private String code;
    /**
     * 订单金额
     */
    private BigDecimal amount;
    // ...其他的一些字段
}
