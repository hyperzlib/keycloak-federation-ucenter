package cn.isekai.keycloak.federation.ucenter;

import org.jboss.logging.Logger;
import org.keycloak.Config;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;
import org.keycloak.storage.UserStorageProviderFactory;

import java.util.List;

public class UCenterFederationProviderFactory implements UserStorageProviderFactory<UCenterFederationProvider> {
    private static final Logger logger = Logger.getLogger(UCenterFederationProviderFactory.class);
    public static final String PROVIDER_NAME = "ucenter";

    @Override
    public UCenterFederationProvider create(KeycloakSession session, ComponentModel model) {
        return new UCenterFederationProvider(session, model, this);
    }

    @Override
    public String getId() {
        return PROVIDER_NAME;
    }

    @Override
    public String getHelpText() {
        return "Migrate users from UCenter database";
    }

    protected static final List<ProviderConfigProperty> configProperties;

    static {
        configProperties = getConfigProps();
    }

    private static List<ProviderConfigProperty> getConfigProps() {
        return ProviderConfigurationBuilder.create()
                .property().name("datasource-name")
                .label("DataSource Name")
                .defaultValue("java:jboss/datasources/UCenter-Federation")
                .type(ProviderConfigProperty.STRING_TYPE)
                .add()
                .property().name("table-prefix")
                .label("Table Prefix")
                .defaultValue("uc_")
                .type(ProviderConfigProperty.STRING_TYPE)
                .add()
                .build();
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return configProperties;
    }


    @Override
    public void init(Config.Scope config) {

    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {

    }

    @Override
    public void close() {

    }
}
