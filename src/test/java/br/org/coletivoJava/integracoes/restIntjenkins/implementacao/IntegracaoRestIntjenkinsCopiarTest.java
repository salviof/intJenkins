package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabConfigModuloJenkins;
import com.super_bits.Super_Bits.jenkins.configAppp.ConfiguradorCoreJenkinsTestes;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import junit.framework.TestCase;
import org.junit.Test;

public class IntegracaoRestIntjenkinsCopiarTest {

    @Test
    public void testeIntegracaoCopiar() {
        SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

    }

}