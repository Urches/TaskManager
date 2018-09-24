package com.project.spring;

import org.springframework.beans.factory.DisposableBean;

public class SpringFinilazer implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
        //HibernateUtils.turnOffHibernate();
    }
}
