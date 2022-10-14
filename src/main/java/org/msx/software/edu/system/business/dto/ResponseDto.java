package org.msx.software.edu.system.business.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.msx.software.edu.system.business.dto.util.MasterDto;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto extends MasterDto {

    private boolean hasError;
    private int responseCode;
    private String responsePhrase;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String messageCode;
    private int length;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object result;
}