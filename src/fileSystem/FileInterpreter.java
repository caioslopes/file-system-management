package fileSystem;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FileInterpreter<T>{

    public Collection<T> interpret(String content, T dto) throws ClassNotFoundException {
        Class<?> clazz = (Class<?>) dto.getClass();

        Collection<T> dataset = new ArrayList<>();

        int attributes = clazz.getDeclaredFields().length;

        //Criar interface bolada slc vey mds cade

        String lines[] = content.split("\\n");
        for (String line : lines) {
            String tuples[] = line.split(";");
            if(tuples.length == 5){
                int i = 0;
                for(Field f : clazz.getDeclaredFields()){

//                    Class att = Class.forName(f.getType().getName());
                    var att = tuples[i];
                    i++;
                }
//                dataset.add();
            }

//            System.out.println(line);
        }

//        for(Field f : clazz.getDeclaredFields()){
//            System.out.println(f.getName()+", ");
//            System.out.println(f.getType()+", ");
//        }

        return null;
    }

}
