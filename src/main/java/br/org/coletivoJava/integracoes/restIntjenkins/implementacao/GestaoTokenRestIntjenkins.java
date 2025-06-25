package br.org.coletivoJava.integracoes.restIntjenkins.implementacao;

import br.org.coletivoJava.integracoes.restIntjenkins.api.InfoIntegracaoRestIntjenkinsJobs;
import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabConfigModuloJenkins;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreDataHora;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.TokenDeAcessoExternoChavePublicaPrivada;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.TokenDeAcessoExternoDinamico;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.gestaoToken.GestaoTokenChaveUnica;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenDeAcessoExterno;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

import java.util.Date;

@InfoIntegracaoRestIntjenkinsJobs(tipo = FabIntRestJenkinsJobs.CRIAR)
public class GestaoTokenRestIntjenkins extends GestaoTokenChaveUnica {

    @Override
    public boolean validarToken() {
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
        String token = SBCore.getConfigModulo(FabConfigModuloJenkins.class).getPropriedade(FabConfigModuloJenkins.TOKEN_ACESSO_DIRETO);
        setToken(new TokenDeAcessoExternoDinamico(token, UtilSBCoreDataHora.incrementaDias(new Date(), 360)));
        return getTokenCompleto();
    }
}