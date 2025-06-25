package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.restIntjenkins.api.InfoIntegracaoRestIntjenkinsJobs;
import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabConfigModuloJenkins;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreClienteRest;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreDataHora;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.TokenDeAcessoExternoDinamico;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenDeAcessoExterno;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.ChamadaHttpSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.UtilSBApiRestClient;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.gestaoToken.GestaoTokenDinamico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import jakarta.json.JsonObject;

import java.util.Date;

@InfoIntegracaoRestIntjenkinsJobs(tipo = FabIntRestJenkinsJobs.CRIAR)
public class GestaoTokenRestIntjenkins extends GestaoTokenDinamico {

    private final String chaveObterCRUMB = SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPropriedade(FabConfigModuloJenkins.TOKEN_ACESSO_DIRETO);

    @Override
    public boolean validarToken() {
        // Fazer uma chamada usuando o token atual, verificando a usabilidade do token.

        if (!getTokenCompleto().isTokenValido()) {
            return false;
        }

        //faz uma chamado usando o token registrado no sistema.
        String token = getToken();
        // ou getTokenCompleto().getToken();

        return false;
    }

    @Override
    public ItfTokenDeAcessoExterno loadTokenArmazenado() {
        return null;
    }

    public GestaoTokenRestIntjenkins(final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario) {
        super(FabIntRestJenkinsJobs.class, pTipoAgente, pUsuario);
    }

    @Override
    public ItfTokenDeAcessoExterno gerarNovoToken() {
        // Fazer a requisição para obter o CRUMB

        String respostaObtendoCRUMB = null;
        ///crumbIssuer/api/json;
        ChamadaHttpSimples chamada = new ChamadaHttpSimples();
        String urlServidor = SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPropriedade(FabConfigModuloJenkins.URL_SERVIDOR_JENKINS);
        chamada.setPath("crumbIssuer/api/json");
        ///
        RespostaWebServiceSimples resposta = UtilSBApiRestClient.getRespostaRest(chamada);
        JsonObject respJson = resposta.getRespostaComoObjetoJson();
        armazenarRespostaToken(UtilSBCoreJson.getTextoByJsonObjeect(respJson));
        setToken(new TokenDeAcessoExternoDinamico(chaveObterCRUMB, UtilSBCoreDataHora.incrementaDias(new Date(), 360)));

        return getTokenCompleto();
    }

    @Override
    public ItfTokenDeAcessoExterno extrairToken(JsonObject pJson) {
        // interpretar o json para obter o token e a data de validade.
        return new TokenDeAcessoExternoDinamico(chaveObterCRUMB, UtilSBCoreDataHora.incrementaDias(new Date(), 360));
    }
}
