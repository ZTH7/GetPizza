package getpizza.model;

import java.util.ArrayList;
import java.util.List;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("7ede2093-d9fb-4857-a0f5-77008361800b")
public class Pizza extends Producto {
	// Los datos de una pizza predefinada se obtienen de la base de datos
	
    @objid ("04aa9ee6-f871-46de-9c12-f91000140890")
    Masa masa;

    @objid ("20ab9dd5-194e-48ef-ac01-54fbd9d50b5b")
    Tamanyo tamanyo;

    @objid ("2bbaedec-6613-4efa-ae10-2040b2430c25")
    Base base;
    
    List<Ingrediente> ingredientes = new ArrayList<Ingrediente> ();
    
    public Pizza() {
    	super("p", "Pizza", "Pizzaaaa", (float) 10.99);
    	masa = Masa.Napolitana;
    	tamanyo = Tamanyo.Grande;
    	base = Base.Tomate;
    }

    @objid ("5dabd3d7-e3ba-48ec-bf37-60f71cca1ac3")
    public Masa getMasa() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.masa;
    }

    @objid ("563cf7e8-6780-492f-8d57-4f2cabc7f7e2")
    public void setMasa(Masa value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.masa = value;
    }

    @objid ("7fad91a2-fbdb-4785-9bc1-e3aa4f6a2c47")
    public Tamanyo getTamanyo() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.tamanyo;
    }

    @objid ("78e91a70-e315-42a2-893f-5ee5e793a9a1")
    public void setTamanyo(Tamanyo value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.tamanyo = value;
    }

    @objid ("0867711e-c312-4a6f-b1de-f2cb81dd668b")
    public Base getBase() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.base;
    }

    @objid ("620d8e50-17de-4f1f-b508-b2c830eb67da")
    public void setBase(Base value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.base = value;
    }

}
