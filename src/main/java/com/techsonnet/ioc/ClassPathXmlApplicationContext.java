package com.techsonnet.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{
    // 存放生成的对象
    Map<String,Object> iocContainer = new HashMap<String, Object>();

    // 无参构造
    public ClassPathXmlApplicationContext(String path){
        // 1.读取解析xml
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(path);
            Element rootElement = document.getRootElement();

            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()){
                Element element = iterator.next();
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");

                // 2.通过反射实例化xml的bean
                Class clazz = Class.forName(className);
                Constructor constructor = clazz.getConstructor();
                Object o = constructor.newInstance();

                // 如有必要，可以继续读取xml,同时通过反射机制为各对象进行赋值
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 获取生成的对象
    public Object getBean(String id) {
        return iocContainer.get(id);
    }
}
