package dto;

import java.time.LocalDateTime;

public record GameDto(Long id, String title, String publisher, LocalDateTime release, String synopsis) {
}
