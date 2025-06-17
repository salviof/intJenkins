package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import com.super_bits.Super_Bits.jenkins.configAppp.ConfiguradorCoreJenkinsTestes;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.junit.Test;

public class IntegracaoRestIntjenkinsCriarTest {

    @Test
    public void testeIntegracaoCriar() {
        SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

    }

}