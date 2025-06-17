package br.org.coletivoJava.integracoes.restJenkins.implementacao;

import br.org.coletivoJava.integracoes.restJenkins.api.InfoIntegracaoRestJenkinsJobs;
import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabConfigModuloJenkins;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.gestaoToken.GestaoTokenChaveUnica;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenDeAcessoExterno;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestJenkinsJobs(tipo = FabIntRestJenkinsJobs.CRIAR)
public class GestaoTokenRestJenkins extends GestaoTokenChaveUnica {

	@Override
	public ItfTokenDeAcessoExterno loadTokenArmazenado() {
		return null;
	}

	@Override
	public boolean validarToken() {
		return false;
	}

	public GestaoTokenRestJenkins(final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario) {
		super(FabIntRestJenkinsJobs.class, pTipoAgente, pUsuario);
	}
}