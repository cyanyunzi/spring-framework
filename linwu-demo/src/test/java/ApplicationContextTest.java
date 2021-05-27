import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class ApplicationContextTest {
    @Test
    public void applicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LinwuService.class,LinwuComponent.class);
        context.refresh();

        LinwuService bean = context.getBean(LinwuService.class);
        System.out.println(bean);
    }

    @Configuration
    static class Config {}

    @Service
    static class LinwuService {
        @Autowired
        private LinwuComponent linwuComponent;
    }
    @Component
    static class LinwuComponent {
        @Autowired
        private LinwuService linwuService;
    }


}
