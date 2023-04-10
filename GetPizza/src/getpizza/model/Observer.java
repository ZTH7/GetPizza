package getpizza.model;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e5354d22-a112-4ab1-85d7-ea4bafda9922")
public interface Observer {
    @objid ("42fa4e52-e324-4b4c-88a5-18cfc66f2efa")
    public void onProductAdded(List<Producto> products, Producto p);

    @objid ("12f7aaae-eeb3-4328-9a91-96e038fd55dd")
    public void onProductRemoved(List<Producto> products, Producto p);
    
    public void onCodeUsed(Codigo codigo);
    
    public void onOrderSended(Pedido pedido);

}
