package getpizza.model;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("214a8828-9881-416b-be6c-576eeb3c618c")
public class Cliente {
    @objid ("9a29129c-4ce7-488a-a365-8b53e394d1bd")
    private String id;

    @objid ("2e917b6d-e0e5-4f1f-aebc-2e1dde62012c")
    private String nombreCompleto;

    @objid ("cd84b812-4c47-47e6-a467-3b0ed19b7934")
    protected List direccion;

    @objid ("bf743f3a-7b25-4d07-a19c-510853c97417")
    private String correo;

    @objid ("cf62a4a0-de14-4603-a673-54fdc32c68ac")
    public String password;

    @objid ("45f1ca06-601f-4fd6-9b5d-47a591a75e5d")
    public String telefono;

    @objid ("ba205d83-959a-4812-b16d-7695a2fd404e")
    public List codigosUsados;

    @objid ("f6293778-a65b-4f9c-9c9a-6f8eb96bb60e")
    public Membresia membresia;

    @objid ("707524e3-d751-45a7-8a61-79a20fd4fcb0")
    public List<Codigo> codigo = new ArrayList<Codigo> ();

    @objid ("a2ae45fd-4184-43bd-807f-6b74f126be9f")
    String getId() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.id;
    }

    @objid ("de5765be-a33f-4e7d-a760-fd85959367c1")
    void setId(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.id = value;
    }

    @objid ("a1e72852-de4f-4c6a-8675-1d679a4168af")
    String getNombreCompleto() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nombreCompleto;
    }

    @objid ("0bf237ed-6d9b-4b14-ba50-298b08432d9b")
    void setNombreCompleto(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nombreCompleto = value;
    }

    @objid ("84a4a702-fc96-4c52-982c-916cf7013863")
    List getDireccion() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.direccion;
    }

    @objid ("0280ee83-76d4-487a-87d7-72ce37a57d0e")
    void setDireccion(List value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.direccion = value;
    }

    @objid ("79e3c272-5b28-457c-aa12-925a4334201b")
    String getCorreo() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.correo;
    }

    @objid ("275de415-ce5c-4796-81a8-3eacf359bdba")
    void setCorreo(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.correo = value;
    }

    @objid ("c5145b16-aa5f-4cfd-8a71-cb4c26eac9a3")
    public void cambiarDatos() {
    }

}
