/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restClickup.implementacao;

import com.super_bits.Super_Bits.intClickup.regras_de_negocio_e_controller.FabIntRestClickupListas;
import com.super_bits.Super_Bits.mktMauticIntegracao.configAppp.ConfiguradorCoreJenkinsTestes;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.oauth.InfoTokenOauth2;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenDeAcessoExterno;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.ChamadaHttpSimples;
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
public class GestaoTokenRestClickupTest {

    public GestaoTokenRestClickupTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFluxoIntegro() {

        SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        GestaoTokenRestClickup gestao = (GestaoTokenRestClickup) FabIntRestClickupListas.LISTAS_DA_PASTA.getGestaoToken();
        String urlObterCodigoSoliciacao = gestao.getUrlObterCodigoSolicitacao();
        System.out.println(gestao.isConexaoDiretaViaToken());
        System.out.println(gestao.getToken());

        ItfRespostaWebServiceSimples resposta = FabIntRestClickupListas.LISTAS_DA_PASTA.getAcao("MODELOS").getResposta();
        System.out.println(resposta.getRespostaTexto());
        assertTrue(resposta.isSucesso());

    }

    /**
     * Test of validarToken method, of class GestaoTokenRestClickup.
     */
    public void testValidarToken() {
        System.out.println("validarToken");
        GestaoTokenRestClickup instance = null;
        boolean expResult = false;
        boolean result = instance.validarToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of extrairToken method, of class GestaoTokenRestClickup.
     */
    public void testExtrairToken() {
        System.out.println("extrairToken");
        JsonObject jsonObject = null;
        GestaoTokenRestClickup instance = null;
        ItfTokenDeAcessoExterno expResult = null;
        ItfTokenDeAcessoExterno result = instance.extrairToken(jsonObject);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gerarNovoToken method, of class GestaoTokenRestClickup.
     */
    public void testGerarNovoToken() {
        System.out.println("gerarNovoToken");
        GestaoTokenRestClickup instance = null;
        InfoTokenOauth2 expResult = null;
        InfoTokenOauth2 result = instance.gerarNovoToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gerarChamadaTokenObterChaveAcesso method, of class
     * GestaoTokenRestClickup.
     */
    public void testGerarChamadaTokenObterChaveAcesso() {
        System.out.println("gerarChamadaTokenObterChaveAcesso");
        GestaoTokenRestClickup instance = null;
        ChamadaHttpSimples expResult = null;
        ChamadaHttpSimples result = instance.gerarChamadaTokenObterChaveAcesso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gerarUrlAutenticaoObterCodigoSolicitacaoToken method, of class
     * GestaoTokenRestClickup.
     */
    public void testGerarUrlAutenticaoObterCodigoSolicitacaoToken() {
        System.out.println("gerarUrlAutenticaoObterCodigoSolicitacaoToken");
        GestaoTokenRestClickup instance = null;
        String expResult = "";
        String result = instance.gerarUrlAutenticaoObterCodigoSolicitacaoToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gerarUrlRetornoSucessoGeracaoTokenDeAcesso method, of class
     * GestaoTokenRestClickup.
     */
    public void testGerarUrlRetornoSucessoGeracaoTokenDeAcesso() {
        System.out.println("gerarUrlRetornoSucessoGeracaoTokenDeAcesso");
        GestaoTokenRestClickup instance = null;
        String expResult = "";
        String result = instance.gerarUrlRetornoSucessoGeracaoTokenDeAcesso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
