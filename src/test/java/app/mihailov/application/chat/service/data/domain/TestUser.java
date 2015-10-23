package app.mihailov.application.chat.service.data.domain;

import app.mihailov.application.chat.service.data.annotation.MColumn;
import app.mihailov.application.chat.service.data.annotation.MTable;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Дмитрий
 * Date: 23.10.2015.
 */

public class TestUser {

    private static Class clazz;

    @BeforeClass
    public static void initBefore(){
        try {
            clazz = Class.forName("app.mihailov.application.chat.service.data.domain.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void destroyAfter(){

    }

    /**
     * description:
     *  Проверка поиска аннотации MTable у класса
     */
    @Test
    public void TestClassMTable(){
        MTable annotation = (MTable) clazz.getAnnotation(MTable.class);
        Assert.assertNotNull(annotation);
        Assert.assertEquals(annotation.name(),"user");
    }

    /**
     * description:
     *  Проверка поиска аннотации MColumn у методов класса
     */
    @Test
    public void TestClassMColumn(){
        Method[] methods = clazz.getMethods();
        Map<String, Method> getMethods = new HashMap<String, Method>();
        Map<String, Method> setMethods = new HashMap<String, Method>();
        for(int index = 0; index < methods.length; index++){
            Method method = methods[index];
            System.out.println("index = " + index + " method name = " + method.getName());
            if (method.getName().indexOf("get") == 0){
                MColumn mColumn = method.getAnnotation(MColumn.class);
                if (Objects.isNull(mColumn)){
                    continue;
                }
                String methodGetName = method.getName().substring(3);
                getMethods.put(methodGetName, method);
            }else if(method.getName().indexOf("set") == 0){
                String methodSetName = method.getName().substring(3);
                setMethods.put(methodSetName, method);
            }
        }
        Assert.assertEquals(getMethods.size(),setMethods.size());
        for( String key: getMethods.keySet()){
            System.out.println("key = " + key);
        }

    }
}
