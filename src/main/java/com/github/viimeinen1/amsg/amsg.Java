package com.github.viimeinen1.amsg;

import org.jetbrains.annotations.NotNull;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

/**
 * Util for messaging player
 */
public class amsg {

    private static Component prefix = Component.empty();

    public static Component prefix() {return prefix;}
    public static void prefix(@NotNull Component prefix) {this.prefix = prefix;}

    /**
     * Send message to player.
     * 
     * Uses default plugin prefix.
     * 
     * @param <T>
     * @param sender
     * @param content
     */
    @SafeVarargs
    public static <T> void send(@NotNull Audience sender, @NotNull T... content) {
        send(config.prefix, sender, content);
    }

    /**
     * Send message to player using prefix
     * 
     * @param sender who we send the message to
     * @param str message
     * @param prefix prefix of the message
     */
    @SafeVarargs
    public static <T> void send(@NotNull Component prefix, @NotNull Audience sender, @NotNull T... content) {
        if (content == null) {sender.sendMessage(prefix); return;}
        for (T c : content) {
            switch (c) {
                case String str -> {
                    Component com = mm(str);
                    sender.sendMessage(prefix.append(com));
                }
                case Component com -> {
                    sender.sendMessage(prefix.append(com));
                }
                default -> {}
            }
        }
    }

    /**
     * Deserialize message using MiniMessage
     * 
     * @param message
     * @return deserialized message
     */
    public static Component mm(String message) {
        return MiniMessage.miniMessage().deserialize(message);
    }
}