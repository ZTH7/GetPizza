package getpizza.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("214a8828-9881-416b-be6c-576eeb3c618c")
public class Cliente {
    @objid ("9a29129c-4ce7-488a-a365-8b53e394d1bd")
    private String id;

    private String nombre;
    
    @objid ("2e917b6d-e0e5-4f1f-aebc-2e1dde62012c")
    private String apellido;

    @objid ("bf743f3a-7b25-4d07-a19c-510853c97417")
    private String correo;

    @objid ("45f1ca06-601f-4fd6-9b5d-47a591a75e5d")
    public String telefono;

    @objid ("cd84b812-4c47-47e6-a467-3b0ed19b7934")
    protected String direccion;

    public String ciudad;

    public String provincia;

    public String codigoPostal;

    @objid ("cf62a4a0-de14-4603-a673-54fdc32c68ac")
    public String password;

    @objid ("f6293778-a65b-4f9c-9c9a-6f8eb96bb60e")
    public Membresia membresia;

    @objid ("707524e3-d751-45a7-8a61-79a20fd4fcb0")
    public List<Codigo> codigo;

    @objid ("ba205d83-959a-4812-b16d-7695a2fd404e")
    public List<Codigo> codigosUsados;

    public List<Pedido> historia;
    
    public Cliente(Map<String, String> datos){
    	this.id = datos.get("Usuario");
		this.nombre = datos.get("Nombre");
		this.apellido = datos.get("Apellido");
		this.correo = datos.get("Correo");
		this.telefono = datos.get("Tel");
		this.direccion = datos.get("Direccion");
		this.ciudad = datos.get("Ciudad");
		this.provincia = datos.get("Provincia");
		this.codigoPostal = datos.get("CodigoPostal");
		this.password = datos.get("Password");
		this.membresia = new Membresia();
		this.codigo = new ArrayList<> ();
		this.codigosUsados = new ArrayList<> ();
		this.historia = new ArrayList<>();
    }

    @objid ("a2ae45fd-4184-43bd-807f-6b74f126be9f")
    public String getId() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.id;
    }

    @objid ("de5765be-a33f-4e7d-a760-fd85959367c1")
    public void setId(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.id = value;
    }

    @objid ("a1e72852-de4f-4c6a-8675-1d679a4168af")
    public String getNombre() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nombre;
    }

    @objid ("0bf237ed-6d9b-4b14-ba50-298b08432d9b")
    public void setNombre(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nombre = value;
    }

    public String getApellido() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.apellido;
    }

    public void setApellido(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.apellido = value;
    }

    @objid ("84a4a702-fc96-4c52-982c-916cf7013863")
    public String getDireccion() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.direccion;
    }

    @objid ("0280ee83-76d4-487a-87d7-72ce37a57d0e")
    public void setDireccion(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.direccion = value;
    }

    @objid ("79e3c272-5b28-457c-aa12-925a4334201b")
    public String getCorreo() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.correo;
    }

    @objid ("275de415-ce5c-4796-81a8-3eacf359bdba")
    public void setCorreo(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.correo = value;
    }

    @objid ("c5145b16-aa5f-4cfd-8a71-cb4c26eac9a3")
    public void cambiarDatos() {
    }
    
    public Membresia getMembresia() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.membresia;
    }
    
    public String getCodigoPostal() {
    	return this.codigoPostal;
    }
    
    public void setCodigoPostal(String CodigoPostal) {
    	this.codigoPostal = CodigoPostal;
    }
    
    public String getTelefono() {
    	return this.telefono;
    }
    
    public void setTelefono(String telefono) {
    	this.telefono = telefono;
    }
    
    public String getCiudad() {
    	return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
    	this.ciudad = telefono;
    }
    
    public String getProvincia() {
    	return this.provincia;
    }
    
    public void setProvincia(String provincia) {
    	this.provincia = provincia;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public void addHistoria(Pedido pedido) {
    	this.historia.add(pedido);
    }
    
    public List<Pedido> getHistoria() {
    	return this.historia;
    }

}
