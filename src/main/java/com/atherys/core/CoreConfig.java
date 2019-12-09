package com.atherys.core;

import com.atherys.core.config.RedisConfig;
import com.atherys.core.config.JPAConfig;
import com.atherys.core.utils.PluginConfig;
import ninja.leaping.configurate.objectmapping.Setting;

import java.io.IOException;

public class CoreConfig extends PluginConfig {

    @Setting("is-default")
    public boolean IS_DEFAULT = true;

    @Setting("db-enabled")
    public boolean DB_ENABLED = true;

    @Setting("jpa")
    public JPAConfig JPA_CONFIG = new JPAConfig();

    @Setting("redis")
    public RedisConfig CACHE_CONFIG = new RedisConfig();

    protected CoreConfig() throws IOException {
        super("config/" + AtherysCore.ID, "config.conf");
    }
}
