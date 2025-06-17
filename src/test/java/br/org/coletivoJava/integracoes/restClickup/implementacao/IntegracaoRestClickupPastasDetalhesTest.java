/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restClickup.implementacao;

import com.super_bits.Super_Bits.intClickup.regras_de_negocio_e_controller.FabIntRestClickupPastas;
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
public class IntegracaoRestClickupPastasDetalhesTest {

    public IntegracaoRestClickupPastasDetalhesTest() {
    }

    /**
     * Test of gerarUrlRequisicao method, of class
     * IntegracaoRestClickupPastasDetalhes.
     */
    @Test
    public void testGerarUrlRequisicao() {

        //90131420628
        SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfRespostaWebServiceSimples resp = FabIntRestClickupPastas.PASTAS_DETALHES.getAcao("90131420628").getResposta();
        JsonObject respJson = resp.getRespostaComoObjetoJson();
        System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(respJson));
    }

}
