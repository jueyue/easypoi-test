package cn.afterturn.easypoi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("cn.afterturn.easypoi") web的几个view 在这个目录下载,如果是自己的项目需要加入这个目录
@ComponentScan("cn.afterturn.easypoi")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}