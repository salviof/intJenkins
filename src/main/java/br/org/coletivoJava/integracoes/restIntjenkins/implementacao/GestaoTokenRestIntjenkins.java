package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabConfigModuloJenkins;
import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import br.org.coletivoJava.integracoes.restIntjenkins.api.InfoIntegracaoRestIntjenkinsJobs;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreDataHora;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.FabTipoConexaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenDeAcessoExterno;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.TokenDeAcessoExternoDinamico;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.ChamadaHttpSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.UtilSBApiRestClient;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.gestaoToken.GestaoTokenDinamico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import jakarta.json.JsonObject;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@InfoIntegracaoRestIntjenkinsJobs(tipo = FabIntRestJenkinsJobs.CRIAR)
public class GestaoTokenRestIntjenkins extends GestaoTokenDinamico {

    private final String chaveObterCRUMB = SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPropriedade(FabConfigModuloJenkins.TOKEN_ACESSO_DIRETO);
    private final String urlServidor = SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPropriedade(FabConfigModuloJenkins.URL_SERVIDOR_JENKINS);

    @Override
    public boolean validarToken() {
        // Fazer uma chamada usuando o token atual, verificando a usabilidade do token.

        if (!getTokenCompleto().isTokenValido()) {
            return false;
        }

        //faz uma chamado usando o token registrado no sistema.
        String token = getToken();
        if(getToken() != null) {
            return true;
        }
        return false;
    }

    @Override
    public ItfTokenDeAcessoExterno loadTokenArmazenado() {
        return getTokenCompleto();
    }

    public GestaoTokenRestIntjenkins(final FabTipoAgenteClienteApi pTipoAgente,
                                     final ItfUsuario pUsuario) {
        super(FabIntRestJenkinsJobs.class, pTipoAgente, pUsuario);
    }

    @Override
    public ItfTokenDeAcessoExterno gerarNovoToken() {
        // Fazer a requisição para obter o CRUMB

        String respostaObtendoCRUMB = null;
        ChamadaHttpSimples chamada = new ChamadaHttpSimples();

        Map<String, String> cabecalho = new HashMap<>();
        String credenciais = SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPropriedade(FabConfigModuloJenkins.USUARIO_ADMIN) + ":" + SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPropriedade(FabConfigModuloJenkins.TOKEN_ACESSO_DIRETO);
        String encoded = Base64.getEncoder().encodeToString(credenciais.getBytes(StandardCharsets.UTF_8));

        cabecalho.put("Authorization", "Basic " + encoded);
        chamada.setPath("/crumbIssuer/api/json");
        chamada.setEnderecoHost(urlServidor);
        chamada.setTipoConexao(FabTipoConexaoRest.GET);
        chamada.setCabecalhos(cabecalho);

        RespostaWebServiceSimples resposta = UtilSBApiRestClient.getRespostaRest(chamada);
        JsonObject respJson = resposta.getRespostaComoObjetoJson();
        armazenarRespostaToken(UtilSBCoreJson.getTextoByJsonObjeect(respJson));
        setToken(new TokenDeAcessoExternoDinamico(respJson.getString("crumb"), UtilSBCoreDataHora.incrementaDias(new Date(), 360)));

        return getTokenCompleto();
    }

    @Override
    public ItfTokenDeAcessoExterno extrairToken(JsonObject pJson) {
        // interpretar o json para obter o token e a data de validade.
        System.out.println("Token do getToken(): " + getToken());
        System.out.println("token vindo do final: " + chaveObterCRUMB);
        return new TokenDeAcessoExternoDinamico(chaveObterCRUMB, UtilSBCoreDataHora.incrementaDias(new Date(), 360));
    }
}
