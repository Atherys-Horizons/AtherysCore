package com.atherys.core.commands;

import com.atherys.core.damage.AtherysDamageType;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.text.Text;

import java.util.Optional;

public class TempAtherysDamageCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if ( !(src instanceof Player) ) {
            Optional<Player> player = args.getOne( Text.of( "player" ) );
            Optional<AtherysDamageType> damageType = args.getOne( Text.of( "type" ) );
            Optional<Double> amount = args.getOne( Text.of( "amount" ) );

            if ( !player.isPresent() || !damageType.isPresent() ) return CommandResult.empty();

            player.get().damage( amount.orElse(0.0d), DamageSource.builder().type( damageType.get() ).build() );
        }
        return CommandResult.empty();
    }

    public CommandSpec getSpec() {
        return CommandSpec.builder()
                .arguments(
                        GenericArguments.playerOrSource( Text.of("player") ),
                        GenericArguments.catalogedElement( Text.of("type"), AtherysDamageType.class ),
                        GenericArguments.doubleNum( Text.of("amount") )
                )
                .executor( this )
                .build();
    }

}