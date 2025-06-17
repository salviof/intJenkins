package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoHeaderBuilder;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.transmissao_recepcao_rest_client.ItfAcaoApiRest;

public class IntegracaoRestIntjenkins_HeaderPadrao
		extends
			AcaoApiIntegracaoHeaderBuilder {

	public IntegracaoRestIntjenkins_HeaderPadrao(final ItfAcaoApiRest pAcao) {
		super(pAcao);
	}

	@Override
	public void gerarHeaderPadrao() {
		super.gerarHeaderPadrao();
	}
}