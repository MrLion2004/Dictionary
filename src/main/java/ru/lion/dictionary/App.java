package ru.lion.dictionary;

import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;

import ru.lion.javafx.UI;

public class App {

  private static final Logger log = Logger.getLogger(App.class);

  public void run() {
    Dictionary dictionary;
    try {
      dictionary = new DictionaryImpl();
    } catch (IOException e) {
      System.out.println("Ошибка: " + e.getMessage());
      return;
    }
    System.out.println("Загружено  " + dictionary.size() + "  основных слов " + "Английского языка");
    String input = "";
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("Введите слово: ");
      input = scanner.nextLine().trim().toLowerCase();
      if (input.equals("q") || input.equals("exit")) {
        break;
      }
      System.out.println("Вы ввели: " + input);
      log.debug("Вы ввели: " + input);
      // 2
      String output = dictionary.translate(input);
      if (output == null) {
        System.out.println("Слово не найдено!");
        log.error("Слово не найдено!");
      } else {
        System.out.println("Перевод: " + output);
        log.debug("Перевод: " + output);
      }
      System.out.println("---");
    }
    scanner.close();
  }

  public static void main(String... args) throws IOException {
    log.info("MAIN");
    new App().run();
    javafx.application.Application.launch(UI.class, args);
  }

}
