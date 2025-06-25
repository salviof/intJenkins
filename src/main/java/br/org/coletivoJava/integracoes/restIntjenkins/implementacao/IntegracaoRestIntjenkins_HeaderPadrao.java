package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabConfigModuloJenkins;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoHeaderBuilder;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.transmissao_recepcao_rest_client.ItfAcaoApiRest;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class IntegracaoRestIntjenkins_HeaderPadrao
        extends
        AcaoApiIntegracaoHeaderBuilder {

    public IntegracaoRestIntjenkins_HeaderPadrao(final ItfAcaoApiRest pAcao) {
        super(pAcao);
    }

    @Override
    public void gerarHeaderPadrao() {
        super.gerarHeaderPadrao();
        String usuario = "admin";

        String token = SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPropriedade(FabConfigModuloJenkins.TOKEN_ACESSO_DIRETO);

        String credenciais = usuario + ":" + token;

        String encoded = Base64.getEncoder().encodeToString(credenciais.getBytes(StandardCharsets.UTF_8));

        System.out.println("encoded: " + encoded);
        cabecalho.put("Authorization", "Basic " + encoded);
    }
}