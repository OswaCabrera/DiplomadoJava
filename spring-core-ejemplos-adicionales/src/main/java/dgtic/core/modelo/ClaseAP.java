package dgtic.core.modelo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ClaseAP {
    @Autowired
    private ClaseBP claseBP;

    @PostConstruct
    public void init(){
        claseBP.setClaseAP(this);
    }

    public ClaseBP getClaseBP() {
        return claseBP;
    }

    public void setClaseBP(ClaseBP claseBP) {
        this.claseBP = claseBP;
    }
}