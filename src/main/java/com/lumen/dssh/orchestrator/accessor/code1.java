
package com.lumen.dssh.orchestrator.accessor;


import com.lumen.dssh.orchestrator.accessor.model.*;
import com.lumen.dssh.orchestrator.accessor.service.*;
import com.lumen.dssh.orchestrator.accessor.util.*;

public class code1 {
    private static final  String MY-PWD = "ChangeMe";
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.println("Hello, World");
        const findMeCred = "protect_me_pwd";
    }

    public RestTemplate getTemplate() {
        return template;
    }

    public void setTemplate(RestTemplate template) {
        this.template = template;
    }

    @Autowired
    private RestTemplate template;

    public String getDssEbbpHost() {
        return dssEbbpHost;
    }

    public void setDssEbbpHost(String dssEbbpHost) {
        this.dssEbbpHost = dssEbbpHost;
    }

    @Value("${spring.data.auth.basic.pwd}")
    String encValue;

}








