package cn.itcast.reflect;

import cn.itcast.domain.Person;
import cn.itcast.domain.Student;
import sun.util.resources.cldr.xog.CalendarData_xog_UG;

public class ReflectDemo1Copy {


    /**
        获取Class对象的方式：
            1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
            2. 类名.class：通过类名的属性class获取
            3. 对象.getClass()：getClass()方法在Object类中定义着。

     */
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("cn.itcast.domain.Person");
        System.out.println(aClass);
        Class<Person> aClass2 = Person.class;
        System.out.println(aClass2);
        Person person = new Person();
        System.out.println(person.getClass());
    }
}
