/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.ItfFabricaIntegracaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.FabTipoConexaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.InfoConsumoRestService;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.FabTipoAutenticacaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.InfoConfigRestClientIntegracao;

import com.super_bits.modulosSB.SBCore.modulos.ManipulaArquivo.importacao.FabTipoArquivoImportacao;

/**
 *
 * @author SalvioF
 */
@InfoConfigRestClientIntegracao(configuracao = FabConfigModuloJenkins.class,
        enderecosDocumentacao = "https://ci.jenkins.io/api/",
        nomeIntegracao = "jenkins",
        tipoAutenticacao = FabTipoAutenticacaoRest.CHAVE_ACESSO_METODOLOGIA_PROPRIA
)
public enum FabIntRestJenkinsJobs implements ItfFabricaIntegracaoRest {

    @InfoConsumoRestService(getPachServico = "/api/v2/team/{0}/space",
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            tipoConexao = FabTipoConexaoRest.GET,
            parametrosGet = "team_id",
            urlDocumentacao = "https://ci.jenkins.io/api/",
            adicionarAutenticacaoBearer
            = true
    )
    CRIAR,
    @InfoConsumoRestService(getPachServico = "/api/v2/team/{0}/space",
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            tipoConexao = FabTipoConexaoRest.GET,
            parametrosGet = "team_id",
            urlDocumentacao = "https://ci.jenkins.io/api/",
            adicionarAutenticacaoBearer
            = true
    )
    COPIAR,
    @InfoConsumoRestService(getPachServico = "/api/v2/team/{0}/space",
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            tipoConexao = FabTipoConexaoRest.GET,
            parametrosGet = "team_id",
            urlDocumentacao = "https://ci.jenkins.io/api/",
            adicionarAutenticacaoBearer
            = true
    )
    EXECUTAR,
}
