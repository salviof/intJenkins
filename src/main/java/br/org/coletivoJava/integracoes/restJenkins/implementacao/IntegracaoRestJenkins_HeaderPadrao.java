package br.org.coletivoJava.integracoes.restJenkins.implementacao;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoHeaderBuilder;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.transmissao_recepcao_rest_client.ItfAcaoApiRest;

public class IntegracaoRestJenkins_HeaderPadrao
		extends
			AcaoApiIntegracaoHeaderBuilder {

	public IntegracaoRestJenkins_HeaderPadrao(final ItfAcaoApiRest pAcao) {
		super(pAcao);
	}
}