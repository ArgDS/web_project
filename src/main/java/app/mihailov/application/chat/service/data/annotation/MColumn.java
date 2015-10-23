package app.mihailov.application.chat.service.data.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Дмитрий
 * Date: 22.10.2015.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MColumn {
    enum TypeData{
        String,
        Int,
        Boolean,
        Date,
        DateTime
    }
    String name();
    TypeData type() default TypeData.String;
}
