package com.example.demo.designpatterns.apiImpl.strategy2;

import com.example.demo.common.interfaces.OrderHandlerType;
import lombok.Data;

import java.lang.annotation.Annotation;

/**
 * @author HB
 * @data 2020/10/14 16:15
 * @Description: 控制层
 */
@Data
public class OrderHandlerTypeImpl implements OrderHandlerType {

    private String source;

    private String payMethod;

    OrderHandlerTypeImpl(String source, String payMethod) {
        this.source = source;
        this.payMethod = payMethod;
    }

    @Override
    public String source() {
        return source;
    }

    @Override
    public String method() {
        return payMethod;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return OrderHandlerTypeImpl.class;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        if (source != null) {
            hashCode += (127 * "source".hashCode()) ^ source.hashCode();
        }
        if (payMethod != null) {
            hashCode += (127 * "method".hashCode()) ^ payMethod.hashCode();
        }
        return hashCode;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OrderHandlerType)) {
            return false;
        }
        OrderHandlerType other = (OrderHandlerType) obj;
        Boolean flag1 = true;
        Boolean flag2 = true;
        if (source != null) {
            flag1 = source.equals(other.source());
        }
        if (payMethod != null) {
            flag2 = payMethod.equals(other.method());
        }
        return flag1 && flag2;
    }
}
