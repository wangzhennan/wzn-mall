package com.wzn.mall.entity.vo;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerRoleRelationVo
 * @author wangzhennan
 * @since 2020-04-14 22:29:24
 */
@Data
@ApiModel("ManagerRoleRelationVo" )
public class ManagerRoleRelationVo implements Serializable {
    private static final long serialVersionUID = 471618321072984370L;
        
    @ApiModelProperty("")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long managerId;
    
        
    @ApiModelProperty("")
    private Long roleId;
    
}