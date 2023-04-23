package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d3bcee56-6d32-49d2-ba8f-241dfea19697")
public class DescuentoPorCodigo extends Descuento {
    @objid ("5735e221-0e24-4863-a075-2d8bf9b68520")
    public String codigo;

    @objid ("c22613ea-b189-439a-938e-2725dbe218ff")
    public void addToCodigosUsadosCliente() {
    }

    public void setCodigo(String codigo) {
    	this.codigo = codigo;
    }
}
