package cn.wq.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 注意：@MapperScan("com.winter.mapper")这个注解非常的关键，这个对应了项目中mapper（dao）所对应的包路径，很多同学就是这里忘了加导致异常的
 */
@SpringBootApplication
@MapperScan("cn.wq.demo.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

