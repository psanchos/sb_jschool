package ru.sbrf.jschool.reflection;

/**
 *  Интерфейс бирдера для формирования строк по шаблону
 */
public interface ITemplateBuilder {

    /**
     * Формирует текст замещая в шаблоне плейсхолдеры значениями из соответсвующих полей data-класса
     * @param templateData data класс с замещающим текстои
     * @return сформированный текст
     */
    String build(Object templateData);
}
