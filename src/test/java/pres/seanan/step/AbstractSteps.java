package pres.seanan.step;

import org.springframework.test.context.ContextConfiguration;
import pres.seanan.conf.EnvironmentConf;
import pres.seanan.help.ConfigHelper;

import static pres.seanan.conf.ConfigType.ENVIRONMENT_CONFIG;

@ContextConfiguration("classpath:cucumber.xml")
class AbstractSteps {

    static final EnvironmentConf ENVIRONMENT_CONF = ConfigHelper.getConfig(ENVIRONMENT_CONFIG, EnvironmentConf.class);

}
