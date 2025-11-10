package io.github.viimeinen1.amsg;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

/**
 * Messaging library with prefixes.
 */
public class aMsg extends JavaPlugin {

    /** 
     * Empty constructor. 
     * All methods are static.
     * Use {@link aMsg.Msg} if you require multiple prefixes.
    */
    public aMsg() {}

    private static Component pluginPrefix = Component.empty();

    /**
     * Get used prefix in messages.
     * 
     * @return plugin prefix
     */
    public static Component prefix() {return pluginPrefix;}

    /**
     * Set used prefix in messages.
     * Prefix is global. Use {@link aMsg.Msg} if you require multiple different prefixes.
     * 
     * @param prefix plugin prefix
     */
    public static void prefix(@NotNull Component prefix) {pluginPrefix = prefix;}

    /**
     * Send message to audience.
     * 
     * Uses default plugin prefix.
     * 
     * @param <T> {@link Component} and/or {@link String}
     * @param audience target audience
     * @param content content of message
     */
    @SafeVarargs
    public static <T> void send(@NotNull Audience audience, @NotNull T... content) {
        send(pluginPrefix, audience, content);
    }

     /**
      * Send message to audience using custom prefix. 
      *
      * @param <T> {@link Component} and/or {@link String}
      * @param prefix Custom prefix
      * @param audience target audience
      * @param content content of message
      */
    @SafeVarargs
    public static <T> void send(@NotNull Component prefix, @NotNull Audience audience, @NotNull T... content) {
        if (content == null) {audience.sendMessage(prefix); return;}
        for (T c : content) {
            switch (c) {
                case String str -> {
                    Component com = mm(str);
                    audience.sendMessage(prefix.append(com));
                }
                case Component com -> {
                    audience.sendMessage(prefix.append(com));
                }
                default -> {}
            }
        }
    }

    /**
     * Deserialize message using MiniMessage.
     * Shortened version for {@code MiniMessage.miniMessage().deserialize(message)}
     * 
     * @param message Message to be deserialized.
     * @return deserialized message
     */
    public static Component mm(String message) {
        return MiniMessage.miniMessage().deserialize(message);
    }

    /**
     * Non-static version of {@link aMsg}
     */
    public final class Msg {

        /**
         * Create new Msg instance.
         * Is exactly the same as {@link aMsg}, but non-static, so prefix is unique to this instance.
         */
        public Msg() {}

        /**
         * Create new Msg instance.
         * 
         * @param prefix prefix of messages sent with this instance.
         */
        public Msg(@NotNull Component prefix) {
            this.pluginPrefix = prefix;
        }

        private Component pluginPrefix = Component.empty();

        /**
         * Get used prefix in messages.
         * 
         * @return plugin prefix
         */
        public Component prefix() {return this.pluginPrefix;}

        /**
         * Set used prefix in messages.
         * 
         * @param prefix plugin prefix
         */
        public void prefix(@NotNull Component prefix) {this.pluginPrefix = prefix;}

        /**
         * Send message to audience.
         * 
         * Uses default plugin prefix.
         * 
         * @param <T> {@link Component} and/or {@link String}
         * @param audience target audience
         * @param content content of message
         */
        @SafeVarargs
        public final <T> void send(@NotNull Audience audience, @NotNull T... content) {
            send(this.pluginPrefix, audience, content);
        }

        /**
         * Send message to audience using custom prefix. 
        *
        * @param <T> {@link Component} and/or {@link String}
        * @param prefix Custom prefix
        * @param audience target audience
        * @param content content of message
        */
        @SafeVarargs
        public final <T> void send(@NotNull Component prefix, @NotNull Audience audience, @NotNull T... content) {
            if (content == null) {audience.sendMessage(prefix); return;}
            for (T c : content) {
                switch (c) {
                    case String str -> {
                        Component com = mm(str);
                        audience.sendMessage(prefix.append(com));
                    }
                    case Component com -> {
                        audience.sendMessage(prefix.append(com));
                    }
                    default -> {}
                }
            }
        }

    }
}