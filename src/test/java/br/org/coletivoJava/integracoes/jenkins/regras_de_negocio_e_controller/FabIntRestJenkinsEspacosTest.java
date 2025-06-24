/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller;

import com.super_bits.Super_Bits.jenkins.configAppp.ConfiguradorCoreJenkinsTestes;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.junit.Assert;
import org.junit.Test;
import testes.testesSupers.TestesApiRest;

/**
 *
 * @author salvio
 */
public class FabIntRestJenkinsEspacosTest extends TestesApiRest {

    /**
     * Test of values method, of class FabIntRestClickupListas.
     */
    @Test
    public void testValues() {
        try {
            SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
            gerarCodigosChamadasEndpoint(FabIntRestJenkinsJobs.class);
            System.out.println("modulo: "+SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPatchArquivoConfig());
        } catch (Throwable t) {
            Assert.fail("Deu merda");
        }

    }

}
