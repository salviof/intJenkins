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

import static br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabConfigModuloJenkins.NOME_INTEGRACAO;

/**
 * @author SalvioF
 */
@InfoConfigRestClientIntegracao(configuracao = FabConfigModuloJenkins.class,
        enderecosDocumentacao = "https://ci.jenkins.io/api/",
        nomeIntegracao = NOME_INTEGRACAO,
        tipoAutenticacao = FabTipoAutenticacaoRest.CHAVE_ACESSO_METODOLOGIA_PROPRIA
)
public enum FabIntRestJenkinsJobs implements ItfFabricaIntegracaoRest {

    @InfoConsumoRestService(getPachServico = "/createItem?name={name}",
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            tipoConexao = FabTipoConexaoRest.POST,
            parametrosPost = {"name"},
            urlDocumentacao = "https://projetos.casanovadigital.com.br/api/",
            adicionarAutenticacaoBearer = true)
    CRIAR,
    @InfoConsumoRestService(getPachServico = "/createItem?name={nameJobCopy}&mode=copy&from={nameJobBase}",
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            tipoConexao = FabTipoConexaoRest.POST,
            parametrosGet = {"nameJobCopy", "nameJobBase"},
            urlDocumentacao = "https://projetos.casanovadigital.com.br/api/",
            adicionarAutenticacaoBearer = true)
    COPIAR,
    @InfoConsumoRestService(getPachServico = "/job/{jobName}/build",
            tipoInformacaoRecebida = FabTipoArquivoImportacao.JSON,
            tipoConexao = FabTipoConexaoRest.GET,
            parametrosGet = "jobName",
            urlDocumentacao = "https://projetos.casanovadigital.com.br/api/",
            adicionarAutenticacaoBearer = true)
    EXECUTAR,
}
