package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import br.org.coletivoJava.integracoes.restIntjenkins.api.InfoIntegracaoRestIntjenkinsJobs;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

import java.util.HashMap;
import java.util.Map;

@InfoIntegracaoRestIntjenkinsJobs(tipo = FabIntRestJenkinsJobs.COPIAR)
public class IntegracaoRestIntjenkinsCopiar extends AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntjenkinsCopiar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabIntRestJenkinsJobs.COPIAR, pTipoAgente, pUsuario, pParametro);
    }

//    @Override
//    public Map<String, String> gerarCabecalho() {
//        Map<String, String> crumb = new HashMap<>();
//        ItfRespostaWebServiceSimples token = FabIntRestJenkinsJobs.CRUMB_ACESSO.getAcao().getResposta();
//        String valorTokenCrumb = token.getRespostaComoObjetoJson().getString("crumb");
//
//        crumb.put("Jenkins-Crumb", valorTokenCrumb);
//        return super.gerarCabecalho();
//    }


    @Override
    public String gerarCorpoRequisicao() {
        return "";
    }
}