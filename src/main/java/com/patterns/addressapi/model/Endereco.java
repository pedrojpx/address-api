package com.patterns.addressapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Atributos gerados pelo site jsonchem2pojo.org
 *
 * @see <a href="https://www.jsonschema2pojo.org">jsonchema2pojo</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 * @author pedrojpx feat. falvojr
 */
@Entity
@Getter @Setter
public class Endereco {

    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

}
