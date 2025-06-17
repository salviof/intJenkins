/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restClickup.implementacao;

import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreJenkinsTestes;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import jakarta.json.JsonObject;
import java.util.Optional;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestClickupEspacoListarTest {

    public IntegracaoRestClickupEspacoListarTest() {
    }

    public String getCodigoPrimeiroEspaco() {
        String time = new IntegracaoRestClickupTimeListarTest().getCodigoPrimeiroTime();
        ItfRespostaWebServiceSimples resposta = FabIntRestJenkinsJobs.ESPACO_LISTAR
                .getAcao(time).getResposta();
        System.out.println(resposta.getRespostaTexto());
        JsonObject json = resposta.getRespostaComoObjetoJson();
        System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(json));
        return json.getJsonArray("spaces").getJsonObject(0).getString("id");
    }

    public String getCodigoEspacoModelo() {
        String time = new IntegracaoRestClickupTimeListarTest().getCodigoPrimeiroTime();
        ItfRespostaWebServiceSimples resposta = FabIntRestJenkinsJobs.ESPACO_LISTAR
                .getAcao(time).getResposta();
        System.out.println(resposta.getRespostaTexto());
        JsonObject json = resposta.getRespostaComoObjetoJson();
        System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(json));
        Optional<JsonObject> modeloEspaco = json.getJsonArray("spaces").stream().map(spc -> spc.asJsonObject())
                .filter(spcJson -> spcJson.getString("name").equals("MODELOS")).findFirst();
        return modeloEspaco.get().getString("id");

    }

    @Test
    public void testeListaTEams() {
        SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

        System.out.println(getCodigoPrimeiroEspaco());

    }

}
