package com.belgem.backend.application.dto.cliente;

/**
 * DTO utilizado para recibir los datos necesarios para crear un nuevo cliente.
 *
 * Este objeto representa la estructura del JSON que llega desde el frontend
 * cuando se realiza una petición POST /clientes.
 *
 * Características:
 *  - Contiene exclusivamente los campos que el usuario puede enviar al crear un cliente.
 *  - No incluye anotaciones ni lógica adicional (cumple las reglas de DTO puro).
 *  - El ID del cliente no se recibe, ya que se genera automáticamente en la base de datos.
 */
public class CrearClienteRequest {

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
     * Constructor que recibe todos los campos proporcionados en el JSON.
     * El controlador utiliza este DTO para convertirlo al modelo de dominio.
     */
    public CrearClienteRequest(String nombre, String nif, String direccion, String ciudad, String codigoPostal,
                               String telefono, String email, String tipoCliente, String zona,
                               String representante, String observaciones) {
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

    // Son utilizados en el mapper para construir el modelo de dominio.
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
