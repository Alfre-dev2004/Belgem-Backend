package com.belgem.backend.application.dto.cliente;

/**
 * DTO de salida (Response) que representa la información que se devuelve
 * al frontend cuando se consulta, crea, actualiza o lista un cliente.
 *
 * Este DTO se utiliza **exclusivamente para responder peticiones**,
 * NO para recibir datos del cliente.
 *
 * Importante:
 * - Contiene todos los campos que el frontend necesita visualizar.
 * - No tiene anotaciones, lógica ni validaciones.
 * - Los valores son asignados en el mapper desde el modelo de dominio.
 */
public class ClienteResponse {
    private Long idCliente;
    private String nombre;
    private String nif;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String telefono;
    private String email;
    private String tipoCliente;
    private String zona;
    private String representante;
    private String observaciones;


    /**
     * Constructor completo utilizado por el mapper para transformar
     * un objeto de dominio en un DTO de respuesta.
     */
    public ClienteResponse(Long idCliente, String nombre, String nif, String direccion, String ciudad,
                           String codigoPostal, String telefono, String email, String tipoCliente,
                           String zona, String representante, String observaciones) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
        this.email = email;
        this.tipoCliente = tipoCliente;
        this.zona = zona;
        this.representante = representante;
        this.observaciones = observaciones;
    }

    // Estos valores son leídos por el controlador para enviarlos en la respuesta HTTP.
    public Long getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public String getNif() { return nif; }
    public String getDireccion() { return direccion; }
    public String getCiudad() { return ciudad; }
    public String getCodigoPostal() { return codigoPostal; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getTipoCliente() { return tipoCliente; }
    public String getZona() { return zona; }
    public String getRepresentante() { return representante; }
    public String getObservaciones() { return observaciones; }
}
