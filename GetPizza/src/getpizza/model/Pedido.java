package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("22caf2ec-18a6-492f-ab03-b86a68461bdd")
public class Pedido {
    @objid ("69f89118-5600-4bbd-b8a7-9cfc1ac17d92")
    private String id;
    
    private String direccion;

    @objid ("cc50cf45-6335-400b-9705-9105d0e3c34c")
    protected float precio;

    @objid ("37792c25-1483-4a3c-8128-dc231b1845ae")
    protected float precioFinal;

    @objid ("c8262a58-8fab-45c8-aad9-684a913dfc5e")
    private boolean conDatafono;

    @objid ("5bee4103-5d16-4837-88c7-4eb2299625dc")
    public String getId() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.id;
    }

    @objid ("b52096fb-8ad5-46dd-ab9d-4a5faf4277c3")
    public void setId(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.id = value;
    }
    
    public String getDireccion() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.direccion;
    }

    @objid ("b52096fb-8ad5-46dd-ab9d-4a5faf4277c3")
    public void setDireccion(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.direccion = value;
    }

    @objid ("8a1be3e2-fa2f-4fa4-976c-4f31c9db1a62")
    public float getPrecio() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return Math.round(precio * 100) / 100f;
    }

    @objid ("8b974c82-45c8-477c-b260-7581de511bc2")
    public void setPrecio(float value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.precio = value;
    }

    @objid ("24298007-c813-49c6-ae8d-39fb24903d77")
    public float getPrecioFinal() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.precioFinal;
    }

    @objid ("4472e75a-455f-45b3-9e56-3c074b47fa98")
    public void setPrecioFinal(float value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.precioFinal = value;
    }

    @objid ("e9af912f-6327-45c7-a257-09f69145ae95")
    public boolean isConDatafono() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.conDatafono;
    }

    @objid ("d789d494-2dab-4fab-92bb-469b55b4be39")
    public void setConDatafono(boolean value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.conDatafono = value;
    }

    @objid ("3ee1bc3e-7cd1-4f4a-810b-395ab3ac69d7")
    public void escogerDescuento() {
    }

    @objid ("ff5ddb3c-fd8b-4e16-a2a5-31a5e42fd210")
    public void escogerDatosFacturacion() {
    }

    @objid ("c49708c5-db10-4dae-934d-720a908ef1e3")
    public void generarFactura() {
    }

    @objid ("67d48332-e23d-4c0a-bf0a-affed297af33")
    public void finalizarPedido() {
    }

}
