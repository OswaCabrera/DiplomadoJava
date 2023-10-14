package dgtic.core.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ClaseA {

    private ClaseB claseB;


    public ClaseB getClaseB() {
        return claseB;
    }

    @Autowired
    public void setClaseB(@Lazy ClaseB claseB) {
        this.claseB = claseB;
    }
}
