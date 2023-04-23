package getpizza.model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("968f9124-0556-4d56-88bc-48fc80d7706e")
public class Membresia {
    @objid ("dcf76d8c-0fde-42e7-b4c9-dc2a6041315f")
    public Rango rango = Rango.Sin_rango;

    @objid ("178f85de-dfcf-4441-9571-803205f01770")
    public int puntos = 0;

    @objid ("b26571fe-f9f8-4ab7-8826-ddad0d73c365")
    public int puntosTotales = 0;
    
    public Membresia() {
    }
    
    public Membresia(Rango rango, int puntos, int puntosTotales) {
    	this.rango = rango;
    	this.puntos = puntos;
    	this.puntosTotales = puntosTotales;
    }

    @objid ("e04b9609-153c-4fa7-bb4a-06a9e974239a")
    public void verDescuentos() {
    }

    @objid ("50989220-d630-40e9-93bd-aca75b55e272")
    public void actualizarMembresia() {
    }

    public void addPunto(int value) {
    	this.puntos += value;
    	this.puntosTotales += value;
    }
    
    public int getPunto() {
    	return this.puntos;
    }
    
    public int getPuntoTotal() {
    	return this.puntosTotales;
    }
}
