package app.mihailov.application.chat.service.data.annotation;

/**
 * Created by Дмитрий
 * Date: 22.10.2015.
 */
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
