package com.utn.lab4.Tp4.TP4.Model;
import javax.persistence.*;

@Entity
@Table(name = "UserLogs")
public class UserLogs{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String navegador;
    private String sistemaOperativo;

    public UserLogs() {
        super();
    }

    public UserLogs(String nav, String sO ) {
        super();
        this.navegador = nav;
        this.sistemaOperativo = sO;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String toString() {
        return "UserLogs{" +
                "id=" + id +
                ", navegador='" + navegador + '\'' +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                '}';
    }
}