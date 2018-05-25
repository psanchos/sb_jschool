package ru.sbrf.jschool.reflection;

import ru.sbrf.jschool.reflection.annotaion.Prefix;
import ru.sbrf.jschool.reflection.annotaion.Upper;

/**
 * Created by SBT-Pozdnyakov-AN on 24.05.2018.
 */
public class TemplateData {
    @Upper
    private String name;

    @Upper
    @Prefix(value = "MR_")
    private String lastName;

    public TemplateData(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }
}
