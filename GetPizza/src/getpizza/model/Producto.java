package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid("1d75fc77-55b9-4a19-9100-2802959c9e67")
public abstract class Producto {
	@objid("f1dc602d-21df-4f4c-8373-c968fff942e8")
	protected String nombre;

	@objid("9690dcca-6f5e-4211-8748-b6152c61d17b")
	protected float precio;

	@objid("ddec5e11-3f9f-454f-a3ce-f198c1bda735")
	protected String desc;

	@objid("600dd12d-eb00-43fe-87b1-227ff33aee42")
	protected String id;

	public Producto() {
	}

	public Producto(String id, String nombre, String desc, float precio) {
		setId(id);
		setNombre(nombre);
		setDesc(desc);
		setPrecio(precio);
	}

	@objid("2f886500-0e45-4b7d-b9b7-bf93ed6ba507")
	public String getNombre() {
		// Automatically generated method. Please delete this comment before entering
		// specific code.
		return this.nombre;
	}

	@objid("896067bd-0e60-4b5b-9e74-9032de321e39")
	void setNombre(String value) {
		// Automatically generated method. Please delete this comment before entering
		// specific code.
		this.nombre = value;
	}

	@objid("15816c97-0f1d-47de-aa30-d0675c353d03")
	public float getPrecio() {
		// Automatically generated method. Please delete this comment before entering
		// specific code.
		return this.precio;
	}

	@objid("52c803c5-31b8-4901-a0f4-5f8f8387f7b5")
	void setPrecio(float value) {
		// Automatically generated method. Please delete this comment before entering
		// specific code.
		this.precio = value;
	}

	@objid("23c00978-0da2-4659-bf48-452e1045f220")
	public String getId() {
		// Automatically generated method. Please delete this comment before entering
		// specific code.
		return this.id;
	}

	@objid("5ab450e5-ef9d-4093-8767-40c82d158d1b")
	void setId(String value) {
		// Automatically generated method. Please delete this comment before entering
		// specific code.
		this.id = value;
	}

	@objid("98060370-b472-4592-b472-2361bfecb7f0")
	public String getDesc() {
		// Automatically generated method. Please delete this comment before entering
		// specific code.
		return this.desc;
	}

	@objid("64ec1618-f382-4232-97b9-aaae9974dc72")
	void setDesc(String value) {
		// Automatically generated method. Please delete this comment before entering
		// specific code.
		this.desc = value;
	}

}
