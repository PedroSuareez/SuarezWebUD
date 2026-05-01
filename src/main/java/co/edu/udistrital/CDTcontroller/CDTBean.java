package co.edu.udistrital.CDTcontroller;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import co.edu.udistrital.CDTmodel.*;

@Named("cdtBean")
@ViewScoped
public class CDTBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private CDT dto = new CDT();
    private ArrayList<CDT> listaCdt;

    public CDTBean() {
        super();
    }

    public String registrar() {
        dto.setId(CDTDAO.lista_C.size() + 1L); // ID auto-incremental
        dto.calcular();
        CDTDAO.lista_C.add(dto);
        listaCdt = CDTDAO.lista_C;
        dto = new CDT(); // Limpio el formulario
        return "/CDT/resultadoscdt?faces-redirect=true";
    }

    public void cargarLista() {
        listaCdt = CDTDAO.lista_C;
    }

    public CDT getDto() { return dto; }
    public void setDto(CDT dto) { this.dto = dto; }

    public ArrayList<CDT> getListaCdt() { return listaCdt; }
    public void setListaCdt(ArrayList<CDT> listaCdt) { this.listaCdt = listaCdt; }
}