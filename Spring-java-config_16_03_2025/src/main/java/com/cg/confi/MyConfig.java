package com.cg.confi;

import com.cg.bean.Address;
import com.cg.bean.Employee;
import com.cg.bean.HelloWorld;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:data.properties")
@ComponentScan("com")
public class MyConfig {
//    @Bean("h")
//    @Scope("prototype")
//    public HelloWorld getBeans(){
//        return new HelloWorld();
//
//    }
//    @Bean
//    public Employee getBean1(){
//        return  new Employee(getBean2());
//
//    }
//    @Bean
//    public Address getBean2(){
//        return new Address();
//    }
}
