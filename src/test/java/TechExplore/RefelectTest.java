package TechExplore;

import java.lang.annotation.*;

/**
 * Created by DELL on 12/3/2015.
 */
public class RefelectTest {
    public static void main(String[] args) {
        Class aClass = TheClass.class;
        Annotation[] annotations = aClass.getAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }
    }
}

//Annotation defn
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

@interface MyAnnotation {
    public String name() default  "TEST";
    public String value();
}

@MyAnnotation( value = "Hello World")
class TheClass {
}