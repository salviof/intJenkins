/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restClickup.implementacao;

import com.super_bits.Super_Bits.intClickup.regras_de_negocio_e_controller.FabIntRestClickupTarefa;
import com.super_bits.Super_Bits.intClickup.regras_de_negocio_e_controller.FabIntRestClickupTimes;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreJenkinsTestes;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import jakarta.json.JsonObject;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salvio
 */
public class IntegracaoRestClickupTarefaModeloListarTest {

    public IntegracaoRestClickupTarefaModeloListarTest() {
    }

    /**
     * Test of gerarUrlRequisicao method, of class
     * IntegracaoRestClickupTarefaModeloListar.
     */
    @Test
    public void testGerarUrlRequisicao() {
        SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        String codigoTime = getCodigoTime();
        ItfRespostaWebServiceSimples resp = FabIntRestClickupTarefa.TAREFA_MODELO_LISTAR.getAcao(codigoTime, "0").getResposta();
        JsonObject retornoJson = resp.getRespostaComoObjetoJson();
        System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(retornoJson));
        System.out.println("eae?");
    }

    public String getCodigoTime() {
        ItfRespostaWebServiceSimples resposta = FabIntRestClickupTimes.TIME_LISTAR.getAcao().getResposta();
        System.out.println(resposta.getRespostaTexto());
        JsonObject json = resposta.getRespostaComoObjetoJson();
        System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(json));

        Optional<JsonObject> jsonNome = json.getJsonArray("teams").stream().map(time -> time.asJsonObject())
                .filter(esp -> esp.getString("name").equals("Casanova Digital"))
                .findFirst();
        JsonObject time = jsonNome.get();
        String id = time.getString("id");

        return id;
    }

}
