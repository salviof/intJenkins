package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.restIntjenkins.api.InfoIntegracaoRestIntjenkinsJobs;
import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import com.sun.tools.javac.comp.Todo;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntjenkinsJobs(tipo = FabIntRestJenkinsJobs.COPIAR)
public class IntegracaoRestIntjenkinsCopiar extends AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntjenkinsCopiar(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabIntRestJenkinsJobs.COPIAR, pTipoAgente, pUsuario, pParametro);
	}

	@Override
	public String gerarCorpoRequisicao() {
		//TODO colocar req
		return super.gerarCorpoRequisicao();
	}
}