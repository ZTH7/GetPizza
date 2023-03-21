package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("95f99c76-705c-46ef-8680-cb164fdf96ce")
public class Carrito {
    @objid ("a7b1b666-f599-4e4c-8fc4-030e8760041b")
    protected float precioTotal;

    @objid ("df1cd22a-c0a1-45b4-ab25-37188c118939")
    public Pedido pedido;

    @objid ("d2e07c97-9261-4d4c-9257-0138bce63c0c")
    float getPrecioTotal() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.precioTotal;
    }

    @objid ("82f61a7b-8ffc-4fe5-b0ae-f0f9f5a14b0a")
    void setPrecioTotal(float value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.precioTotal = value;
    }

    @objid ("26e5bd71-a07c-4198-bbf6-6692a1a93b38")
    public void addProducto() {
    }

    @objid ("ce0cef6f-0ca6-4891-9dbe-911fe8949405")
    public void removeProducto() {
    }

    @objid ("dbeef1fd-a234-44ef-990b-74441e71730c")
    public void addMenuPredef() {
    }

    @objid ("3f43091d-7cf3-4def-bc19-d7a6e41a781e")
    public void removeMenuPredef() {
    }

    @objid ("a443cc58-d442-4d73-950f-8b7e56eba091")
    public void visualizarCarrito() {
    }

}
