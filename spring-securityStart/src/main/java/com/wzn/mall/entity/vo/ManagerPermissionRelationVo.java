package com.wzn.mall.entity.vo;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * ManagerPermissionRelationVo
 * @author wzn
 * @since 2020-04-14 21:53:19
 */
@Data
@ApiModel("ManagerPermissionRelationVo" )
public class ManagerPermissionRelationVo implements Serializable {
    private static final long serialVersionUID = 713252153168640445L;
        
    @ApiModelProperty("$column.comment")
    private Long id;
    
        
    @ApiModelProperty("$column.comment")
    private Long managerId;
    
        
    @ApiModelProperty("$column.comment")
    private Long permissionId;
    
        
    @ApiModelProperty("$column.comment")
    private Integer type;
    
}