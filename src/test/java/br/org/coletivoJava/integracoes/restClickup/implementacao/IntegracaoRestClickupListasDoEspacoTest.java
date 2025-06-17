/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restClickup.implementacao;

import com.super_bits.Super_Bits.intClickup.regras_de_negocio_e_controller.FabIntRestClickupListas;
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
public class IntegracaoRestClickupListasDoEspacoTest {

    public IntegracaoRestClickupListasDoEspacoTest() {
    }

    public String getListaTarefaByCodigo(String pCodigo) {
        IntegracaoRestClickupEspacoListarTest espaco = new IntegracaoRestClickupEspacoListarTest();
        String codigoEspaco = espaco.getCodigoEspacoModelo();
        ItfRespostaWebServiceSimples resp = FabIntRestClickupListas.LISTAS_DO_ESPACO.getAcao(codigoEspaco).getResposta();
        JsonObject respJson = resp.getRespostaComoObjetoJson();
        Optional<JsonObject> acao = respJson.getJsonArray("lists").stream().map(lst -> lst.asJsonObject())
                .filter(lstobj -> lstobj.getString("name").contains("[" + pCodigo + "]")).findFirst();
        return acao.get().getString("id");
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        IntegracaoRestClickupEspacoListarTest espaco = new IntegracaoRestClickupEspacoListarTest();
        String codigoEspaco = espaco.getCodigoEspacoModelo();
        ItfRespostaWebServiceSimples resp = FabIntRestClickupListas.LISTAS_DO_ESPACO.getAcao(codigoEspaco).getResposta();
        JsonObject respJson = resp.getRespostaComoObjetoJson();
        System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(respJson));
    }

}
