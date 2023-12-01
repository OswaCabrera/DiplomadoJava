package dgtic.core.converter;

import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.util.StringUtils;

public class FloatConvertir extends CustomNumberEditor {
    public FloatConvertir(Class<? extends Number> numberClass) throws IllegalArgumentException {
        super(numberClass, true);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("*************");
        if(!StringUtils.hasText(text)){
            setValue(0.0);
        }else{
            super.setAsText(text.trim());
        }
    }
}
