package fileSystem;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FileInterpreter{

    public Collection<String[]> interpret(String content, Class<?> dto) {
        int attributes = dto.getDeclaredFields().length;

        Collection<String[]> result = new ArrayList<>();

        String[] lines = content.split("\\n");
        for (String line : lines) {
            String[] tuples = line.split(";");
            if(tuples.length == attributes){
                result.add(tuples);
            }
        }

        return result;
    }

}
