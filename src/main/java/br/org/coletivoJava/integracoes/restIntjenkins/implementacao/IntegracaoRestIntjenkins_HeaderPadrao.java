package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabConfigModuloJenkins;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoHeaderBuilder;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.transmissao_recepcao_rest_client.ItfAcaoApiRest;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class IntegracaoRestIntjenkins_HeaderPadrao
        extends
        AcaoApiIntegracaoHeaderBuilder {

    public IntegracaoRestIntjenkins_HeaderPadrao(final ItfAcaoApiRest pAcao) {
        super(pAcao);
    }

    @Override
    public void gerarHeaderPadrao() {
        super.gerarHeaderPadrao();

        String token = SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPropriedade(FabConfigModuloJenkins.TOKEN_ACESSO_DIRETO);
        String usuario = SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPropriedade(FabConfigModuloJenkins.USUARIO_ADMIN);
        String credenciais = usuario + ":" + token;

        String encoded = Base64.getEncoder().encodeToString(credenciais.getBytes(StandardCharsets.UTF_8));

        System.out.println("encoded: " + encoded);
        cabecalho.put("Authorization", "Basic " + encoded);
        String crumb = acao.getTokenGestao().getToken();
        cabecalho.put("jenkinscrumb", crumb);
    }

    @Override
    public Map<String, String> getHeaderPadrao() {
        Map<String, String> headerPadrao = new HashMap<>();
        headerPadrao.put("SEGREDO", SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPropriedade(FabConfigModuloJenkins.CHAVE_ACESSO_SERVIDOR));
        return headerPadrao;
    }
}
