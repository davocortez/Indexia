/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BEAN;

/**
 *
 * @author David
 */
public class ProveedorBean {
    private String idProvedor;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;
    private String estado;
    private String idTipoProveedor;

    public String getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(String idProvedor) {
        this.idProvedor = idProvedor;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdTipoProveedor() {
        return idTipoProveedor;
    }

    public void setIdTipoProveedor(String idTipoProveedor) {
        this.idTipoProveedor = idTipoProveedor;
    }

  }
