/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restClickup.implementacao;

import com.super_bits.Super_Bits.intClickup.regras_de_negocio_e_controller.FabIntRestClickupListas;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salvio
 */
public class IntegracaoRestClickupListaEditarTest {

    public IntegracaoRestClickupListaEditarTest() {
    }

    @Test
    public void testSomeMethod() {

        String codigoDoTime = new IntegracaoRestClickupTimeListarTest().getCodigoPrimeiroTime();
        ItfRespostaWebServiceSimples reposta = FabIntRestClickupListas.LISTAS_DA_PASTA.getAcao("").getResposta();

// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
