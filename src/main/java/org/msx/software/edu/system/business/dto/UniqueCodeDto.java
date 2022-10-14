package org.msx.software.edu.system.business.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.msx.software.edu.system.business.util.CodingUtil;

@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class UniqueCodeDto {

    private final String originalCode;
    private final long id;
    private final String code;
    private final int version;

    public String getIrdi() {
        return CodingUtil.mixIrdiCodePart(this.code, this.version);
    }
}
