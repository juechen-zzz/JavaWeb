package com.komorebi.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 等价于注册了一个bean
@Component
@Scope("prototype")
public class User {
    @Value("komorebi")
    public String name;
}
