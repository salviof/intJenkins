/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.integracoes.restClickup.implementacao;

import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import com.super_bits.Super_Bits.intClickup.regras_de_negocio_e_controller.FabIntRestClickupListas;
import com.super_bits.Super_Bits.intClickup.regras_de_negocio_e_controller.FabIntRestClickupPastas;
import com.super_bits.Super_Bits.intClickup.regras_de_negocio_e_controller.FabIntRestClickupTarefa;
import com.super_bits.Super_Bits.intClickup.regras_de_negocio_e_controller.FabIntRestClickupTimes;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreJenkinsTestes;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreStringBuscaTrecho;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.transmissao_recepcao_rest_client.ItfAcaoApiRest;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class TesteIntegracaoClickup {

    private final String NOME_TIME = "Casanova Digital";
    private final String NOMEESPACO_MODELOS = "MODELOS";

    private final String NOMEESPACO_PROJETOS = "PROJETOS EM EXECUÇÃO";
    private final String CODIGO_TIPO_SERVICO = "61";
    private final String TIPO_GRUPO_TAREFA_TEMPLATE = "Ponto de partida";
    private final String DOCUMENTO_CLIENTE = "06321298670";
    private final String CODIGO_ORDEM_DE_SERVICO = "1";

    @Test
    public void testeCompleto() {
        SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        String codigoTime = getCodigoTime(NOME_TIME);
        String codigoEspacoModelos = getCodigoEspacoModelos(codigoTime);
        String codigoListaModeloDoSErvico = getcodigoModeloDoServico(codigoEspacoModelos);
        List<String> codigosListaAtividaddesDoSerivico = getListaAtividas(codigoListaModeloDoSErvico);
        System.out.println("Tarefas encontradas");
        for (String codigo : codigosListaAtividaddesDoSerivico) {
            System.out.println(codigo);
        }

        String codigoTemplate = getTarefaTemplate(codigoListaModeloDoSErvico);
        String codigoEspacoExecucao = getCodigoEspacoProjetos(codigoTime);

        String codigoPastaCliente = getCodigoPastaDocumento(codigoEspacoExecucao);

        String codigoListaProjeto = getCodigoListaProjetoExecucao(codigoPastaCliente, codigoListaModeloDoSErvico);

        String codigoTarefaExecucao = getCodigoTarefasEmExecucao(codigoListaProjeto, codigoTemplate);
        System.out.println(codigoTarefaExecucao);
        //String codigo
    }

    public boolean apagar(String pCodigoTarefaExecucao) {
        Assert.fail("Erro");
        return false;
    }

    public String getCodigoPastaDocumento(String pCodigoSpaco) {
        ItfRespostaWebServiceSimples respPastas = FabIntRestClickupPastas.PASTAS_LISTAR.getAcao(pCodigoSpaco).getResposta();
        JsonObject respPastasJson = respPastas.getRespostaComoObjetoJson();
        JsonArray pastas = respPastasJson.getJsonArray("folders");
        for (JsonValue valuePasta : pastas) {
            JsonObject pasta = valuePasta.asJsonObject();
            System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(pasta));
        }

        Optional<String> psta = pastas.stream().map(pst -> pst.asJsonObject())
                .filter(nome -> nome.getString("name").contains("[" + DOCUMENTO_CLIENTE + "]"))
                .map(json -> json.getString("id"))
                .findFirst();

        if (psta.isPresent()) {
            return psta.get();
        } else {
            ItfRespostaWebServiceSimples respCriacaoPasta = FabIntRestClickupPastas.PASTAS_CRIAR.getAcao(pCodigoSpaco, "Salvio Furbino Testes" + "[" + DOCUMENTO_CLIENTE + "]").getResposta();
            Assert.assertTrue(respPastas.isSucesso());
            return respCriacaoPasta.getRespostaComoObjetoJson().getString("id");
        }

    }

    public String getCodigoPastaCLiente() {
        Assert.fail("Erro");
        return null;
    }

    public String removerProjeto() {
        Assert.fail("Erro");
        return null;
    }

    public String getCodigoListaProjetoExecucao(String pCodigoPastaCliente, String pModelo) {

        ItfRespostaWebServiceSimples resp = FabIntRestClickupPastas.PASTAS_DETALHES.getAcao(pCodigoPastaCliente).getResposta();
        JsonObject respPastaJson = resp.getRespostaComoObjetoJson();

        Optional<JsonObject> listaServicosEmExecucao = respPastaJson.getJsonArray("lists").stream()
                .map(spc -> spc.asJsonObject())
                .filter(spcJson -> spcJson.getString("name")
                .contains("[" + CODIGO_ORDEM_DE_SERVICO + "]")).findFirst();

        if (listaServicosEmExecucao.isPresent()) {
            return listaServicosEmExecucao.get().getString("id");
        } else {

            String nomeModelo = FabIntRestClickupListas.LISTA_VER.getAcao(pModelo).getResposta().getRespostaComoObjetoJson().getString("name");
            nomeModelo = nomeModelo.substring(0, nomeModelo.indexOf("["));
            ItfRespostaWebServiceSimples respCriacaoLisaTarefasProjeto = FabIntRestClickupListas.LISTA_CRIAR_NA_PASTA
                    .getAcao(pCodigoPastaCliente,
                            nomeModelo + " [" + CODIGO_ORDEM_DE_SERVICO + "]",
                            "Ações programadas para " + nomeModelo).getResposta();
            if (!respCriacaoLisaTarefasProjeto.isSucesso()) {
                respCriacaoLisaTarefasProjeto.dispararMensagens();
            }
            Assert.assertTrue("A lista não foi criada", respCriacaoLisaTarefasProjeto.isSucesso());
            String idLista = respCriacaoLisaTarefasProjeto.getRespostaComoObjetoJson().getString("id");
            return idLista;
        }

    }

    public String getCodigoTarefasEmExecucao(String pCodigoListaExecuxao, String pCodigoTarefaModelo) {

        ItfRespostaWebServiceSimples respListaDetalhes = FabIntRestClickupTarefa.TAREFA_LISTAR.getAcao(pCodigoListaExecuxao).getResposta();
        JsonObject listaDetalhes = respListaDetalhes.getRespostaComoObjetoJson();

        ItfRespostaWebServiceSimples respostaTarefaDetalhe = FabIntRestClickupTarefa.TAREFA_VER.getAcao(pCodigoTarefaModelo).getResposta();
        JsonObject tarefaRespJson = respostaTarefaDetalhe.getRespostaComoObjetoJson();
        String nomeTarefa = tarefaRespJson.getString("name");
        List<String> slugTarefas = UtilSBCoreStringBuscaTrecho.getPartesEntreColchete(nomeTarefa);
        String sluTipoTarefa = slugTarefas.get(0);

        if (listaDetalhes.containsKey("tasks")) {
            JsonArray tarefasListaExecucao = listaDetalhes.getJsonArray("tasks");
            Optional<JsonObject> pesquisaTarefaDoModelo = tarefasListaExecucao.stream().
                    map(v -> v.asJsonObject()).
                    filter(trf -> trf.getString("name").contains("[" + sluTipoTarefa + "]")).findFirst();
            if (pesquisaTarefaDoModelo.isPresent()) {
                return pesquisaTarefaDoModelo.get().getString("id");
            }
        }

        boolean fim = false;
        boolean encontrou = false;
        String CodigoTime = getCodigoTime(NOME_TIME);
        int pagina = 0;
        final List<String> idsEncontrados = new ArrayList<>();
        while (!fim && !encontrou) {

            ItfRespostaWebServiceSimples respostaModelo = FabIntRestClickupTarefa.TAREFA_MODELO_LISTAR.getAcao(CodigoTime, Integer.valueOf(pagina)).getResposta();
            JsonObject respModelJson = respostaModelo.getRespostaComoObjetoJson();
            JsonArray modelosJson = respModelJson.getJsonArray("templates");

            fim = modelosJson.stream().map(mod -> mod.asJsonObject().getString("id"))
                    .filter(codigoModelo -> idsEncontrados.contains(codigoModelo))
                    .findFirst().isPresent();
            if (!fim) {
                Optional<JsonObject> pesquisaJsonModelo = modelosJson.stream().map(mod -> mod.asJsonObject())
                        .filter(itemjsonModelo -> (itemjsonModelo.getString("name").toUpperCase().contains("[" + TIPO_GRUPO_TAREFA_TEMPLATE.toUpperCase() + "]") && itemjsonModelo.getString("name").contains("[" + CODIGO_TIPO_SERVICO + "]")))
                        .findFirst();
                encontrou = pesquisaJsonModelo.isPresent();
                if (encontrou) {
                    JsonObject jsonModelo = pesquisaJsonModelo.get();
                    String codigoTemplateTarefa = jsonModelo.getString("id");
                    ItfRespostaWebServiceSimples respostaCricaoModelo = FabIntRestClickupTarefa.TAREFA_CRIAR_VIA_MODELO.getAcao(pCodigoListaExecuxao, codigoTemplateTarefa, "[" + sluTipoTarefa + "]").getResposta();
                    if (respostaCricaoModelo.isSucesso()) {
                        JsonObject jsonModeloCRiado = respostaCricaoModelo.getRespostaComoObjetoJson();
                        String tarefaCriada = jsonModeloCRiado.getString("id");
                        return tarefaCriada;
                    }
                }

            }
            if (fim && !encontrou) {
                throw new UnsupportedOperationException("modelo não encontrado" + TIPO_GRUPO_TAREFA_TEMPLATE + "-" + CODIGO_TIPO_SERVICO + "NÃO ENCONTRADO");

            }
            modelosJson.stream().map(json -> json.asJsonObject().getString("id")).forEach(idsEncontrados::add);
            pagina++;
        }

        String codigoTarefa = tarefaRespJson.getString("id");
        System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(tarefaRespJson));

        ItfRespostaWebServiceSimples resp = FabIntRestClickupTarefa.TAREFA_CRIAR_VIA_MODELO.getAcao(pCodigoListaExecuxao, pCodigoTarefaModelo, "Nova Tarefa").getResposta();
        return resp.getRespostaComoObjetoJson().getString("id");
    }

    public List<String> criarTaregasExecucao(String p) {
        Assert.fail("Erro");
        return null;
    }

    public String getCodigoTime(String pNometIME) {
        ItfRespostaWebServiceSimples resposta = FabIntRestClickupTimes.TIME_LISTAR.getAcao().getResposta();
        System.out.println(resposta.getRespostaTexto());
        JsonObject json = resposta.getRespostaComoObjetoJson();
        System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(json));

        Optional<JsonObject> jsonNome = json.getJsonArray("teams").stream().map(time -> time.asJsonObject())
                .filter(esp -> esp.getString("name").equals(pNometIME))
                .findFirst();
        JsonObject time = jsonNome.get();
        String id = time.getString("id");

        return id;
    }

    public String getCodigoEspacoModelos(String pCodigoTime) {
        ItfAcaoApiRest acap = FabIntRestJenkinsJobs.ESPACO_LISTAR.getAcao(pCodigoTime);
        Assert.assertTrue("Falha obtendo espacos do time" + pCodigoTime + acap.getResposta().getRespostaTexto(),
                acap.getResposta().isSucesso());
        JsonObject jsonEspacos = acap.getResposta().getRespostaComoObjetoJson();
        Optional<JsonObject> modeloEspaco = jsonEspacos.getJsonArray("spaces").stream().map(spc -> spc.asJsonObject())
                .filter(spcJson -> spcJson.getString("name").equals(NOMEESPACO_MODELOS)).findFirst();
        JsonObject espacoJson = modeloEspaco.get();
        String codigo = espacoJson.getString("id");
        return codigo;
    }

    public String getCodigoEspacoProjetos(String pCodigoTime) {
        ItfAcaoApiRest acap = FabIntRestJenkinsJobs.ESPACO_LISTAR.getAcao(pCodigoTime);
        Assert.assertTrue("Falha obtendo espacos do time" + pCodigoTime + acap.getResposta().getRespostaTexto(),
                acap.getResposta().isSucesso());
        JsonObject jsonEspacos = acap.getResposta().getRespostaComoObjetoJson();
        Optional<JsonObject> modeloEspaco = jsonEspacos.getJsonArray("spaces").stream().map(spc -> spc.asJsonObject())
                .filter(spcJson -> spcJson.getString("name").equals(NOMEESPACO_PROJETOS)).findFirst();
        JsonObject espacoJson = modeloEspaco.get();
        String codigo = espacoJson.getString("id");
        return codigo;
    }

    public String getcodigoModeloDoServico(String pCodigoEspaco) {
        ItfRespostaWebServiceSimples resp = FabIntRestClickupListas.LISTAS_DO_ESPACO.getAcao(pCodigoEspaco).getResposta();
        JsonObject listas = resp.getRespostaComoObjetoJson();

        Optional<JsonObject> modeloEspaco = listas.getJsonArray("lists").stream()
                .map(spc -> spc.asJsonObject())
                .filter(spcJson -> spcJson.getString("name")
                .contains("[" + CODIGO_TIPO_SERVICO + "]")).findFirst();
        Assert.assertTrue("Erro procurando  listas do", modeloEspaco.isPresent());

        if (modeloEspaco.isPresent()) {
            JsonObject espacoJson = modeloEspaco.get();

            String codigo = espacoJson.getString("id");
            return codigo;
        } else {
            Assert.fail("Arquio");
        }
        return null;
    }

    public List<String> getListaAtividas(String pCodigoModelo) {
        ItfRespostaWebServiceSimples resp = FabIntRestClickupTarefa.TAREFA_LISTAR.getAcao(pCodigoModelo).getResposta();
        JsonObject listas = resp.getRespostaComoObjetoJson();
        JsonArray listasJson = listas.getJsonArray("tasks");
        List<String> modelos = new ArrayList<>();
        for (JsonValue valor : listasJson) {
            JsonObject json = valor.asJsonObject();
            System.out.println(json.getString("name"));
            modelos.add(json.getString("id"));
        }

        return modelos;
    }

    public String getTarefaTemplate(String pLista) {
        ItfRespostaWebServiceSimples resp = FabIntRestClickupTarefa.TAREFA_LISTAR.getAcao(pLista).getResposta();
        JsonObject listas = resp.getRespostaComoObjetoJson();
        JsonArray listasJson = listas.getJsonArray("tasks");

        Optional<String> tarefas = listasJson.stream().map(tsk -> tsk.asJsonObject())
                .filter(d -> d.getString("name").contains("[" + TIPO_GRUPO_TAREFA_TEMPLATE + "]"))
                .map(json -> json.getString("id"))
                .findFirst();
        Assert.assertTrue(NOMEESPACO_PROJETOS + " não foi encontrada na lista " + pLista, tarefas.isPresent());
        return tarefas.get();
        //    return modelos;
    }

    private String getcodigoPastaCliente() {
        return null;
    }

}
