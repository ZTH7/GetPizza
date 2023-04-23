package getpizza.model;

import java.time.LocalDate;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("665d8a0f-c73e-4933-aed0-f2f7541b4398")
public class DescuentoPorDia extends Descuento {
	
	public DescuentoPorDia() {
		this.porcentaje = LocalDate.now().getDayOfWeek().getValue() == 7 ? 0.15 : 0;
	}
	
}
