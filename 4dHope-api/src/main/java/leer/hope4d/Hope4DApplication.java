package leer.hope4d;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("leer.hope4d.mapper")
public class Hope4DApplication {
    public static void main(String[] args) {
        SpringApplication.run(Hope4DApplication.class, args);
    }
}
