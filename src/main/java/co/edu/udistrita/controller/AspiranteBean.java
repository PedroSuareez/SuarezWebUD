// Autor: Pedro Suarez
package co.edu.udistrita.controller;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.udistrital.model.*;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("asp")
@SessionScoped
public class AspiranteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Aspirante dto = new Aspirante();
    private ArrayList<Aspirante> listaAs = AspiranteDAO.lista_A;
    private ArrayList<ProgAcad> listaPa = ProgAcadDAO.lista_P;

    public AspiranteBean() {
        ProgAcadDAO.cargaDatos();
    }

    public Aspirante getDto() { return dto; }
    public void setDto(Aspirante dto) { this.dto = dto; }
    public ArrayList<Aspirante> getListaAs() { return listaAs; }
    public void setListaAs(ArrayList<Aspirante> listaAs) { this.listaAs = listaAs; }
    public ArrayList<ProgAcad> getListaPa() { return listaPa; }
    public void setListaPa(ArrayList<ProgAcad> listaPa) { this.listaPa = listaPa; }

    public String registrar() {
        dto.setFecha_reg(LocalDate.now());
        // Busca el programa por código en la lista
        for (ProgAcad p : listaPa) {
            if (p.getCod() == dto.getPro_acad().getCod()) {
                dto.setPro_acad(p);
                break;
            }
        }
        listaAs.add(dto);
        dto = new Aspirante(); // limpia el formulario
        return null;
    }
}