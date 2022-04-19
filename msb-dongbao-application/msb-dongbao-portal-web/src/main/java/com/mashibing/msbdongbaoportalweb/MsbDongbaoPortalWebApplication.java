package com.mashibing.msbdongbaoportalweb;
import org.mybatis.spring.annotation.MapperScan;import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = {"com.mashibing"})
@MapperScan("com.mashibing.msbdongbaoums.mapper")
public class MsbDongbaoPortalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsbDongbaoPortalWebApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
