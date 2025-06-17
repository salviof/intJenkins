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
public class IntegracaoRestClickupListasDaPastaTest {

    public IntegracaoRestClickupListasDaPastaTest() {
    }

    public String getCodigoPasta() {
        IntegracaoRestClickupEspacoListarTest integracaoEspacao = new IntegracaoRestClickupEspacoListarTest();
        String codigoEspacao = integracaoEspacao.getCodigoEspacoModelo();
        ItfRespostaWebServiceSimples resp = FabIntRestClickupPastas.PASTAS_LISTAR.getAcao(codigoEspacao).getResposta();
        JsonObject respObj = resp.getRespostaComoObjetoJson();
        System.out.println(UtilSBCoreJson.getTextoByJsonObjeect(respObj));
        return null;
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

        System.out.println(getCodigoPasta());
    }

}
