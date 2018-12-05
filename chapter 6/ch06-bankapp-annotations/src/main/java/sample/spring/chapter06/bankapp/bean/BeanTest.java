package sample.spring.chapter06.bankapp.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Auther: chaoqiang.zhou
 * @Date: 2018/12/5 14:44
 * @Description:
 */
@Service(value = "BeanTest")
public class BeanTest implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, BeanPostProcessor {
//


    public BeanTest() {
        System.out.println("我被初始化了");
    }

    private int i = 0;

    @Override
    public void destroy() throws Exception {

        i++;
        System.out.println("destroy" + i);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        i++;
        System.out.println("afterPropertiesSet" + i);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        i++;
        System.out.println("setBeanFactory" + i);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("我的名字是" + s);
        i++;
        System.out.println("setBeanName" + i);

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        i++;
        System.out.println("postProcessBeforeInitialization" + i);

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        i++;
        System.out.println("beanName" + i);
        return bean;

    }


    //
}
