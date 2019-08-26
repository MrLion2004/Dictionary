package ru.lion.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class DictionaryImpl implements Dictionary {

  private static Vector<String> en = new Vector<String>();
  private static Vector<String> ru = new Vector<String>();

  public DictionaryImpl() throws IOException {
    /*
    InputStream resourceStream =
      DictionaryImpl.class.getResourceAsStream("/en-ru.txt");
    if (resourceStream == null) {
      throw new IOException("Resource not found");
    }
    */

    File dataFile = new File("./en-ru.txt");
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(dataFile));
      /*
      reader = new BufferedReader(
        new InputStreamReader(resourceStream));
      */
      int index;
      String line;
      String delimiter = " -- ";
      while ((line = reader.readLine()) != null) {
        // "zone -- зона" => "zone", "зона"
        index = line.indexOf(delimiter);
        if (index != -1) {
          en.add(line.substring(0, index));
          ru.add(line.substring(index + delimiter.length()));
        }
      }
    } finally {
      if (reader != null) {
        reader.close();
      }
    }
  }

  public int size() {
    return en.size();
  }

  /**
   * Поиск строки в словаре
   * @param a Искомая строка
   * @return Перевод или null, если не найдено
   */
  public String translate(String a) {
    int index = en.indexOf(a);
    if (index == -1) {
      return null;
    }
    return ru.get(index);
  }
}
