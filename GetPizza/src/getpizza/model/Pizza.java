package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("7ede2093-d9fb-4857-a0f5-77008361800b")
public class Pizza extends Producto {
    @objid ("04aa9ee6-f871-46de-9c12-f91000140890")
    private Masa masa;

    @objid ("20ab9dd5-194e-48ef-ac01-54fbd9d50b5b")
    private String tamanyo;

    @objid ("2bbaedec-6613-4efa-ae10-2040b2430c25")
    private Base base;

    @objid ("f02949ab-20b8-4400-bd1d-c2e92fe64e18")
    public String ingredientesAdded;

    @objid ("0b6ecb3b-a0b3-42e0-9490-a2a6dfd6ae2f")
    public String ingredientesRemoved;

    @objid ("5dabd3d7-e3ba-48ec-bf37-60f71cca1ac3")
    Masa getMasa() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.masa;
    }

    @objid ("563cf7e8-6780-492f-8d57-4f2cabc7f7e2")
    void setMasa(Masa value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.masa = value;
    }

    @objid ("7fad91a2-fbdb-4785-9bc1-e3aa4f6a2c47")
    String getTamanyo() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.tamanyo;
    }

    @objid ("78e91a70-e315-42a2-893f-5ee5e793a9a1")
    void setTamanyo(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.tamanyo = value;
    }

    @objid ("0867711e-c312-4a6f-b1de-f2cb81dd668b")
    public Base getBase() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.base;
    }

    @objid ("620d8e50-17de-4f1f-b508-b2c830eb67da")
    void setBase(Base value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.base = value;
    }

    @objid ("0617a026-af42-4f06-aec9-7191d964bcfd")
    public void addIngrediente() {
    }

    @objid ("ff506ca9-a2f5-4678-9ce5-c46d80081a4d")
    public void removeIngrediente() {
    }

}
