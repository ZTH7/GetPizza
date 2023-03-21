package getpizza.model;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("5c65e4d9-c176-45c4-83af-c595dcef07b8")
public class PizzaPersonalizada extends Pizza {
    @objid ("38221687-fb29-46b4-a342-5182a99111fc")
    public List<Ingrediente> ingrediente = new ArrayList<Ingrediente> ();

}
