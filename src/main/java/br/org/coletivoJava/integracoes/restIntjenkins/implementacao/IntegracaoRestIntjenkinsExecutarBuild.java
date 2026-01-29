package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import br.org.coletivoJava.integracoes.restIntjenkins.api.InfoIntegracaoRestIntjenkinsJobs;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

@InfoIntegracaoRestIntjenkinsJobs(tipo = FabIntRestJenkinsJobs.EXECUTAR_BUILD)
public class IntegracaoRestIntjenkinsExecutarBuild
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntjenkinsExecutarBuild(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabIntRestJenkinsJobs.EXECUTAR_BUILD, pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        return "";
    }
}