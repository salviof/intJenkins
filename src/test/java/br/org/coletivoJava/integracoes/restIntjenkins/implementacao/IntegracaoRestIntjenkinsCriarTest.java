package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import com.super_bits.Super_Bits.jenkins.configAppp.ConfiguradorCoreJenkinsTestes;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IntegracaoRestIntjenkinsCriarTest {

    @Test
    public void testeIntegracaoCriar() {
        SBCore.configurar(new ConfiguradorCoreJenkinsTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        String nomeProjeto = "projetoTeste";
        ItfRespostaWebServiceSimples resposta = FabIntRestJenkinsJobs.CRIAR.getAcao(nomeProjeto).getResposta();
        assertTrue(resposta.isSucesso());
    }
}