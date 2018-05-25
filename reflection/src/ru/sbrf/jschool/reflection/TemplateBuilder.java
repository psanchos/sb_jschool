package ru.sbrf.jschool.reflection;

import ru.sbrf.jschool.reflection.annotaion.Prefix;
import ru.sbrf.jschool.reflection.annotaion.Upper;
import ru.sbrf.jschool.reflection.exception.DocumentBuildException;

import java.lang.reflect.Field;

/**
 * Позволяет формировать сообщение по шаблону
 */
public class TemplateBuilder implements ITemplateBuilder {
    private String template;

    public static void main(String[] args) {
        ITemplateBuilder temlateBuilder = new TemplateBuilder("Привет {name} {lastName}");
        System.out.println(
                temlateBuilder.build(
                        new TemplateData("Вася","Пупкин")));


    }

    public TemplateBuilder(String temlate) {
        this.template = temlate;
    }

    @Override
    public String build(Object templateData){

        String[] strings = this.template.split(" ");

        String result=template;
        for (String s:strings){
            String placeholder = null;

            int first = s.indexOf("{");
            int last = s.indexOf("}");
            if(first==-1|| last==-1)continue;
            placeholder = s.substring(first+1,last);

            String value = getValue(placeholder,templateData);
            result = result.replace(s,value);
        }

        return result;
    }

    //Получаем значение из класса с данными
    private String getValue(String placeholder, Object data){
        Class dataClass= data.getClass();
        try {

            //Получаем поле по плейсхолдеру
            Field field = dataClass.getDeclaredField(placeholder);
            field.setAccessible(true);
            String value = (String) field.get(data);

            //Проверяем что поле аннотировано @Upper
            if(field.isAnnotationPresent(Upper.class)){
                value = value.toUpperCase();
            }

            //Проверяем что поле аннотировано @Prefix
            Prefix prefixAnnotation = field.getAnnotation(Prefix.class);
            if(prefixAnnotation !=null){
                value  = prefixAnnotation.value()+value+prefixAnnotation.postfix();
            }

            return value;
        } catch (NoSuchFieldException|IllegalAccessException e) {
            throw  new DocumentBuildException();
        }
    }
}
