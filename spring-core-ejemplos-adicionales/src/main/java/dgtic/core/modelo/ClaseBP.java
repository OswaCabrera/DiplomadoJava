package dgtic.core.modelo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ClaseBP {

    private ClaseAP claseAP;

    public ClaseAP getClaseAP() {
        return claseAP;
    }

    public void setClaseAP(ClaseAP claseAP) {
        this.claseAP = claseAP;
    }
}
