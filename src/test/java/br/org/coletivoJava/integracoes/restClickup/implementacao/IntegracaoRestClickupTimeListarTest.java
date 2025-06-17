/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restClickup.implementacao;

import com.super_bits.Super_Bits.intClickup.regras_de_negocio_e_controller.FabIntRestClickupTimes;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreJenkinsTestes;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import jakarta.json.JsonObject;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class IntegracaoRestClickupTimeListarTest {

    public IntegracaoRestClickupTimeListarTest() {
    }

    public String getCodigoPrimeiroTime() {
        ItfRespostaWebServiceSimples resposta = FabIntRestClickupTimes.TIME_LISTAR.getAcao().getResposta();
        System.out.println(resposta.getRespostaTexto());
        JsonObject json = resposta.getRespostaComoObjetoJson();
        System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(json));
        return json.getJsonArray("teams").getJsonObject(0).getString("id");
    }

    @Test
    public void testeListaTEams() {
        SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

        System.out.println(getCodigoPrimeiroTime());

    }

}
