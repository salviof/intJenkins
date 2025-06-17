package br.org.coletivoJava.integracoes.restJenkins.implementacao;

import br.org.coletivoJava.integracoes.restJenkins.api.InfoIntegracaoRestJenkinsJobs;
import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestJenkinsJobs(tipo = FabIntRestJenkinsJobs.EXECUTAR_BUILD)
public class IntegracaoRestJenkinsExecutarBuild
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestJenkinsExecutarBuild(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabIntRestJenkinsJobs.EXECUTAR_BUILD, pTipoAgente, pUsuario,
				pParametro);
	}
}