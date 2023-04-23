package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("0c1fd22a-aa12-45e8-824f-dcb664cf24dd")
public class DescuentoPorPuntos extends Descuento {
	int puntos;
	
	public void setPuntos(int values) {
		this.puntos = values;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	@Override
	public void aplicarDescuento(float precio) {
    	precioDescontado = Math.round(puntos * 25) / 100f;
    	this.porcentaje = Math.round(precioDescontado / precio * 10) / 10.0;
    }
}
