package com.alonelaval.cornerstone.dao.repository.jpa;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author huawei
 * @create 2018-07-30
 **/
public class EntityInfoTest extends  ContextAwareTest {
    @Autowired
    EntityManager entityManager;

    @Test
    public void test() {
        System.out.println(entityManager.getMetamodel());
        System.out.println(entityManager.getMetamodel().getEntities());
        Set<EntityType<?>> entityTypes = entityManager.getMetamodel().getEntities();
        List<String> classes = entityTypes.stream().map(EntityType::getName).sorted().collect(Collectors.toList());


        Map<String,EntityType>  entityMap  = new HashMap();

        entityTypes.forEach(entityType ->
        {
            entityMap.put(entityType.getName(),entityType);
        });

        StringBuilder builder = new StringBuilder();
        classes.forEach(clazzName -> {


                EntityType entityType = entityMap.get(clazzName);
                builder.append(entityType.getJavaType()+"\n");

                Class<?> clazz = entityType.getJavaType();

                Set<Attribute<?, ?>> attributes  = (Set<Attribute<?, ?>>) entityType.getAttributes();
                for (Attribute<?, ?> attribute : attributes) {
                    try {
                        Field field = clazz.getDeclaredField(attribute.getName());
                        if(field != null) {
                            String name= attribute.getName();
                            name = "get"+ attribute.getName().substring(0,1).toUpperCase() + attribute.getName().substring(1,name.length());
                            Method method = clazz.getMethod(name);
                            Column column = method.getAnnotation(Column.class);
                            if(column != null){
                                String atype = attribute.getJavaType().toString();
                                builder.append("@Column(name = \""+column.name()+"\")"+"\n");
    //                            System.out.println("@Column(name = \""+column.name()+"\")");
                                builder.append("private "+atype.substring(atype.lastIndexOf(".")+1,atype.length())+" " +attribute.getName()+";\n");
    //                            System.out.println("private "+atype.substring(atype.lastIndexOf(".")+1,atype.length())+" " +attribute.getName());
                            }
                        }
                    } catch (Exception e) {

                    }

                }

        });
        try {
            FileUtils.writeStringToFile(new File("/Users/hua/workspace/ycz/cornerstone/dao/repository/src/test/java/com.alonelaval.cornerstone.dao/repository/jpa/txt.txt"),builder.toString(),Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
