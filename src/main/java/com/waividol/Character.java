package com.waividol;

import java.util.List;

public record Character(
        String id, String name, String role, String group, String type, String tagline,
        String bio, String story, String avatar, String color, String portrait,
        List<String> images, String video, String source, List<Unlock> unlock) {
    public record Unlock(String id, String title, String kind, int cost) {}
}
