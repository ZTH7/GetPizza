package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("799e1ae9-018a-4717-8abd-879e2e5c9ce0")
public class Ingrediente {
    @objid ("1bb0d061-d9bf-4fe2-8dc4-126d353df0d1")
    private boolean disponible;

    @objid ("521b37b1-44b7-461f-b874-bbd80c72aac9")
    private String nombre;

    @objid ("d3d3f564-d262-4745-9e0f-c7fa3dd9b9b8")
    private String id;

    @objid ("9461ba12-c776-4674-93d0-0764ab8faa6a")
    boolean isDisponible() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.disponible;
    }

    @objid ("0d83f46f-0fc0-427f-a402-011f5a446d07")
    void setDisponible(boolean value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.disponible = value;
    }

    @objid ("3f3fdac8-1a21-421a-a108-3a8f6354f267")
    String getNombre() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nombre;
    }

    @objid ("37f3ac80-03d9-43e6-8da1-cf706fe54280")
    void setNombre(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nombre = value;
    }

    @objid ("91ac5167-4b7e-420a-8bc7-39429a320f13")
    String getId() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.id;
    }

    @objid ("a6a46a80-8bb0-462f-8b3c-8b4366b9ba0d")
    void setId(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.id = value;
    }

}
