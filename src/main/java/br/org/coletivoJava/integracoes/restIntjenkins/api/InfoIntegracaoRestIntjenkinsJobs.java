package br.org.coletivoJava.integracoes.restIntjenkins.api;

import javax.inject.Qualifier;
import br.org.coletivoJava.integracoes.jenkins.regras_de_negocio_e_controller.FabIntRestJenkinsJobs;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface InfoIntegracaoRestIntjenkinsJobs {

	FabIntRestJenkinsJobs tipo();
}