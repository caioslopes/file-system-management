package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Game {

    private Long id;
    private String title;
    private String publisher;
    private LocalDateTime release;
    private String synopsis;
    private Map<String, String> requirement;
    private Collection<String> platform;

    public Game(Long id, String title, String publisher, LocalDateTime release, String synopsis, Map<String, String> requirement, Collection<String> platform) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.release = release;
        this.synopsis = synopsis;
        this.requirement = requirement;
        this.platform = platform;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDateTime getRelease() {
        return release;
    }

    public void setRelease(LocalDateTime release) {
        this.release = release;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Map<String, String> getRequirement() {
        return requirement;
    }

    public void setRequirement(Map<String, String> requirement) {
        this.requirement = requirement;
    }

    public Collection<String> getPlatform() {
        return platform;
    }

    public void setPlatform(Collection<String> platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return String.format("%d;%s;%s;%s;%s", id, title, publisher, release, synopsis);
    }

    public static class Builder{

        private static Long SEQUENCE = 1L;

        private Long id;
        private String title;
        private String publisher;
        private LocalDateTime release;
        private String synopsis;
        private Map<String, String> requirement = new HashMap<>();
        private Collection<String> platform = new ArrayList<>();

        public Builder() {
            this.id = SEQUENCE++;
            this.title = "not defined";
            this.publisher = "not defined";
            this.release = LocalDateTime.now();
            this.synopsis = "not defined";
            this.requirement = new HashMap<>();
            this.platform = new ArrayList<>();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder release(LocalDateTime release) {
            this.release = release;
            return this;
        }

        public Builder synopsis(String synopsis) {
            this.synopsis = synopsis;
            return this;
        }

        public Builder requirement(Map<String, String> requirement) {
            this.requirement = requirement;
            return this;
        }

        public Builder platform(Collection<String> platform) {
            this.platform = platform;
            return this;
        }

        public Game build() {
            return new Game(this.id, this.title, this.publisher, this.release, this.synopsis, this.requirement, this.platform);
        }

        public Game fromString(String[] string) {
            return new Game(Long.parseLong(string[0]), string[1], string[2], LocalDateTime.parse(string[3]), string[4], this.requirement, this.platform);
        }

    }
}
