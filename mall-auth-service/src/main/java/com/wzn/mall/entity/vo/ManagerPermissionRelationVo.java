package com.wzn.mall.entity.vo;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerPermissionRelationVo
 * @author wzn
 * @since 2020-04-12 16:58:54
 */
@Data
@ApiModel("ManagerPermissionRelationVo" )
public class ManagerPermissionRelationVo implements Serializable {
    private static final long serialVersionUID = -70049393594378459L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
        
    @ApiModelProperty("$column.comment")
    private Long managerId;
    
        
    @ApiModelProperty("$column.comment")
    private Long permissionId;
    
        
    @ApiModelProperty("$column.comment")
    private Integer type;
    
}