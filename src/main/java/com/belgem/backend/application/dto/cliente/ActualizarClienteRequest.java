package com.belgem.backend.application.dto.cliente;

/**
 * DTO utilizado para recibir los datos necesarios para actualizar un cliente.
 *
 * Este objeto representa la **estructura del JSON** que llega desde el frontend
 * cuando se realiza una petición PUT /clientes/{id}.
 *
 * Importante:
 *  - No contiene anotaciones ni lógica.
 *  - No incluye el campo "nif" ya que, según el diseño del módulo,
 *    el NIF **no se actualiza**.
 */
public class ActualizarClienteRequest {

    private String nombre;
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
     * Constructor que inicializa los valores recibidos desde el JSON.
     * El controlador usará este DTO para convertirlo al modelo de dominio.
     */
    public ActualizarClienteRequest(String nombre, String direccion, String ciudad, String codigoPostal,
                                    String telefono, String email, String tipoCliente, String zona,
                                    String representante, String observaciones) {
        this.nombre = nombre;
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

    // Se utilizan en el mapper para construir el modelo de dominio.
    public String getNombre() { return nombre; }
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
