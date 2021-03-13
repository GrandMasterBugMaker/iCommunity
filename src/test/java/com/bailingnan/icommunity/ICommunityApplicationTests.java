package com.bailingnan.icommunity;

import com.bailingnan.icommunity.dao.AlphaDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes=ICommunityApplication.class)
class ICommunityApplicationTests implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplicationContext(){
        System.out.println(applicationContext);
        AlphaDao alphaDao=applicationContext.getBean(AlphaDao.class);
        System.out.println(alphaDao.select());

        alphaDao=applicationContext.getBean("alphaHibernate",AlphaDao.class);
        System.out.println(alphaDao.select());
    }
}
