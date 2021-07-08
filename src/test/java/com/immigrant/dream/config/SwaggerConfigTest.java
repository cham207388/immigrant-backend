package com.immigrant.dream.config;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SwaggerConfigTest {

    private final SwaggerConfig swaggerConfig = new SwaggerConfig();

    @Test
    public void test(){
        assertNotNull(swaggerConfig.api());
    }
}