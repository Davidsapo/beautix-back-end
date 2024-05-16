package com.beautix.backend.core.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Common DTO
 *
 * @author David Sapozhnik
 */
@Getter
@Setter
public class CommonDTO {

    private Long id;
    private LocalDateTime createdAt;
}
