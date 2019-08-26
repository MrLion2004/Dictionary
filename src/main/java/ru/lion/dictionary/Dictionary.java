package ru.lion.dictionary;

public interface Dictionary {

  /**
   * Поиск строки в словаре
   * @param str Искомая строка
   * @return Перевод или null, если не найдено
   */
  String translate(String str);

  /**
   * Размер словаря
   * @return Количество слов в словаре
   */
  int size();

}
