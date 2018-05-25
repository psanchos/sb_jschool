# sb_jschool

## Рефлексия ДЗ

  1. Реализовать интерфейс GetterCounter который считает кол-во геттеров в переданном классе
 ````
 /**
 * Интерфейс счетчика геттеров в классе
 */
public interface GetterCounter {
     /**
      * Возвращает колличество геттеров в переданном класс
      * @param clazz класс в котором необходимо посчитать геттеры
      * @return возвращает количество найденных геттеров 
      */
    int calcGetterCount(Class<?> clazz);
}
````
  2. Создать аннотацию @Skip и реализовать ее обработку таким образом что,
  если метод помечен этой аннотацией он не учитывается в подсчете
  
  3. Реализовать для созданного класса кэширующий прокси который бы сохранял результат вычесления в память 
  и при последующих вызовах возращал результат их кэша