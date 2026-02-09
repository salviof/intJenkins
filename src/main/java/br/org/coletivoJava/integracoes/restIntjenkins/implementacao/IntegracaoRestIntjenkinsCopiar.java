package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import br.org.coletivoJava.integracoes.restIntjenkins.api.InfoIntegracaoRestIntjenkinsJobs;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
<<<<<<< HEAD

import java.util.HashMap;
import java.util.Map;
=======
>>>>>>> 0d5ce635c2d98e96318aade010db66a1533166da

@InfoIntegracaoRestIntjenkinsJobs(tipo = FabIntRestJenkinsJobs.COPIAR)
public class IntegracaoRestIntjenkinsCopiar extends AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntjenkinsCopiar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ComoUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabIntRestJenkinsJobs.COPIAR, pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        return "";
    }
}