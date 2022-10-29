
package com.osvaldo.metaphorce.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Builder
public class PageDto {

    private int size;
    private long totalElements;
    private long totalPages;
    private int number;

}
