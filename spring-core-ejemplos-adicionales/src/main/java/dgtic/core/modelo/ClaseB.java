package dgtic.core.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ClaseB {


    @Autowired
    private ClaseA claseA;

    public ClaseA getClaseA() {
        return claseA;
    }

    public void setClaseA(ClaseA claseA) {
        this.claseA = claseA;
    }
}
