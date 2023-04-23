package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("968f9124-0556-4d56-88bc-48fc80d7706e")
public class Membresia {
    @objid ("dcf76d8c-0fde-42e7-b4c9-dc2a6041315f")
    Rango rango = Rango.Sin_rango;

    @objid ("178f85de-dfcf-4441-9571-803205f01770")
    int puntos = 0; //puntos para descontar por descuentos

    @objid ("b26571fe-f9f8-4ab7-8826-ddad0d73c365")
    int puntosTotales = 0; // puntos que sirven para determinar el rango
    
    public Membresia() {
    }
    
    public Membresia(Rango rango, int puntos, int puntosTotales) {
    	this.rango = rango;
    	this.puntos = puntos;
    	this.puntosTotales = puntosTotales;
    }

    public void addPunto(int value) {
    	this.puntos += value;
    	this.puntosTotales += value;
    	if (puntosTotales >= 10 && puntosTotales < 25) {
    		rango = Rango.Bronce;
    	}
    	else if (puntosTotales >= 25 && puntosTotales < 50) {
    		rango = Rango.Plata;
    	}
    	
    	else if (puntosTotales >= 50) {
    		rango = Rango.Oro;
    	}
    }
    
    public void removePunto(int value) {
    	this.puntos -= value;
    }
    
    public int getPunto() {
    	return this.puntos;
    }
    
    public int getPuntoTotal() {
    	return this.puntosTotales;
    }

	public Rango getRango() {
		return rango;
	}
}
