package day2;

interface Selenium {
  void get();
  void anotherMethod();
}


public class SeleniumXDriver implements Selenium {
    public void get() {
        System.out.println("Implementation of get() method");
    }

    public void anotherMethod() {
        System.out.println("Implementation of anotherMethod() method");
    }
}

class Example {
    void test() {
        Selenium driver = new SeleniumXDriver();
    }
}