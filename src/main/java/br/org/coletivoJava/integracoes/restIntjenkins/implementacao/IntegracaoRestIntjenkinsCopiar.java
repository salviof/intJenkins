package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import br.org.coletivoJava.integracoes.restIntjenkins.api.InfoIntegracaoRestIntjenkinsJobs;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.FabTipoConexaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntjenkinsJobs(tipo = FabIntRestJenkinsJobs.COPIAR)
public class IntegracaoRestIntjenkinsCopiar extends AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntjenkinsCopiar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabIntRestJenkinsJobs.COPIAR, pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public FabTipoConexaoRest gerarTipoRequisicao() {
        return super.gerarTipoRequisicao();
    }

    @Override
    public String gerarUrlRequisicao() {
        String url;
        if (getParametros().length > 0 && getParametros()[0] != null && getParametros()[1] != null) {
            url = super.gerarUrlRequisicao();
        } else {
            url = getUrlServidor() + infoRest.getPachServico();
            url = url.replace("?name={0}&mode=copy&from={1}", "");
        }
        System.out.println("Url: " + url);
        return url;
    }

    @Override
    public String gerarCorpoRequisicao() {
        return "";
    }
}