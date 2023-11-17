package dgtic.core.validation;

import dgtic.core.model.entity.HabitacionEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class HabitacionValidacion implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return HabitacionEntity.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        HabitacionEntity habitacion = (HabitacionEntity) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","NotBlank.habitacionEntity.nombre");

    }
}
