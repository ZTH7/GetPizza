package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("5c65e4d9-c176-45c4-83af-c595dcef07b8")
public class PizzaPersonalizada extends Pizza {
	// Se añaden los ingredientes mediante el patron decorador
	
    @objid ("3ab42c43-8850-49ea-a4a4-880e5db18d95")
    public void addIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    @objid ("609c03d0-1f58-4de4-b27e-b909112d742b")
    public void removeIngrediente(Ingrediente ingrediente) {
        ingredientes.remove(ingrediente);
    }
}
