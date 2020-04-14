package com.wzn.mall.entity.vo;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerPermissionRelationVo
 * @author wangzhennan
 * @since 2020-04-14 22:29:24
 */
@Data
@ApiModel("ManagerPermissionRelationVo" )
public class ManagerPermissionRelationVo implements Serializable {
    private static final long serialVersionUID = 736219584397202695L;
        
    @ApiModelProperty("")
    private Long id;
    
        
    @ApiModelProperty("")
    private Long managerId;
    
        
    @ApiModelProperty("")
    private Long permissionId;
    
        
    @ApiModelProperty("")
    private Integer type;
    
}