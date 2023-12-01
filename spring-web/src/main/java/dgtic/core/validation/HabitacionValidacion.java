package dgtic.core.validation;


import dgtic.core.model.entity.HabitacionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class HabitacionValidacion implements Validator {
    @Autowired
    private MessageSource messageSource;
    @Override
    public boolean supports(Class<?> clazz) {

        return HabitacionEntity.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        HabitacionEntity habitacionEntity=(HabitacionEntity) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"precio",
                "Validar.habitacion.precio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre",
                "NoEspacioNoVacio.habitacion.nombre");

    }
}
