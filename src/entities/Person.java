package entities;

import java.time.LocalDate;

public class Person {
  public String name;
  public LocalDate birthdayDate;

  public Person(String name, LocalDate birthdayDate) {
    this.name = name;
    this.birthdayDate = birthdayDate;
  }

  void setName(String name) {
    this.name = name;
  }

  void setBirthdayDate(LocalDate birthdayDate) {
    this.birthdayDate = birthdayDate;
  }

  public String getName() {
    return this.name;
  }

  public LocalDate getBirthdayDate() {
    return this.birthdayDate;
  }
}
