package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("ab60c0e0-1b19-475d-9ae0-2ab0e1d6448a")
public class Bebida extends Producto {
    @objid ("afa197c3-6966-47bd-b7c1-3d0b4b3b2a6d")
    private Tamanyo tamanyo;

    @objid ("88a25535-e17a-4250-ba03-9da627626150")
    public Tamanyo getTamanyo() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.tamanyo;
    }

    @objid ("fb45f0f7-7911-46b8-83e9-0017d77ee6e5")
    public void setTamanyo(Tamanyo value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.tamanyo = value;
    }

}
