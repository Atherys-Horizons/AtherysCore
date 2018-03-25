package com.atherys.core.damage.sources;

import com.atherys.core.damage.AtherysDamageType;
import org.spongepowered.api.event.cause.entity.damage.source.common.AbstractIndirectEntityDamageSource;

public class AtherysIndirectEntityDamageSourceBuilder extends AbstractIndirectEntityDamageSource.AbstractIndirectEntityDamageSourceBuilder<AtherysIndirectEntityDamageSource,AtherysIndirectEntityDamageSourceBuilder> {

    private AtherysDamageType type;

    @Override
    public AtherysIndirectEntityDamageSource build () throws IllegalStateException {
        return new AtherysIndirectEntityDamageSource( this, type );
    }

    public AtherysIndirectEntityDamageSourceBuilder atherysType ( AtherysDamageType type ) {
        this.type = type;
        return this;
    }
}
