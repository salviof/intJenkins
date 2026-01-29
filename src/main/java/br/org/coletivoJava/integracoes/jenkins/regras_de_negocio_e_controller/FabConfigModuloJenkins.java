/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller;

import com.super_bits.modulosSB.SBCore.ConfigGeral.arquivosConfiguracao.ItfFabConfigModulo;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.tipoModulos.integracaoOauth.FabPropriedadeModuloIntegracaoOauth;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.tipoModulos.integracaoOauth.InfoPropriedadeConfigRestIntegracao;

/**
 *
 * @author SalvioF
 */
public enum FabConfigModuloJenkins implements ItfFabConfigModulo {
    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.URL_SERVIDOR_API)
    URL_SERVIDOR_JENKINS,
    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.SENHA)
    TOKEN_ACESSO_DIRETO,
    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.CHAVE_PRIVADA)
    CHAVE_ACESSO_SERVIDOR,
    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.SENHA)
    USUARIO_ADMIN;

    public static final String NOME_INTEGRACAO = "intJenkins";

    public String getValorPadrao() {
        switch (this) {
            case CHAVE_ACESSO_SERVIDOR:
            case URL_SERVIDOR_JENKINS:
            case TOKEN_ACESSO_DIRETO:
            case USUARIO_ADMIN:
                break;
            default:
                throw new AssertionError(this.name());
        }
        return "não definido";
    }

}
