package comshiro.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class appllicationContextUtil implements ApplicationContextAware {

    static ApplicationContext applicationContexts;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    applicationContexts=applicationContext;
    }

    public  static Object getbean(String beanname){
        Object s=applicationContexts.getBean(beanname);
        return s;
    }

}
