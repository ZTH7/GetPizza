package getpizza.model;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("1d75fc77-55b9-4a19-9100-2802959c9e67")
public class Producto {
    @objid ("f1dc602d-21df-4f4c-8373-c968fff942e8")
    protected String nombre;

    @objid ("9690dcca-6f5e-4211-8748-b6152c61d17b")
    protected float precio;

    @objid ("63e1741f-def7-49ba-9def-c87767780b88")
    public Carrito carrito;

    @objid ("b2baab49-f22e-4857-8136-b8cec2fe35c8")
    public List<MenuPredefinido> menuPredefinido = new ArrayList<MenuPredefinido> ();

    @objid ("2f886500-0e45-4b7d-b9b7-bf93ed6ba507")
    public String getNombre() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nombre;
    }

    @objid ("896067bd-0e60-4b5b-9e74-9032de321e39")
    void setNombre(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nombre = value;
    }

    @objid ("15816c97-0f1d-47de-aa30-d0675c353d03")
    public float getPrecio() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.precio;
    }

    @objid ("52c803c5-31b8-4901-a0f4-5f8f8387f7b5")
    void setPrecio(float value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.precio = value;
    }

}
