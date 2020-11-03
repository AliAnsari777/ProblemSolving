package Skillz;

import java.util.HashMap;
import java.util.Map;

/**
 * Fix the following code so the the map.get() call
 * retrieves the expected value.
 * Do not change the main method.
 */
public class StudentTest {
    public static final class Student {
        public Student( String name ) {
            this.name = name;
        }
        private String name;

        @Override
        public boolean equals(Object object){
            if(object == this)
                return true;

            if(!(object instanceof Student))
                return false;

            Student stu = (Student) object;
            return stu.name.equals(this.name);
        }

        @Override
        public int hashCode(){
            return name.hashCode();
        }
    }

    public static void main(final String[] args ) {
        Map<Student, String> map = new HashMap<>();
        map.put( new Student( "john"), "present" );
        System.out.println( map.get( new Student( "john" ) ) );
    }
}
