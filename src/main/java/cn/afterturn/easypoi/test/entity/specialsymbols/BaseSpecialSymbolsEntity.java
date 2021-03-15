package cn.afterturn.easypoi.test.entity.specialsymbols;

import cn.afterturn.easypoi.entity.SpecialSymbolsEnum;
import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author JueYue
 * @date 2021-03-21-3-12
 * @since 1.0
 */
@Data
public class BaseSpecialSymbolsEntity {

    @Excel(name = "小方块")
    private SpecialSymbolsEnum smallBox;
    @Excel(name = "大方块")
    private SpecialSymbolsEnum bigBox;
}
