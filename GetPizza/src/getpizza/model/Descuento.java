package getpizza.model;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("fa47f8bd-5976-4373-9497-2e75cd511167")
public class Descuento {
    @objid ("716fa650-f002-4895-90a5-8e47b09c3c68")
    protected float precioDescontado;

    @objid ("81004d1f-1529-42d4-98f5-4812e98ae2f9")
    public List<Pedido> pedido = new ArrayList<Pedido> ();

    @objid ("b16bcfff-ca20-474f-a1ea-253f139a66d7")
    float getPrecioDescontado() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.precioDescontado;
    }

    @objid ("31d36cba-9c59-4e81-8c58-8e173320d1f6")
    void setPrecioDescontado(float value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.precioDescontado = value;
    }

    @objid ("47c6a004-9e30-4dea-8cb3-f6b757e7fa3c")
    public void aplicarDescuento() {
    }

}
