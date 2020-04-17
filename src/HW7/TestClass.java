package HW7;

public class TestClass {
    @AfterSuite
    public void aftee(){
        System.out.println("Выполняется метод aftee c анатацией @AfterSuite");
    }
    @BeforeSuite
    public void before(){
        System.out.println("Выполняется метод before c анатацией @BeforeSuite");
    }
    @Test(priority = 1)
    public void test1(){
        System.out.println("Выполняется метод test1 c анатацией @Test приоритет 1");
    }
    @Test(priority = 3)
    public void test2(){
        System.out.println("Выполняется метод test2 c анатацией @Test приоритет 3");
    }
    @Test(priority = 5)
    public void test3(){
        System.out.println("Выполняется метод test3 c анатацией @Test приоритет 5");
    }
    @Test(priority = 7)
    public void test4(){
        System.out.println("Выполняется метод test4 c анатацией @Test приоритет 7");
    }
    @Test(priority = 9)
    public void test5(){
        System.out.println("Выполняется метод test5 c анатацией @Test приоритет 9");
    }
    @Test(priority = 2)
    public void test6(){
        System.out.println("Выполняется метод test6 c анатацией @Test приоритет 2");
    }
    @Test(priority = 4)
    public void test7(){
        System.out.println("Выполняется метод test7 c анатацией @Test приоритет 4");
    }
    @Test(priority = 6)
    public void test8(){
        System.out.println("Выполняется метод test8 c анатацией @Test приоритет 6");
    }
}
