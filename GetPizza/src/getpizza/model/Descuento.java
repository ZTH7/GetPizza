package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("fa47f8bd-5976-4373-9497-2e75cd511167")
public class Descuento {
    @objid ("716fa650-f002-4895-90a5-8e47b09c3c68")
    protected double porcentaje = 0;
    protected double precioDescontado = 0;

    @objid ("b16bcfff-ca20-474f-a1ea-253f139a66d7")
    public double getPorcentaje() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.porcentaje;
    }

    @objid ("31d36cba-9c59-4e81-8c58-8e173320d1f6")
    void setPrecioDescontado(double value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.porcentaje = value;
    }

    @objid ("47c6a004-9e30-4dea-8cb3-f6b757e7fa3c")
    public void aplicarDescuento(float precio) {
    	precioDescontado = Math.round(porcentaje * precio * 100) / 100f;
    }
    
    public double getPrecioDescontado() {
    	return this.precioDescontado;
    }

}
