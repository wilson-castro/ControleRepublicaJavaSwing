package src.models;

import com.google.gson.Gson;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modal {

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public Object[] getValues() {
        Class<?> c = this.getClass();
        Field[] fields = c.getDeclaredFields();
        Object[] values = new Object[fields.length - 1];
        int count = 0;
        for (Field field : fields) {
            try {
                if (count < fields.length - 1) { // Não leva o input string
                    values[count] = field.get(this);
                }
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Despesa.class.getName()).log(Level.SEVERE, null, ex);
            }
            count++;
        }
        return values;
    }
}
