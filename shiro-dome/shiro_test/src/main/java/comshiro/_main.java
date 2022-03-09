package comshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("comshiro.mapper")
public class _main {
    public static void main(String[] args) {
        SpringApplication.run(_main.class,args);
    }

}
