package me.whiteship;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<?> bookClass  = Class.forName("me.whiteship.Book");
        //인스턴스를 만드는 가장 권장하는 방법 생성자를 쓰는 것
//        Constructor<?> constructor = bookClass.getConstructor(null);
        Constructor<?> constructor = bookClass.getConstructor(String.class); //생성자가 파라미터를 받을 때
        Book book = (Book)constructor.newInstance("myBook");
//        System.out.println(book);
//        System.out.println(book);

// 필드에 있는 값을 가져오고 싶을 때
//        Field a = Book.class.getDeclaredField("A");
//       // 값을 꺼낼 수 있는데 필드가 특정 인스턴스에 해당하는 필드일 때 인스턴스를 넘겨줄 수 있다.
//       // 하지만 A는 static 필드이므로 넘겨줄게 없다.
//        System.out.println(a.get(null));
//       // 값을 세팅할 때는 set을 쓰면됨 이것도 특정한 인스턴스에 해당하는 필드일 때 인스턴스를 넘겨줄 수 잇다.
//        a.set(null,"BBBBB");
//        System.out.println(a.get(null));
//

//        Field b = Book.class.getDeclaredField("B");
//       // 특정 인스턴스에 속해 있으므로 아까처럼 null로 가져올 수 없다.
//        b.setAccessible(true); // B는 private 이므로 setAccessible 을 true로 하면 가져올 수 있다.
//        System.out.println(b.get(book));
//        b.set(book, "BBBBBBBB");
//        System.out.println(b.get(book));

        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);// private method 이므로
        c.invoke(book);

        // public 이고 파라미터를 받는 메소드라면        프리미티어 타입이랑 레퍼런스 타입 구분함....
        Method d = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) d.invoke(book,1,2);
        System.out.println(invoke);
    }
}
