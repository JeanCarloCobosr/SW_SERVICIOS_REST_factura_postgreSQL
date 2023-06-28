package com.cibertec.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @Column(name = "idFactura")
    private int idFactura;

    @Column(name = "fechaFactura")
    private Date fechaFactura;

    @Column(name = "flag")
    private int flag;

    @Column(name = "monto")
    private double monto;

    @Column(name = "numero")
    private String numero;

    @Column(name = "idEmpresa")
    private int idEmpresa;

    @Column(name = "idTipoMoneda")
    private int idTipoMoneda;


}