package ru.sbrf.jschool.reflection.annotaion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by SBT-Pozdnyakov-AN on 24.05.2018.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Prefix {
    String value();
    String postfix() default ".";
}
