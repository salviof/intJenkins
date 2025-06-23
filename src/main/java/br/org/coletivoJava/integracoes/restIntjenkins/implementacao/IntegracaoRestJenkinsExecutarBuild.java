package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.restIntjenkins.api.InfoIntegracaoRestIntjenkinsJobs;
import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntjenkinsJobs(tipo = FabIntRestJenkinsJobs.EXECUTAR_BUILD)
public class IntegracaoRestJenkinsExecutarBuild
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestJenkinsExecutarBuild(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabIntRestJenkinsJobs.EXECUTAR_BUILD, pTipoAgente, pUsuario,
                pParametro);
    }

    @Override
    public String gerarUrlRequisicao() {
        String url;
        if(getParametros().length > 0 && getParametros()[0] != null) {
            url = super.getUrlServidor();
        } else {
            url = getUrlServidor() + infoRest.getPachServico();
            url = url.replace("{0}/", "");
        }
            System.out.println("Url");
        return url;
    }

//    @Override
//    protected RespostaWebServiceSimples gerarRespostaTratamentoFino(RespostaWebServiceSimples pRespostaWSSemTratamento) {
//        return super.gerarRespostaTratamentoFino(pRespostaWSSemTratamento);
//    }
}