package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3f23fea3-2549-483e-9024-987df21a5333")
public class DescuentoPorMembresia extends Descuento {
	
	public DescuentoPorMembresia(Rango rango) {
		switch(rango) {
		case Sin_rango: 
			this.porcentaje = 0;
			break;
		case Bronce:
			this.porcentaje = 0.05;
			break;
		case Plata:
			this.porcentaje = 0.1;
			break;
		case Oro:
			this.porcentaje = 0.15;
			break;
		}
	}
}
