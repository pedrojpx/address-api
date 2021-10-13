package com.patterns.addressapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Attributes generatia via jsonschema2pojo.org
 * keeping original attribute names for the sake of simplicity of implementation
 *
 * @see <a href="https://www.jsonschema2pojo.org">jsonchema2pojo</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 * @author pedrojpx feat. falvojr
 */
@Entity
@Getter @Setter
public class Address {

    @Id
    @NotEmpty
    @Size(min = 8, max = 9)
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
